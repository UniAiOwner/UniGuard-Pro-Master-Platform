# 📱 Implementation Plan — Fix Hidden SuperAdmin App Icon on Launcher Drawer

> **Artifact Location:** `<Artifact Directory>/superadmin_launcher_icon_fix_plan.md`  
> **Root Cause:** `uniai-superadmin-android/app/src/main/AndroidManifest.xml` lacked `android:icon="@mipmap/ic_launcher"` and `android:roundIcon="@mipmap/ic_launcher_round"` declarations, and the `res/mipmap-*` icon resources were missing. Modern launchers (Realme UI / ColorOS) hide apps without registered launcher icons from the app drawer.

---

## 🎯 1. Proposed Fix Steps

### 1. Copy Mipmap Resources
Copy launcher mipmap icon resources (`mipmap-hdpi`, `mipmap-mdpi`, `mipmap-xhdpi`, `mipmap-xxhdpi`, `mipmap-xxxhdpi`, `mipmap-anydpi-v26`, `drawable`) from `uniai-dpc-android/app/src/main/res/` to `uniai-superadmin-android/app/src/main/res/`.

### 2. Update `AndroidManifest.xml`
Add `android:icon="@mipmap/ic_launcher"` and `android:roundIcon="@mipmap/ic_launcher_round"` to `<application>`:
```xml
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.SuperAdmin">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.action.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
```

---

## 🧪 2. Verification Plan

1. Rebuild `uniai-superadmin-android` with `./gradlew assembleDebug`.
2. Stream-install to Realme phone with `./gradlew installDebug`.
3. Verify `SuperAdmin` app icon appears clearly in the Realme home screen app drawer!
4. Update `dev_logs.txt` and `walkthrough.md`.

---

*Plan Location:* `<Artifact Directory>/superadmin_launcher_icon_fix_plan.md`  
*Signed by: Shoeb Ahmad*
