package com.uniai.uniguard.dpc

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.os.SystemClock
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.work.Worker
import androidx.work.WorkerParameters

class OfflineLockWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val masterKey = MasterKey.Builder(applicationContext, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        
        val sharedPrefs = EncryptedSharedPreferences.create(
            applicationContext,
            "offline_lock_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        val currentRealtime = SystemClock.elapsedRealtime()
        val lastRealtime = sharedPrefs.getLong("last_elapsed_realtime", currentRealtime)
        var accumulated = sharedPrefs.getLong("accumulated_uptime_millis", 0L)

        if (currentRealtime >= lastRealtime) {
            accumulated += (currentRealtime - lastRealtime)
        } else {
            // Reboot happened
            accumulated += currentRealtime
        }

        sharedPrefs.edit()
            .putLong("last_elapsed_realtime", currentRealtime)
            .putLong("accumulated_uptime_millis", accumulated)
            .apply()

        val uptimeHours = accumulated / (1000 * 60 * 60)
        
        if (uptimeHours >= 72L) {
            lockDevice()
        }
        
        return Result.success()
    }

    private fun lockDevice() {
        val dpm = applicationContext.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val componentName = ComponentName(applicationContext, UniGuardDeviceAdminReceiver::class.java)
        if (dpm.isAdminActive(componentName)) {
            dpm.lockNow()
        }
    }
}
