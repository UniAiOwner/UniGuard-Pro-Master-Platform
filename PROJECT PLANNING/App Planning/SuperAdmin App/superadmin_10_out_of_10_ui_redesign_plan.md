# 👑 SuperAdmin Mission Control — 10/10 Master Visual UI Redesign Plan

> **Artifact Location:** `<Artifact Directory>/superadmin_10_out_of_10_ui_redesign_plan.md`  
> **Source Spec Directory:** `/media/uniai/UniAi/PROJECTS_MIGRATED/UniGuard Pro/PROJECT PLANNING/App Planning/SuperAdmin App/`  
> **Reference Images:**  
> - 🖼️ [`superadmin_app_ui_sample.jpg`](file:///media/uniai/UniAi/PROJECTS_MIGRATED/UniGuard%20Pro/PROJECT%20PLANNING/App%20Planning/SuperAdmin%20App/superadmin_app_ui_sample.jpg) (Mission Control Dashboard)  
> - 🖼️ [`superadmin_license_minting.jpg`](file:///media/uniai/UniAi/PROJECTS_MIGRATED/UniGuard%20Pro/PROJECT%20PLANNING/App%20Planning/SuperAdmin%20App/superadmin_license_minting.jpg) (License Minting Kernel)  
> - 🖼️ [`superadmin_ai_fraud_overrides.jpg`](file:///media/uniai/UniAi/PROJECTS_MIGRATED/UniGuard%20Pro/PROJECT%20PLANNING/App%20Planning/SuperAdmin%20App/superadmin_ai_fraud_overrides.jpg) (AI Fraud & Overrides)  
> **Target Module:** `uniai-superadmin-android`  
> **PLANNING STATUS:** 🧊 **100% SPECIFIED & READY FOR OVERHAUL**

---

## 🎯 1. Executive Goal

Rebuild the **SuperAdmin App (`uniai-superadmin-android`)** to **100% match the exact visual UI mockups, layout, components, colors, and features** designed in `/PROJECT PLANNING/App Planning/SuperAdmin App/`:

```
┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
│                     SUPERADMIN MASTER APP — 6 NAV DOCK SCREENS (EXACT MOCKUPS)                    │
├───────────────┬───────────────┬───────────────┬───────────────┬───────────────┬──────────────────┤
│ 🏠 Control    │ 🔑 Mint       │ 🏢 Distro     │ 🛡️ AI Fraud   │ 🏬 Tenant     │ ⚙️ System       │
│ Dashboard     │ Kernel        │ Management    │ Overrides     │ Registry      │ Diagnostics      │
│ (Hero Banner  │ (TOTP Minting │ (Wholesale &  │ (Kill-Switch  │ (Multi-Tenant │ (DB/Redis/FCM    │
│ & 3 KPI Cards)│ & Batches)    │ Onboarding)   │ & Threats)    │ Isolation)    │ Health & Config) │
└───────────────┴───────────────┴───────────────┴───────────────┴───────────────┴──────────────────┘
```

---

## 🎨 2. Visual Component & Screen Specification

### 🏠 1. Mission Control Home Dashboard (`SuperAdminDashboardScreen.kt`)
*Matches `superadmin_app_ui_sample.jpg` 100%:*
- **Header Bar:** Vernacular Switcher `[Hindi | Eng]`, App Title (`UNIGUARD GLOBAL MASTER`), Live System Status.
- **Global Fleet Hero Banner:** Translucent Glass Card with `🌐 1,42,850 ACTIVE DEVICES WORLDWIDE`, dynamic green status pulse, and `[Mint Keys]` shortcut button.
- **3 Top Metric Grid Cards:**
  - `🔑 5,00,000` — Minted Licenses
  - `🏢 42` — Master Distributors
  - `💵 ₹ 3.5Cr` — YTD SaaS Revenue
- **Primary Action Dock:** Large Glowing Amber Button: `🔑 MINT NEW LICENSE BATCH` (navigates to Minting Kernel).
- **Quick Action Grid:** `Distributors` | `AI Fraud Alerts` | `Tenants` | `System Health`.
- **Live System Stream:** Real-time ticker of license minting, distributor onboarding, and fraud events.

---

### 🔑 2. License Minting Kernel (`LicenseMintingKernelScreen.kt`)
*Matches `superadmin_license_minting.jpg` 100%:*
- **Minting Forge Card:**
  - Batch Quantity Preset Chips (`1,000`, `10,000`, `50,000`, `1,000,000`) + Stepper controls.
  - Target Distributor Dropdown (`Surya Telecom Master`, `Vardhman Mobiles`, `Unassigned`).
  - Key Expiry Selector (`30 Days`, `90 Days`, `365 Days`, `Lifetime`).
  - Hardware TOTP 2FA Verification Input (`884 912`).
  - **Button:** `🔑 MINT BATCH (HMAC-SHA256 FIPS 140-3)` with golden amber glow.
- **Minted Batch History:** Batch ID, Quantity, Timestamp, Target Distributor, Copy JSON Payload action.

---

### 🏢 3. Distributor Directory & Provisioning (`DistributorManagementScreen.kt`)
- Header with `[+ Onboard Distributor]` CTA button.
- Master Distributor Cards: Firm Name, Owner Name, Contact Phone, Region, Quota (`50,000 Keys`), Wholesale Price (`₹ 70/key`), Active Retailers (`142`), Status Badge (`ACTIVE`).
- `AddDistributorDialog.kt`: Modal to onboard new regional distributor.

---

### 🛡️ 4. AI Fraud Detection & Master Overrides (`AiFraudOverrideScreen.kt`)
*Matches `superadmin_ai_fraud_overrides.jpg` 100%:*
- **Threat Telemetry Banner:** Risk Score (`CRITICAL 98.4%`), Flagged IMEIs count (`14 Flagged`).
- **Suspicious Threat Cards:**
  - `⚠️ IMEI 864209041234567`: FRP Bypass Attempt detected.
  - `⚠️ Retailer 'Gupta Mobiles'`: 50 IMEI Scans/min rate limit spike.
- **1-Tap Action Kill-Switches:**
  - `[⛔ SUSPEND RETAILER]`
  - `[🔒 FORCE HARD LOCK]`
  - `[🛡️ ENFORCE KNOX FRP]`

---

### 🏬 5. Enterprise Multi-Tenant Registry (`TenantRegistryScreen.kt`)
- Enterprise Workspace Cards (Tenant ID, Organization Name, Active Handsets, RLS Status).
- `AddTenantDialog.kt`: Modal to create new enterprise tenant.

---

### ⚙️ 6. System Health & Platform Config (`SystemConfigScreen.kt`)
- Infrastructure Metrics: R2DBC DB Pool (`14/50`), Redis Latency (`1.2ms`), FCM Push Success (`99.8%`).
- Global Maintenance Mode switch.
- Financial Defaults in Paise (`₹ 50.00` = `5000L`).
- Lockdown Screen Message & Support Phone.

---

## 🧪 3. Execution & Verification Steps

1. Implement all 6 screens and dialogs in `uniai-superadmin-android`.
2. Update `MainActivity.kt` navigation dock to reflect the 6 master screens.
3. Recompile with `./gradlew assembleDebug` (`BUILD SUCCESSFUL`).
4. Force-install onto Realme phone via `adb install -r -g app-debug.apk`.
5. Capture live physical screenshots of all screens and update `walkthrough.md`.
6. Push changes to GitHub main branch.

---

*Plan Location:* `<Artifact Directory>/superadmin_10_out_of_10_ui_redesign_plan.md`  
*Signed by: Shoeb Ahmad*
