# 👑 UniGuard Super Admin App — Complete 24-Screen Master Implementation Plan

> **Artifact Location:** `<Artifact Directory>/superadmin_complete_24_screens_master_plan.md`  
> **Source Blueprints:** `/PROJECT PLANNING/App Planning/chatgpt app plan/` (`4b91e148-01ff-4b20-85eb-c0331d1daa15.png`, `c5ec622a-aff5-44ba-aeb0-fc254054237e.png`, `c379f3c9-6c76-4e6b-8d76-8343f4419603.png`)  
> **Module:** `uniai-superadmin-android` (Native Android Jetpack Compose App)  
> **Coverage:** 100% Complete Implementation of all 24 Screens

---

## 🧭 1. App-Wide Navigation Architecture (5-Tab Dock + Deep Routes)

### Bottom Navigation Bar (5 Primary Hubs)
1. 🏠 **Dashboard** (`SuperAdminTab.DASHBOARD`)
2. 📱 **Devices** (`SuperAdminTab.DEVICES`)
3. ⚡ **Commands** (`SuperAdminTab.COMMANDS`) — *Centered Glowing Launcher Action*
4. 🔔 **Alerts** (`SuperAdminTab.ALERTS`) — *With Red Badge Counter `12`*
5. ::: **More** (`SuperAdminTab.MORE`) — *Full System Modules Grid & Settings*

---

## 📱 2. Complete 24-Screen Catalog & Specifications

### 🏛️ PART 1: CORE OPERATIONAL SCREENS (SCREENS 1 TO 12)

| Screen # | Screen Title | Key Features & Layout Components |
|---|---|---|
| 1️⃣ | **Dashboard (Overview)** | Live Status header, 8 Metric Telemetry Cards 2x4 Grid, Network Health Card (4 services), Device Status Donut Chart. |
| 2️⃣ | **Device Overview** | Universal Search (`🔍 IMEI, Name, Retailer...`) + QR Scanner icon, 5 Filter Pills, 4 Summary Metric Chips, Rich Device Stream Cards. |
| 3️⃣ | **Lock & Command Center** | Target Device Header Profile, 3x3 Grid of 9 Action Tiles (Lock, Unlock, Temp Unlock, Message, Wallpaper, Sound, Restart, Wipe, Sync), Command History Timeline. |
| 4️⃣ | **Distributors** | Summary Counters (Total 28, Active 25, Suspended 3), Filter Pills, Master Distributor List with Territory, Retailer count, Device count. |
| 5️⃣ | **Retailers** | Summary Counters (Total 842, Active 768, Suspended 74), Filter Pills, POS Retailer List with Overdue & Active Finance Volume. |
| 6️⃣ | **Customer Details** | Customer Dossier (Ravi Kumar), Customer ID, Retailer, Distributor, Finance Start, EMI Plan, Due Date, Linked Device Card, Quick Action Buttons (Call, Message, History, Documents). |
| 7️⃣ | **Device Details** | Samsung Galaxy A14 Header Card, Telemetry Bar (Battery 68%, Signal, Location), Diagnostics List (Last Sync, Policy v2.3.1, Root Status, Bootloader, Knox, SIM), Quick Dock (`🔒 Lock`, `🔓 Unlock`, `💬 Message`, `••• More`). |
| 8️⃣ | **Map View (Live Tracking)** | Dark Map View with cluster pins (246, 17, 31, 108, 15), Filter Pills (`All`, `Online`, `Locked`, `Offline`, `Tampered`). |
| 9️⃣ | **Reports & Analytics** | Time Range Selector (`Today`, `7D`, `30D`, `Month`, `Custom`), 30-Day Trend Chart, Collection Overview, Overdue Amount, Recovery Success 78.4%, Commands 12,431. |
| 🔟 | **Audit Logs** | Filter Pills (`All`, `Commands`, `User`, `System`, `Policy`), Chronological Audit Event List with User IP, Timestamp, and Event Details. |
| 11 | **Alerts** | Severity Pills (`All`, `Critical`, `Warning`, `Info`), Alert Cards (High Overdue, Offline > 48h, SIM Change, Root Detected, Payment Failed). |
| 12 | **System Settings** | Settings Categories List (General, Notification, Security, Firebase, Knox & OEM, Android Enterprise, SMS Gateway, Email Gateway, Backup & Restore, API & Integrations). |

