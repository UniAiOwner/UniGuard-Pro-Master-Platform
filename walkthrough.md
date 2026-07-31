# 🛡️ UniGuard Pro — Production Hardening & Gap Resolution Plan

> **Artifact Location:** `<Artifact Directory>/production_hardening_and_gap_resolution_plan.md`  
> **Audit Status:** 🔍 **360° RESEARCH AUDIT COMPLETED BY AGENCY SUBAGENTS**  
> **Goal:** Eliminate all identified stubs, math flaws, and security gaps to achieve 100% Commercial Production Standard.

---

## 🔬 1. Audit Findings & Gap Resolution Strategy

Our Agency Research Subagents conducted an exhaustive audit of all research volumes and codebase modules. Below are the 5 critical gaps identified and our concrete resolution plan:

---

### 🟢 Gap 1: 72-Hour Offline Hard-Lock Monotonic Boot Math (`OfflineLockWorker.kt`)

- 🛑 **The Flaw:** `SystemClock.elapsedRealtime()` resets to 0 on phone reboot. A customer rebooting every 48 hours could bypass the offline lock indefinitely.
- ⚡ **Production Fix:** Implement cumulative boot uptime persistence math in `EncryptedSharedPreferences`:
  ```kotlin
  val lastKnownUptime = encryptedPrefs.getLong("LAST_UPTIME_MS", 0L)
  val totalAccumulatedOffline = encryptedPrefs.getLong("TOTAL_OFFLINE_MS", 0L)
  val delta = currentElapsedRealtime - lastKnownUptime
  val newTotalOffline = totalAccumulatedOffline + delta
  encryptedPrefs.edit().putLong("TOTAL_OFFLINE_MS", newTotalOffline).apply()
  if (newTotalOffline >= 72 * 3600 * 1000L) {
      enforceHardLock()
  }
  ```

---

### 🟢 Gap 2: DPC Hardware Lock Task & FRP Protection (`uniai-dpc-android`)

- 🛑 **The Flaw:** `DevicePolicyManager` APIs were not fully invoked to lock system bars and disallow factory resets.
- ⚡ **Production Fix:** Implement concrete DPM policy enforcement in `UniGuardAdminReceiver.kt`:
  ```kotlin
  dpm.setLockTaskPackages(adminComponent, arrayOf(context.packageName))
  dpm.addUserRestriction(adminComponent, UserManager.DISALLOW_FACTORY_RESET)
  dpm.addUserRestriction(adminComponent, UserManager.DISALLOW_SAFE_BOOT)
  dpm.setKeyguardDisabled(adminComponent, true)
  ```

---

### 🟢 Gap 3: Razorpay Webhook HmacSHA256 Signature Verification (`uniai-backend-core`)

- 🛑 **The Flaw:** Webhook endpoint accepted webhooks without signature validation.
- ⚡ **Production Fix:** Implement HmacSHA256 signature verification in `PaymentWebhookController.kt`:
  ```kotlin
  fun verifySignature(payload: String, signature: String, secret: String): Boolean {
      val hmac = Mac.getInstance("HmacSHA256")
      hmac.init(SecretKeySpec(secret.toByteArray(), "HmacSHA256"))
      val calculatedBytes = hmac.doFinal(payload.toByteArray())
      val calculatedHex = Hex.encodeHexString(calculatedBytes)
      return calculatedHex.equals(signature, ignoreCase = true)
  }
  ```

---

### 🟢 Gap 4: PostgreSQL R2DBC Row-Level Security (RLS) Tenant Filter

- 🛑 **The Flaw:** Queries ran without setting `tenant_id` session context in PostgreSQL.
- ⚡ **Production Fix:** Implement `TenantContextFilter` in Spring Boot WebFlux:
  - Inject `SET LOCAL app.current_tenant_id = :tenantId` before each Reactive R2DBC transaction execution.

---

### 🟢 Gap 5: FCM Real-Time Instant Lock/Unlock Push Dispatcher

- 🛑 **The Flaw:** Lock/unlock commands relied solely on HTTP polling.
- ⚡ **Production Fix:** Add Firebase Cloud Messaging (FCM) push payload dispatcher in `uniai-backend-core` to trigger immediate remote device lock/unlock.

---

## 🛠️ 2. Proposed Code Changes Matrix

```
UniGuard Pro/
├── uniai-backend-core/
│   └── src/main/kotlin/com/uniguard/backend/
│       ├── config/
│       │   └── R2dbcTenantContextConfig.kt      [NEW - RLS Session Tenant Injector]
│       ├── controller/
│       │   └── PaymentWebhookController.kt      [MODIFY - Add HmacSHA256 Signature Validation]
│       └── service/
│           └── FcmPushDispatcherService.kt      [NEW - Instant Lock Push Dispatcher]
└── uniai-dpc-android/
    └── app/src/main/java/com/uniai/uniguard/dpc/
        ├── UniGuardDeviceAdminReceiver.kt       [MODIFY - Add DPM Lock Task & FRP Restrictions]
        └── OfflineLockWorker.kt                 [MODIFY - Add Monotonic Boot Persistence Math]
```

---

## 🧪 3. Verification & Testing Plan

1. **Gradle Build Verification:**
   Execute `./gradlew assembleDebug` across both modules to ensure 100% clean compilation.
2. **GitHub Push Verification:**
   Commit and push production-hardened code to `https://github.com/UniAiOwner/UniGuard-Pro-Master-Platform.git`.

---

*Plan Location:* `<Artifact Directory>/production_hardening_and_gap_resolution_plan.md`  
*Signed by: Shoeb Ahmad*
