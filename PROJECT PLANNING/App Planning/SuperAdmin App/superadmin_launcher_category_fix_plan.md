# 🔍 Root Cause Fix Plan — Fix SuperAdmin App Category Tag in `AndroidManifest.xml`

> **Artifact Location:** `<Artifact Directory>/superadmin_launcher_category_fix_plan.md`  
> **Root Cause Identified:** In `uniai-superadmin-android/app/src/main/AndroidManifest.xml`, the launcher intent filter category tag was misconfigured as `<category android:name="android.intent.action.LAUNCHER" />` instead of `<category android:name="android.intent.category.LAUNCHER" />`.  
> Because of this invalid category name, Android OS PackageManager failed to recognize the activity as a launcher app and excluded it from the home screen app drawer!

---

## 🎯 1. Proposed Fix

### `uniai-superadmin-android/app/src/main/AndroidManifest.xml`

Fix the category tag:
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <uses-permission android:name="android.permission.INTERNET" />

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
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

---

## 🧪 2. Verification Plan

1. Update `AndroidManifest.xml`.
2. Rebuild with `./gradlew assembleDebug` in `uniai-superadmin-android`.
3. Force-install onto connected Realme phone with `adb install -r -g app-debug.apk`.
4. Verify `SuperAdmin` icon is immediately visible on phone home screen / app drawer!
5. Update `dev_logs.txt` and `walkthrough.md`.

---

*Plan Location:* `<Artifact Directory>/superadmin_launcher_category_fix_plan.md`  
*Signed by: Shoeb Ahmad*
