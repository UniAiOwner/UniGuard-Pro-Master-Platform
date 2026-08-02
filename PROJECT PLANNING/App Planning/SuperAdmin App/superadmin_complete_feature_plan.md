# 👑 SuperAdmin Mission Control — Master Distributor & Tenant Onboarding Plan

> **Artifact Location:** `<Artifact Directory>/superadmin_complete_feature_plan.md`  
> **Target App:** `uniai-superadmin-android`  
> **Business Rule:** **SuperAdmin creates Distributors & Enterprise Tenants**. Distributors then create/onboard Retailers, and Retailers onboard Customer Devices.

---

## 🏗️ 1. Hierarchical Onboarding Chain

```
👑 SuperAdmin (Pillar 5)
   ├── 🏢 Creates Enterprise Tenants (e.g. Airtel Finance, TVS Credit)
   └── 🏢 Creates & Onboards Distributors (e.g. Surya Telecom, Vardhman Mobiles)
        │
        └── 🏬 Distributor (Pillar 4)
             └── Creates & Onboards Retailers (e.g. Gupta Electronics)
                  │
                  └── 📱 Retailer (Pillar 3)
                       └── Onboards & Locks Customer Devices (uniai-dpc-android)
```

---

## 🛠️ 2. SuperAdmin Distributor Management Suite

We are adding dedicated **Distributor Management** directly inside the SuperAdmin App:

### 🏢 1. `DistributorRegistryScreen.kt` (New SuperAdmin Screen / Sub-Tab)
- **Distributor List Directory:** Displays all active Distributors (`Surya Telecom`, `Vardhman Mobiles`, `Metro Digital`).
- **Metrics Per Distributor:**
  - Assigned License Key Stock (e.g. `5,000 Keys`).
  - Active Retailer Network Count (e.g. `42 Retailers`).
  - Territory / Region (e.g. `North Zone - Delhi NCR`).
  - Account Status (`ACTIVE`, `SUSPENDED`).
- **Interactive Action Controls:** `SUSPEND DISTRIBUTOR` & `ALLOCATE KEYS` buttons.

### ➕ 2. `AddDistributorDialog.kt` (Create Distributor Modal)
- **SuperAdmin Form Fields:**
  1. **Distributor Firm Name:** (e.g. `Surya Telecom Distribution Pvt Ltd`)
  2. **Owner / MD Name:** (e.g. `Rakesh Sharma`)
  3. **GSTIN / Business Reg:** (e.g. `07AAAAA0000A1Z5`)
  4. **Contact Mobile & Email:** (e.g. `+91 98100...`)
  5. **Territory Region:** (e.g. `North Zone`)
  6. **Assigned Tenant:** Select Tenant (`Airtel Finance`, `TVS Credit`, `UniGuard Master`)
  7. **Initial License Key Allocation:** (e.g. `1,000 Keys`)
- **Action:** Generates unique Distributor ID (`DST-SURYA-001`) and sends credentials via SMS/Email.

---

## 📊 3. Full SuperAdmin Navigation Structure (6 Command Modules)

1. 🏠 **Control Center:** Live Bento Grid Dashboard & Telemetry Stream.
2. 🏢 **Tenants:** Enterprise Multi-Tenant RLS Isolation & Rate Limits.
3. 🏬 **Distributors:** **Distributor Onboarding Modal (`+ Add Distributor`) & Credit Allocation Suite.**
4. 🔑 **Mint Kernel:** HMAC-SHA256 Batch License Key Generator & Expiry Engine.
5. 🛡️ **Fraud Console:** AI Anomaly Threat Detector & Global FCM Emergency Lock.
6. 📜 **Audit Vault:** Cryptographically Signed Immutable Audit Log.

---

## 🧪 4. Verification & Deployment

1. Rebuild `uniai-superadmin-android` with `./gradlew assembleDebug`.
2. Push updated APK to connected Realme phone `XGQ8JFZXEITGJ7IB`.
3. Take screenshot of `DistributorRegistryScreen.kt` & `AddDistributorDialog.kt` on physical phone.

---

*Plan Location:* `<Artifact Directory>/superadmin_complete_feature_plan.md`  
*Signed by: Shoeb Ahmad*
