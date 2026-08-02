# 👑 UniGuard SuperAdmin Mission Control — Master Integration Plan (from `UniAi_Gaurd`)

> **Artifact Location:** `<Artifact Directory>/superadmin_uniai_gaurd_master_integration_plan.md`  
> **Source Project:** `/media/uniai/UniAi/PROJECTS_MIGRATED/UniAi_Gaurd/`  
> **Target Module:** `uniai-superadmin-android`  
> **Design Philosophy:** **"Observe ➔ Decide ➔ Control ➔ Recover ➔ Govern"**  
> **PLANNING STATUS:** 🧊 **100% SPECIFIED & READY FOR UPGRADE**

---

## 🎯 1. Executive Summary & Learnings from `UniAi_Gaurd`

After thoroughly auditing `/media/uniai/UniAi/PROJECTS_MIGRATED/UniAi_Gaurd`, we identified the complete set of real-world administrative features and screens that make SuperAdmin a true **Sovereign Mission Control**:

```
┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
│                   SUPERADMIN MISSION CONTROL — 6 MASTER NAVIGATION TABS                           │
├───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬──────────────────┤
│ 🏠 Control    │ 🏢 Distro     │ 🔑 Key Forge  │ 📱 Device IME │ ⚙️ Supreme    │ 📜 Audit Vault   │
│ Dashboard     │ Directory &   │ Synthesis &   │ Search &      │ Config &      │ Cryptographic    │
│ & Telemetry   │ Onboarding    │ Dispatcher    │ Overrides     │ Maintenance   │ Event Stream     │
└───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴──────────────────┘
```

---

## 🚀 2. Comprehensive 6-Screen Architecture

### 🏠 Screen 1: Dashboard & Telemetry (`SuperAdminDashboardScreen.kt`)
- **Obsidian Cyberpunk Design (`#0B0E14`):**
- **Bento KPI Cards:**
  - `📱 124,850 Locked Devices` (`+1,420 Today`)
  - `🏢 48 Active Tenants / Distributors` (`100% Isolated`)
  - `💳 ₹ 1.42 Cr Monthly Volume` (Stored in Paise: `1420000000L`)
  - `⚡ 99.99% System Health` (`0 Fatal Anomalies`)
- **Maintenance Mode Switch:** Global emergency switch to pause distributor/retailer traffic.
- **Live Telemetry Stream:** FRP Enforced, SIM Swap Blocked, HMAC Key Minted event ticker.

---

### 🏢 Screen 2: Distributor Directory & Onboarding (`DistributorManagementScreen.kt`)
- **Master Distributor Cards:** Firm Name, Owner Name, Phone, Region, Allocated Keys, Rate/Key, Retailer Count, Active/Suspended Status.
- **Onboard Master Distributor Modal (`AddDistributorDialog.kt`):**
  - Firm Name (e.g. `Surya Telecom Master`)
  - Owner Name (e.g. `Surya Pratap Singh`)
  - Mobile / WhatsApp Number (e.g. `+91 98765 43210`)
  - Territory Region (e.g. `UP West (Agra/Mathura)`)
  - Initial Stock Quota (e.g. `5,000 Keys`)
  - Wholesale Rate per Key (e.g. `₹ 70/key`)
- **Distributor Actions:** Allocate Stock, Change Price Tier, Suspend Account, View Retailer Network.

---

### 🔑 Screen 3: Key Synthesis Forge & Vault Dispatcher (`KeyManagerScreen.kt`)
- **The Key Forge (Synthesis Engine):**
  - Quantity counter slider (100 to 10,000 keys).
  - HMAC-SHA256 FIPS 140-3 Cryptographic Key Generator button ("INITIATE SYNTHESIS").
- **Key Stock Inventory Status:**
  - Total Produced Keys, Admin Vault Stock, Distributed Stock, Used Keys.
- **Vault Dispatcher:**
  - Select Regional Distributor dropdown ➔ Set Dispatch Quantity ➔ "START VAULT DISPATCH".

---

### 📱 Screen 4: Sovereign IMEI Device Control Center (`DeviceControlScreen.kt`)
- **IMEI Search Bar:** Search any handset across the global fleet by IMEI.
- **Device Identity Card:** Device Model, IMEI 1 & 2, Owner Name, Retailer Name, Enrolled Date, Last Seen.
- **Emergency Recovery Code Generator:** 6-digit offline recovery PIN for unlocking phones without internet connectivity.
- **Override Controls:**
  - Global Device Lock / Unlock toggle.
  - Camera Access Block toggle.
  - USB Debugging / ADB Data Transfer Block toggle.
  - Factory Reset / FRP Lock toggle.
- **Force Actions:** Send Custom Alert Message, Remote Data Wipe.
- **Mandatory TOTP MFA Dialog:** Every critical override requires entering a 6-digit TOTP code + Override Reason for audit logs.

---

### ⚙️ Screen 5: Supreme System Config (`SystemConfigScreen.kt`)
- **Operational Control:** Global Maintenance Mode Switch.
- **Financial Defaults:** Default Key Price in Paise (`₹ 50.00` = `5000L`).
- **Security & Lock Messaging:** Global Lockdown Message, Support Phone Contact Info.
- **OTA Release Control:** Minimum required DPC app version, FRP Bypass Whitelist.

---

### 📜 Screen 6: Immutable Audit Vault (`AuditVaultScreen.kt`)
- Cryptographic append-only event stream of all admin overrides, key forge batches, distributor onboardings, and system config changes.

---

## 🧪 3. Verification & Deployment Plan

1. Rebuild `uniai-superadmin-android` with `./gradlew assembleDebug`.
2. Stream-install updated APK to connected Realme phone `RMX3998`.
3. Test all 6 tabs (`Control`, `Distro`, `Keys`, `Device`, `Config`, `Vault`) on physical hardware and capture verification screenshots.
4. Update `dev_logs.txt`, `walkthrough.md`, and push to remote GitHub repository.

---

*Plan Location:* `<Artifact Directory>/superadmin_uniai_gaurd_master_integration_plan.md`  
*Signed by: Shoeb Ahmad*
