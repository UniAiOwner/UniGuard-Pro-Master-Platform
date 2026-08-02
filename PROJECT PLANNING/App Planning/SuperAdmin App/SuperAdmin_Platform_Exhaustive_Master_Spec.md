# 👑 UniGuard SuperAdmin Master Platform — Exhaustive Master Spec v1.0

> **Document Location:** `/PROJECT PLANNING/App Planning/SuperAdmin App/SuperAdmin_Platform_Exhaustive_Master_Spec.md`  
> **Ecosystem Pillar:** **Pillar 1 — Global SaaS Master Mission Control**  
> **Ecosystem Surface:** Native Android App (`uniai-superadmin-android`) + Desktop Web Portal (`uniai-superadmin-web`)  
> **Design Theme:** Nothing OS Dot-Matrix Minimalist + Liquid Glass 2.0 Hybrid  
> **Target Persona:** SaaS Platform Owner & System Operators  
> **PLANNING STATUS:** 🧊 **100% SPECIFIED & FROZEN**

---

## 🎯 1. Product Identity & Global Master Vision

The **SuperAdmin Master Platform** is the highest authority in the UniGuard Pro multi-tenant ecosystem. It oversees all global operations, mints cryptographic device licenses, manages regional distributors, monitors fraud, and maintains system integrity.

```
┌────────────────────────────────────────────────────────────────────────┐
│                   SUPERADMIN MASTER PLATFORM ARCHITECTURE               │
├───────────────────────────────────┬────────────────────────────────────┤
│ 📱 NATIVE ANDROID MOBILE APP      │ 💻 DESKTOP WEB PORTAL WORKSPACE    │
│ ◾ On-the-go SaaS Mission Control  │ ◾ Global multi-tenant database     │
│ ◾ Mobile License Minting Kernel   │ ◾ Complete API key management      │
│ ◾ 2FA TOTP Approval Push System   │ ◾ Global financial ledgers & P&L   │
│ ◾ Emergency System Kill-Switches  │ ◾ Deep AI fraud detection engine   │
└───────────────────────────────────┴────────────────────────────────────┘
```

---

## 🔑 2. Core Authority & Capabilities (Pillar 1 Directives)

1. **Sole License Minting Authority:** Only SuperAdmin can generate/mint new License Keys. Neither Distributors nor Retailers can mint keys.
2. **Global Tenant & Distributor Provisioning:** SuperAdmin onboards regional master distributors, sets wholesale price per key (`e.g., ₹ 70/key`), and allocates bulk license buckets.
3. **Master Override & Fraud Engine:** Real-time AI detection of rogue retailers or fake IMEI binding patterns with 1-tap account freeze.
4. **Hardware-Backed TOTP 2FA Security:** All critical admin operations (bulk license minting, tenant deletion, master unlocks) require Hardware TOTP 2FA approval.

---

## 📱 3. SuperAdmin Native Android App (7 Screen Map)

```
┌────────────────────────────────────────────────────────────────────────┐
│               SUPERADMIN APP BOTTOM NAVIGATION DOCK                    │
├───────────────┬───────────────┬───────────────┬───────────────┬────────┤
│ 🏠 Mission    │ 🏢 Distros    │ 🔑 Mint Keys  │ 🛡️ Security   │ ⚙️ System │
└───────────────┴───────────────┴───────────────┴───────────────┴────────┘
```

### 📱 Detailed 7-Screen Breakdown:

#### 🟢 Screen 1: Master Hardware TOTP Gateway (`SuperAdminAuthGateway.kt`)
- **Role:** Hardware TOTP 2FA + Biometric Gatekeeper for Platform Boss.

#### 🟢 Screen 2: Mission Control Home Dashboard (`SuperAdminHomeScreen.kt`)
- **Role:** Global SaaS health & real-time financial cockpit.
- **Metrics Cards:**
  - 🌐 `1,42,850 Active Devices` (Worldwide Fleet)
  - 🔑 `5,00,000 Total Licenses Minted`
  - 🏢 `42 Master Distributors` (Regional Partners)
  - 💵 `₹ 3.5 Crore SaaS Revenue YTD`
- **Quick Action Dock:** `[🔑 Mint New License Batch]` | `[+ Onboard Distributor]` | `[🚨 Emergency System Freeze]`.

#### 🟢 Screen 3: Distributor Management & Provisioning (`DistributorManagementScreen.kt`)
- **Role:** Manage all 42 regional master distributors, assign wholesale key prices, set credit limits, view regional performance.

#### 🟢 Screen 4: License Minting Kernel & Batch Issuance (`LicenseMintingKernelScreen.kt`)
- **Role:** Cryptographic license key generation engine.
- **Flow:** Input Batch Quantity (`e.g. 50,000 Keys`) ➔ Select Target Distributor ➔ Authenticate via TOTP 2FA ➔ Mint and transfer keys in **2 seconds**!

#### 🟢 Screen 5: AI Fraud Detection & Master Overrides (`FraudAndOverrideScreen.kt`)
- **Role:** Monitoring suspicious IMEI registration spikes, fake barcode attempts, and executing master emergency lock/unlock overrides.

#### 🟢 Screen 6: System Health & Infrastructure Diagnostics (`SystemHealthScreen.kt`)
- **Role:** Monitoring server CPU/RAM load, PostgreSQL DB connections, Redis Pub/Sub status, FCM push success rate, and SMS gateway credits.

#### 🟢 Screen 7: SuperAdmin Settings & Security (`SuperAdminSettingsScreen.kt`)
- **Role:** Managing admin team members, API keys, webhook integrations, and security policy rules.

---

## 💻 4. SuperAdmin Desktop Web Portal (`uniai-superadmin-web`)

- **Portal Path:** `/admin/dashboard`
- **Core Desktop Modules:**
  1. 📊 **Global SaaS P&L & Revenue Analytics:** Complete global revenue, profit margins, distributor performance matrix.
  2. 🗄️ **Multi-Tenant Database & API Key Management:** Managing database shards, tenant isolation, and API developer credentials.
  3. 📜 **Enterprise Compliance & Audit Logs:** Complete immutable audit trail of every system event globally.

---

*Spec Location:* `/PROJECT PLANNING/App Planning/SuperAdmin App/SuperAdmin_Platform_Exhaustive_Master_Spec.md`  
*Signed by: Shoeb Ahmad*
