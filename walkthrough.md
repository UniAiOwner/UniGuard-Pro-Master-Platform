# 🏬 Retailer Operations Workspace (`uniai-retailer-android`) — Implementation Plan

> **Artifact Location:** `<Artifact Directory>/retailer_app_code_build_plan.md`  
> **App Module:** `uniai-retailer-android/`  
> **Target Standard:** Commercial DPC Standard (T-Cop / M-Cop Market Leader Specification)  
> **Design Language:** Dual Adaptive Theme (Porcelain White Light Mode ☀️ + Obsidian Dark Mode 🌙)  
> **PLANNING STATUS:** 🧊 **CODE BUILD PLAN READY FOR EXECUTION**

---

## 🎯 1. Goal & Architecture Overview

The **Retailer Operations Workspace (`uniai-retailer-android`)** is the primary mobile application used by mobile shop owners and counter staff to onboard new customer phones, manage license key inventory, collect payments, and lock overdue devices.

```
┌────────────────────────────────────────────────────────────────────────┐
│                   RETAILER APP 5-TAB NAVIGATION DOCK                   │
├───────────────┬───────────────┬───────────────┬───────────────┬────────┤
│ 🏠 Home       │ 👥 Customers  │ ➕ Add Device │ 🔑 Keys Wallet│ ⚙️ Profile│
└───────────────┴───────────────┴───────────────┴───────────────┴────────┘
```

---

## 🔬 2. Proposed Component & File Architecture

```
uniai-retailer-android/
├── build.gradle.kts
└── app/src/main/java/com/uniai/uniguard/retailer/
    ├── MainActivity.kt                      [NEW - Single Activity Navigation Host]
    ├── data/
    │   ├── api/RetailerApiService.kt        [NEW - WebFlux API Retrofit/Ktor Client]
    │   └── model/RetailerModels.kt          [NEW - DTO Data Classes]
    ├── ui/
    │   ├── theme/
    │   │   ├── Color.kt                     [NEW - Light & Dark Palette Tokens]
    │   │   └── Theme.kt                     [NEW - ThemeModeSelector Engine]
    │   ├── components/
    │   │   ├── BarcodeScannerView.kt        [NEW - CameraX + ML Kit Scanner]
    │   │   └── TopHeaderBar.kt              [NEW - Nothing OS Clock + Vernacular]
    │   └── screens/
    │       ├── StaffAuthGatewayScreen.kt    [NEW - Screen 1: Login & Staff PIN]
    │       ├── RetailerHomeScreen.kt        [NEW - Screen 2: Dashboard & Bento Grid]
    │       ├── CustomerDirectoryScreen.kt   [NEW - Screen 3: Search & Directory]
    │       ├── DeviceOnboardingScreen.kt    [NEW - Screen 4: 45s Barcode Wizard]
    │       ├── LicenseWalletScreen.kt       [NEW - Screen 6: Sub-3s UPI Key Store]
    │       └── ShopSettingsScreen.kt        [NEW - Screen 9: Profile & Theme Switcher]
    └── AndroidManifest.xml                  [NEW - CameraX & Network Permissions]
```

---

## 🛠️ 3. Core Component Specifications

### 1️⃣ Staff Auth Gateway (`StaffAuthGatewayScreen.kt`)
- Dual auth mode: `[Mobile OTP]` (WhatsApp/SMS fast 6-digit OTP) + `[Staff PIN]`.
- 1-Tap Biometric Fingerprint / Face Unlock integration.

### 2️⃣ Retailer Home Dashboard (`RetailerHomeScreen.kt`)
- Dual Theme Engine support (Porcelain White Light Mode `#F8F9FA` for shop counter glare reduction + Obsidian Dark Mode `#0B0E14`).
- Bento Box Cards: `🔑 42 License Keys Available`, `📱 148 Total Customers`, `🔒 4 Locked Phones`, `⚡ 2 Pending`.
- Primary Button: `+ ADD CUSTOMER / DEVICE` (Launches sub-45s box barcode scanner).

### 3️⃣ 45-Second Barcode Onboarding Wizard (`DeviceOnboardingScreen.kt`)
- CameraX + Google ML Kit box barcode scanner overlay.
- Auto-extracts `IMEI 1`, `IMEI 2`, and `Serial Number` from phone box barcode.
- Generates customer DPC Enrollment QR Code for instant phone setup.

### 4️⃣ Instant UPI Key Purchase Store (`LicenseWalletScreen.kt`)
- Prepaid key stock meter.
- Bulk Tier Packs: `10 Keys (10+1 Free)`, `25 Keys (25+3 Free)`, `50 Keys (50+8 Free)`.
- Sub-3 second UPI intent payment launcher & automated webhook key credit.

---

## 🧪 4. Verification Plan

1. **Gradle Build Verification:**
   Run `./gradlew :uniai-retailer-android:assembleDebug` and verify `BUILD SUCCESSFUL` with 0 compilation errors.
2. **UI & Theme Verification:**
   Verify `ThemeModeSelector` toggles cleanly between Light Mode (`#F8F9FA`) and Dark Mode (`#0B0E14`).

---

*Plan Location:* `<Artifact Directory>/retailer_app_code_build_plan.md`  
*Signed by: Shoeb Ahmad*