---

### 🛡️ PART 2: ADVANCED GOVERNANCE & RECOVERY SCREENS (SCREENS 13 TO 24)

| Screen # | Screen Title | Key Features & Layout Components |
|---|---|---|
| 13 | **Payment & Collections** | Payments Overview (Today ₹ 12.45L, Month ₹ 48.75L, Due ₹ 1.25Cr, Overdue ₹ 22.10L), 30-Day Collection Trend Chart, Top Overdue Distributors List. |
| 14 | **Recovery Management** | Counters (Total 126, In Progress 58, Resolved 62, Escalated 6), Filter Pills, Recovery Case Docket Cards (RC-2025-00125, etc.). |
| 15 | **Policy Management** | Category Tabs (`Device Policy`, `Lock Policy`, `Wallpaper`, `Other`), Policy Preset List (Default, Knox, Vivo, Oppo, Realme, Root Detection, SIM Change), `+ Create New Policy`. |
| 16 | **Broadcast / Bulk Commands** | Action Pickers (`Lock`, `Unlock`, `Message`, `Wallpaper`, `Policy`), Target Audience (`All 24,731`, `By Distributor`, `By Retailer`, `By Status`, `By Location`), Broadcast Input Box, Schedule, `Push Broadcast`. |
| 17 | **Geofence & Location** | Tabs (`Geofences`, `Location History`), Interactive Map with Zone Boundaries (Office Zone, Warehouse Zone, City Boundary, High Risk Area), Geofence Zone Cards. |
| 18 | **Firmware / App Update** | Tabs (`App Update`, `Firmware Update`), Current Version v2.3.1 ➔ Target v2.4.0 (Mandatory), Release Notes, Target Devices, Schedule, `Push Update`. |
| 19 | **SIM & Network Monitoring** | SIM Change Counters (Today 23, Week 156, Month 487), SIM Swap Stream Cards with old/new SIM pings, Retailer, Location, and Timestamp. |
| 20 | **Tamper / Security Events** | Security Counters (Root Detected 56, ADB Enabled 34, Unlock Attempt 78, Factory Reset 12), Threat Event Cards with High/Medium severity badges. |
| 21 | **Notifications Center** | Filter Pills (`All`, `Critical`, `Warning`, `Info`), System Notifications Ticker with status icons. |
| 22 | **Analytics & Insights** | Time Filter (`7D`, `30D`, `90D`, `Custom`), Key Metrics Grid (Active Devices 21,456, Collection Rate 78.4%, Recovery Success 82.6%, Lock Success 99.2%), Top Insights Dossier. |
| 23 | **Activity Timeline** | Universal Event Stream Search & Filter, Chronological Event Dots (Lock, Payment, SIM Change, Wallpaper, Recovery Case, Unlock). |
| 24 | **Admin Profile & Security** | SuperAdmin Dossier (Ravi Kumar superadmin@uniguard.com), Change Password, 2FA Status (Enabled), Active Sessions (3), API Tokens, Login History, Security Settings, Logout. |

---

## 🛠️ 3. Execution & Deployment Strategy

1. **Jetpack Compose Code Construction:** Build all 24 Jetpack Compose screens in `uniai-superadmin-android/app/src/main/java/com/uniai/superadmin/ui/screens/`.
2. **Navigation System Update:** Update `MainActivity.kt` with full 5-Tab Bottom Dock & Navigation Drawer for accessing all 24 screens.
3. **Compilation:** Execute `./gradlew assembleDebug` (0 warnings, 0 errors).
4. **Hardware Installation:** Force-install via `adb install --user 0 -r -g app-debug.apk` onto physical Realme phone `RMX3998`.
5. **Physical Screenshot Verification:** Capture screenshots of the new screens on phone hardware.
6. **Git & Log Sync:** Update `walkthrough.md`, `dev_logs.txt`, and push commits to GitHub `main` branch.

---

*Plan Location:* `<Artifact Directory>/superadmin_complete_24_screens_master_plan.md`  
*Signed by: Shoeb Ahmad*
