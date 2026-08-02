# 👑 UniGuard Super Admin App — Master 35-Screen Design & Layout Plan

> **File Location:** `/PROJECT PLANNING/App Planning/SuperAdmin App/SuperAdmin screen plan.md`  
> **Target Module:** `uniai-superadmin-android` (Native Android Jetpack Compose App)  
> **UI Aesthetic System:** Obsidian Dark Mode (`#0B0E14`), Porcelain Glass Cards (`#161B22`), Solar Amber (`#FFB703`), Emerald Green (`#10B981`), Crimson Red (`#EF4444`), Neon Cyan (`#00F5FF`), Royal Purple (`#8B5CF6`).

---

## 📱 Complete 35-Screen Master Catalog

1. **Screen 1: Dashboard (Overview)** — Live Status header, 8 Metric Cards 2x4 Grid, Network Health Card (4 services), Device Status Donut Chart.
2. **Screen 2: Device Overview** — Universal Search Bar (`🔍 IMEI, Name, Retailer...`) + QR Scanner icon, 5 Filter Pills, 4 Summary Metric Chips, Rich Device Stream.
3. **Screen 3: Lock & Command Center** — Target Device Profile Header, 3x3 Quick Commands Tile Grid (`🔒 Lock`, `🔓 Unlock`, `🕒 Temp Unlock`, `💬 Message`, `🖼️ Wallpaper`, `🔊 Sound`, `🔄 Restart`, `🗑️ Wipe`, `🔁 Sync`), Command History Timeline.
4. **Screen 4: Master Distributors** — Summary Chips (28 Total, 25 Active, 3 Suspended), Filter Pills, Distributor List with Territory, Retailers count, Devices count.
5. **Screen 5: Retailers Oversight** — Summary Chips (842 Total, 768 Active, 74 Suspended), Filter Pills, Read-only POS Retailer List with Overdue & Active Volume.
6. **Screen 6: Customer Details** — Customer Dossier (Ravi Kumar), Customer ID, Retailer, Distributor, Finance Start, EMI Plan, Next Due Date, Linked Device Card, Quick Action Buttons (Call, Message, History, Documents).
7. **Screen 7: Device Details & Diagnostics** — Samsung Galaxy A14 Header Card, Telemetry Bar (Battery 68%, Signal, Location), Diagnostics List (Sync, Policy v2.3.1, Root, Bootloader, Knox, SIM), Quick Action Dock (`🔒 Lock`, `🔓 Unlock`, `💬 Message`, `••• More`).
8. **Screen 8: Map View (Live Tracking)** — Dark Map View with cluster pins (246, 17, 31, 108, 15), Filter Pills (`All`, `Online`, `Locked`, `Offline`, `Tampered`).
9. **Screen 9: Reports & Analytics** — Time Range Selector (`Today`, `7D`, `30D`, `Month`, `Custom`), 30-Day Trend Chart, Collection Overview, Overdue Amount, Recovery Success 78.4%, Commands 12,431.
10. **Screen 10: Audit Logs** — Filter Pills (`All`, `Commands`, `User`, `System`, `Policy`), Chronological Audit Event List with User IP, Timestamp, and Details.
11. **Screen 11: Alerts & Threat Stream** — Severity Pills (`All`, `Critical`, `Warning`, `Info`), Alert Cards (High Overdue, Offline > 48h, SIM Change, Root Detected, Payment Failed).
12. **Screen 12: System Settings** — Category List (General, Notification, Security, Firebase, Knox & OEM, Android Enterprise, SMS Gateway, Email Gateway, Backup & Restore, API & Integrations).
13. **Screen 13: Payment & Collections** — Payments Overview (Today ₹ 12.45L, Month ₹ 48.75L, Due ₹ 1.25Cr, Overdue ₹ 22.10L), 30-Day Collection Trend Chart, Top Overdue Distributors.
14. **Screen 14: Recovery Management** — Case Counters (126 Overdue, 58 In Progress, 62 Resolved, 6 Escalated), Recovery Case Docket Stream.
15. **Screen 15: Policy Management** — Category Tabs (`Device Policy`, `Lock Policy`, `Wallpaper`, `Other`), Policy Preset List (Default, Knox, Vivo, Oppo, Realme, Root, SIM), `+ Create New Policy`.
16. **Screen 16: Broadcast / Bulk Commands** — Action Selectors (`Lock`, `Unlock`, `Message`, `Wallpaper`, `Policy`), Target Audience (`All 24,731`, `By Distributor`, `By Retailer`, `By Status`, `By Location`), Schedule, `Push Broadcast` Button.
17. **Screen 17: Geofence & Location** — Tabs (`Geofences`, `Location History`), Map View with Zone Boundaries (Office Zone, Warehouse Zone, City Boundary, High Risk Area), Geofence Zone Cards.
18. **Screen 18: Firmware / App Update** — Tabs (`App Update`, `Firmware Update`), Current v2.3.1 ➔ Target v2.4.0 (Mandatory), Release Notes, Schedule, `Push Update` Button.
19. **Screen 19: SIM & Network Monitoring** — SIM Change Counters (Today 23, Week 156, Month 487), SIM Swap Stream Cards with old/new SIM pings, Location, and Timestamp.
20. **Screen 20: Tamper / Security Events** — Security Counters (Root 56, ADB 34, Unlock Attempt 78, Factory Reset 12), Threat Event Cards with High/Medium severity badges.
21. **Screen 21: Notifications Center** — Filter Pills (`All`, `Critical`, `Warning`, `Info`), System Notifications Ticker.
22. **Screen 22: Analytics & Insights** — Time Filter, Key Metrics Grid (Active Devices 21,456, Collection Rate 78.4%, Recovery Success 82.6%, Lock Success 99.2%), Top Insights Dossier.
23. **Screen 23: Activity Timeline** — Search & Filter, Chronological Event Dots (Lock, Payment, SIM Change, Wallpaper, Recovery Case, Unlock).
24. **Screen 24: Admin Profile & Security** — SuperAdmin Dossier (Ravi Kumar superadmin@uniguard.com), Change Password, 2FA Status (Enabled), Active Sessions (3), API Tokens, Login History, Security Settings, Logout.
25. **Screen 25: Create Distributor** — Form with Distributor Name, Contact Person, Mobile Number, Email Address, Territory/State, Address, Credit Limit (₹), KYC Documents (PAN, GST), Active toggle, `Create Distributor` Button.
26. **Screen 26: Device Remote Actions** — Target Device Header (Samsung Galaxy A14 🟢 Online), Quick Action Grid (Lock, Unlock, Temp Unlock, Message, Wallpaper, Play Sound, Restart, Wipe, Sync).
27. **Screen 27: Device History** — Filter Pills (`All`, `Commands`, `Events`, `System`), Chronological Device Audit Timeline.
28. **Screen 28: Role Management** — Create Role Button, Role List (Super Admin, Distributor Admin, Retailer Admin, Support Agent, Finance Manager, View Only).
29. **Screen 29: Permission Matrix** — Matrix Grid of Modules (Dashboard, Devices, Customers, Commands, Lock & Recovery, Reports, Finance, Audit Logs, Settings) mapped to Roles with checkmarks ✅ and crosses ❌.
30. **Screen 30: Territory Management** — Interactive India Zone Map (North Zone 128, East Zone 112, West Zone 112, South Zone 76, Central Zone 54 Distributors), `+ Add Territory` Button.
31. **Screen 31: Bulk Operations** — Bulk Lock, Bulk Unlock, Send Bulk Message, Update Bulk Wallpaper, Bulk Policy Update, Export Device List.
32. **Screen 32: Advanced Search** — Universal Search Engine (Search Type Tabs, IMEI Number, Status dropdown, Distributor dropdown, Retailer dropdown, Date Range picker).
33. **Screen 33: Notifications Settings** — Toggles for High Risk Alerts, Payment Reminders, Device Tampering, Device Offline Alerts, SIM Change Alerts, License Expiry Alerts, System Alerts, Email Notifications.
34. **Screen 34: Backup & Restore** — `Create Backup` Button (Last Backup details: Date, Size 2.45 GB, Status Success), `Restore Backup` selector & `Restore Now` Button.
35. **Screen 35: System Health** — Overall Status 🟢 Healthy, Server Uptime 15d 7h 42m, Component Status List (API Server, Database, Firebase, SMS Gateway, Email Service, Knox Service, Storage Service, Backup Service).

---

*File Location:* `/PROJECT PLANNING/App Planning/SuperAdmin App/SuperAdmin screen plan.md`  
*Signed by: Shoeb Ahmad*
