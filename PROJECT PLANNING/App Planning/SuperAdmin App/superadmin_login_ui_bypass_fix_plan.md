# 🔑 Implementation Plan — SuperAdmin Auth Gateway 1-Tap Fast Pass & UI Polish

> **Artifact Location:** `<Artifact Directory>/superadmin_login_ui_bypass_fix_plan.md`  
> **Goal:** Enhance `SuperAdminAuthGatewayScreen.kt` with a prominent 1-tap `[⚡ FAST PASS - ENTER MISSION CONTROL]` launcher button and auto-bypass option for seamless development and testing.

---

## 🎯 1. Proposed Changes

### `uniai-superadmin-android`

#### 1. `SuperAdminAuthGatewayScreen.kt`
- Add a large, glowing Solar Amber `[⚡ FAST PASS - ENTER MISSION CONTROL]` button at the top of the auth screen so the user can enter with 1 tap.
- Enhance TOTP Keypad visual design with cyan borders and clear feedback.

#### 2. `MainActivity.kt`
- Allow 1-tap authentication transition directly to the 6-Surface Mission Control Dashboard.

---

## 🧪 2. Verification Plan

1. Rebuild `uniai-superadmin-android` with `./gradlew assembleDebug`.
2. Install onto Realme phone with `adb install -r -g app-debug.apk`.
3. Launch app and verify 1-tap Fast Pass entry into Mission Control.
4. Update `dev_logs.txt` and `walkthrough.md`.

---

*Plan Location:* `<Artifact Directory>/superadmin_login_ui_bypass_fix_plan.md`  
*Signed by: Shoeb Ahmad*
