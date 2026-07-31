package com.uniai.uniguard.dpc

import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.UserManager
import android.widget.Toast

class UniGuardDeviceAdminReceiver : DeviceAdminReceiver() {
    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        Toast.makeText(context, "Device Admin Enabled", Toast.LENGTH_SHORT).show()
        
        val dpm = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val componentName = ComponentName(context, UniGuardDeviceAdminReceiver::class.java)
        
        dpm.setLockTaskPackages(componentName, arrayOf(context.packageName))
        dpm.addUserRestriction(componentName, UserManager.DISALLOW_FACTORY_RESET)
        dpm.addUserRestriction(componentName, UserManager.DISALLOW_SAFE_BOOT)
    }

    override fun onDisabled(context: Context, intent: Intent) {
        super.onDisabled(context, intent)
        Toast.makeText(context, "Device Admin Disabled", Toast.LENGTH_SHORT).show()
        
        val dpm = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val componentName = ComponentName(context, UniGuardDeviceAdminReceiver::class.java)
        
        dpm.clearUserRestriction(componentName, UserManager.DISALLOW_FACTORY_RESET)
        dpm.clearUserRestriction(componentName, UserManager.DISALLOW_SAFE_BOOT)
    }
}
