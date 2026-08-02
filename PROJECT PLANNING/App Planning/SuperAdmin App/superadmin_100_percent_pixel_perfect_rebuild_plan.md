# 👑 UniGuard Super Admin App — 100% Pixel-Perfect Master Rebuild Plan

> **Artifact Path:** `<Artifact Directory>/superadmin_100_percent_pixel_perfect_rebuild_plan.md`  
> **Target Android Module:** `uniai-superadmin-android`  
> **Target Device:** Realme RMX3998 (`adb -s XGQ8JFZXEITGJ7IB`)  
> **UI Design Reference:** 100% Match with uploaded blueprints ([`4b91e148`](file:///media/uniai/UniAi/PROJECTS_MIGRATED/UniGuard%20Pro/PROJECT%20PLANNING/App%20Planning/chatgpt%20app%20plan/4b91e148-01ff-4b20-85eb-c0331d1daa15.png), [`c379f3c9`](file:///media/uniai/UniAi/PROJECTS_MIGRATED/UniGuard%20Pro/PROJECT%20PLANNING/App%20Planning/chatgpt%20app%20plan/c379f3c9-6c76-4e6b-8d76-8343f4419603.png), [`7d883ec7`](file:///media/uniai/UniAi/PROJECTS_MIGRATED/UniGuard%20Pro/PROJECT%20PLANNING/App%20Planning/chatgpt%20app%20plan/7d883ec7-e785-4eac-a390-b58070050c76.png)).

---

## 🎯 Goal Description

Rebuild and refactor the entire `uniai-superadmin-android` codebase so that all **35 Screens** are fully implemented in Jetpack Compose, matching 100% pixel-perfect with the exact UI layouts, dark obsidian theme system (`#0B0E14`), card structures, color badges, top headers, bottom navigation dock, and options specified in the user's original blueprint images.

---

## 🚨 User Review Required

> [!IMPORTANT]
> - **Zero AI Redesign:** All 35 screens will strictly mirror the user's uploaded blueprint designs.
> - **Fast Pass Launcher:** `SuperAdminAuthGatewayScreen.kt` retains the glowing Solar Amber `[⚡ FAST PASS - ENTER MISSION CONTROL]` 1-tap launcher button for instantaneous testing on live physical Realme hardware.
> - **5-Tab Navigation Bar:** Main activity uses persistent bottom navigation dock connecting all 35 screens seamlessly.

---

## 🏗️ Proposed Code Changes & Component Breakdown

### 1. Design System & Navigation (`uniai-superadmin-android/app/src/main/java/com/uniai/superadmin/`)

- **`ui/theme/Color.kt`** — Define exact brand color tokens:
  - Obsidian Dark Background: `#0B0E14`
  - Obsidian Surface: `#161B22`
  - Glass Card: `#1C222D`
  - Solar Amber: `#FFB703`
  - Emerald Green: `#10B981`
  - Crimson Red: `#EF4444`
  - Neon Cyan: `#00F5FF`
  - Royal Purple: `#8B5CF6`
- **`ui/navigation/SuperAdminNavigation.kt`** — 5-Tab Persistent Navigation System linking all 35 screens.

---

### 2. Screen Implementation Catalog (35 Jetpack Compose Screens)

#### 📱 Set 1 Screens (`ui/screens/set1/`)
- `01_SuperAdminDashboardScreen.kt` — Overview with 8 Metric Telemetry Cards & Network Health.
- `02_DeviceOverviewScreen.kt` — Device directory with search, filter pills & summary chips.
- `03_LockCommandCenterScreen.kt` — Target device header & 3x3 colorful remote action tiles grid.
- `04_MasterDistributorsScreen.kt` — Master distributor cards with territory & device counts.
- `05_RetailersOversightScreen.kt` — Read-only POS merchant directory with volume badges.

#### 🔍 Set 2 Screens (`ui/screens/set2/`)
- `06_CustomerDetailsScreen.kt` — End-user customer dossier, finance agreement & linked device.
- `07_DeviceDetailsDiagnosticsScreen.kt` — Samsung A14 header, Knox/Root/SIM diagnostics stream.
- `08_MapViewLiveTrackingScreen.kt` — Interactive dark map matrix with device clusters & status pins.
- `09_ReportsAnalyticsScreen.kt` — 30-day collection trend line chart & BI metrics.
- `10_AuditLogsScreen.kt` — Cryptographically signed event log stream with security hashes.

#### 🛡️ Set 3 Screens (`ui/screens/set3/`)
- `11_AlertsThreatStreamScreen.kt` — Severity pills & real-time threat incident cards.
- `12_SystemSettingsScreen.kt` — 10 Core infrastructure configuration category blocks.
- `13_PaymentCollectionsScreen.kt` — Revenue ledgers & 30-day collection bar charts.
- `14_RecoveryManagementScreen.kt` — Overdue case dockets & field agent assignment.
- `15_PolicyManagementScreen.kt` — Master Knox & DPC security policy profile forge.

#### ⚡ Set 4 Screens (`ui/screens/set4/`)
- `16_BroadcastBulkCommandsScreen.kt` — Mass remote payload broadcast engine.
- `17_GeofenceLocationScreen.kt` — Interactive geofence polygon zones & boundary alerts.
- `18_FirmwareAppUpdateScreen.kt` — OTA mandatory update launcher & rollout stage pills.
- `19_SIMNetworkMonitoringScreen.kt` — SIM swap alert tracker & carrier network status table.
- `20_TamperSecurityEventsScreen.kt` — Forensics security event stream (Root, ADB, Reset).

#### 📊 Set 5 Screens (`ui/screens/set5/`)
- `21_NotificationsCenterScreen.kt` — System notification ticker & priority filter pills.
- `22_AnalyticsInsightsScreen.kt` — System health donut chart & active user analytics.
- `23_ActivityTimelineScreen.kt` — Visual chronological event dots stream.
- `24_AdminProfileSecurityScreen.kt` — SuperAdmin profile dossier & 2FA security settings.
- `25_CreateDistributorScreen.kt` — Onboarding form wizard for appointing master distributors.

#### 🛠️ Set 6 Screens (`ui/screens/set6/`)
- `26_DeviceRemoteActionsScreen.kt` — Target device action matrix grid.
- `27_DeviceHistoryScreen.kt` — Chronological device event & command audit timeline.
- `28_RoleManagementScreen.kt` — RBAC system role configurator.
- `29_PermissionMatrixScreen.kt` — Granular Module x Role permission checkmark grid table.
- `30_TerritoryManagementScreen.kt` — Interactive India Zone allocation map (North, West, East, South).

#### 🌐 Set 7 Screens (`ui/screens/set7/`)
- `31_BulkOperationsScreen.kt` — Batch execution action cards.
- `32_AdvancedSearchScreen.kt` — Universal multi-parameter query engine form.
- `33_NotificationsSettingsScreen.kt` — Global alert preference switches & toggles.
- `34_BackupRestoreScreen.kt` — Disaster recovery database snapshot manager.
- `35_SystemHealthScreen.kt` — Node uptime status, CPU/Memory gauges & network traffic graph.

---

## 🧪 Verification Plan

### 1. Compilation Verification
Execute Gradle debug build command:
```bash
./gradlew assembleDebug
```
Ensure build completes with **0 errors and 0 warnings**.

### 2. Physical Device Installation & Deployment
Deploy APK to Realme RMX3998 physical phone:
```bash
adb install --user 0 -r -g app/build/outputs/apk/debug/app-debug.apk
```

### 3. Screenshot Capture & Walkthrough
Launch MainActivity, test navigation across screens, capture physical device screenshots via `adb exec-out screencap -p`, update `walkthrough.md` and `dev_logs.txt`, and push commit to Git `main` branch.

---

*Signed by: Shoeb Ahmad*
