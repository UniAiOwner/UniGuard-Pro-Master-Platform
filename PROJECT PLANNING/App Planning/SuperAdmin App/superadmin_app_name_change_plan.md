# 🏷️ Implementation Plan — Change SuperAdmin App Display Name to "SuperAdmin"

> **Artifact Location:** `<Artifact Directory>/superadmin_app_name_change_plan.md`  
> **Target File:** `uniai-superadmin-android/app/src/main/res/values/strings.xml`  
> **Goal:** Update the app display name from `"UniGuard SuperAdmin"` to `"SuperAdmin"` so that it appears cleanly on Android launcher screens without conflicting with other installed apps.

---

## 🎯 1. Proposed Changes

### `uniai-superadmin-android`

#### `app/src/main/res/values/strings.xml`
Modify `app_name` string:
```xml
<resources>
    <string name="app_name">SuperAdmin</string>
</resources>
```

---

## 🧪 2. Verification Plan

1. Rebuild `uniai-superadmin-android` with `./gradlew assembleDebug`.
2. Install onto Realme phone with `./gradlew installDebug`.
3. Launch app with `adb shell am start -n com.uniai.superadmin/.MainActivity`.
4. Verify display label on Android phone launcher.
5. Update `dev_logs.txt` and `walkthrough.md`.

---

*Plan Location:* `<Artifact Directory>/superadmin_app_name_change_plan.md`  
*Signed by: Shoeb Ahmad*
