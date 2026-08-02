# 🏛️ UniGuard Pro — 3-App Master Ecosystem Architecture & RBAC Scope Plan

> **Artifact Location:** `<Artifact Directory>/uniguard_3_app_ecosystem_architectural_plan.md`  
> **Source Blueprints:** `/PROJECT PLANNING/App Planning/chatgpt app plan/` (`4b91e148-01ff-4b20-85eb-c0331d1daa15.png`, `c5ec622a-aff5-44ba-aeb0-fc254054237e.png`, `c379f3c9-6c76-4e6b-8d76-8343f4419603.png`, `7d883ec7-e785-4eac-a390-b58070050c76.png`)  
> **Ecosystem Hierarchy:**  
> $$\text{Super Admin App (Sovereign Tower)} \longrightarrow \text{Distributor App (Territory Master)} \longrightarrow \text{Retailer App (POS Merchant)} \longrightarrow \text{Customer Device (Knox DPC Node)}$$

---

## 🧭 1. Ecosystem Scope & RBAC Domain Boundaries

While all 3 mobile apps share a unified **Porcelain Dark UI Design System (~70% visual consistency)**, their operational workflows and RBAC security boundaries are strictly separated:

```mermaid
graph TD
    subgraph Super Admin App (Sovereign Command Tower)
        SA1[Global Fleet Overview & Telemetry]
        SA2[Master Distributors Governance]
        SA3[Global Retailers & Customers Dossier]
        SA4[Bulk Broadcast & Remote Erase Engine]
        SA5[RBAC Role Matrix & System Backup/Health]
    end
    
    subgraph Distributor App (Territory Operations Hub)
        DA1[Territory Retailers & Performance]
        DA2[Create & Onboard Retailer POS]
        DA3[Kit & License Credit Allocations]
        DA4[Territory Collections & FastPass QR Transfers]
    end
    
    subgraph Retailer App (POS Merchant Store)
        RA1[POS Customer Onboarding Wizard]
        RA2[Device Registration & IMEI Barcode Scan]
        RA3[Finance & EMI Agreement Generation]
        RA4[Daily Collection & Shop Wallet]
    end
    
    SA2 -->|Credit & Territory| DA1
    DA2 -->|POS Shop Approval| RA1
    RA2 -->|Knox Provisioning Payload| CD[📱 Customer Hardware Node]
```

---

## 📱 2. Screen Allocation Across the 3 Android Apps

### 👑 A. Super Admin App (`uniai-superadmin-android`)
*Sovereign platform control, multi-tenant governance, global command tower, system infrastructure, and forensics.*

1. **Dashboard (Overview):** Live fleet health, 8 Metric Cards 2x4 Grid, Network Health (4 services), Device Status Donut.
2. **Device Overview:** Global Device List, Search (`⌘K`), 5 Filter Pills, 4 Metric Chips.
3. **Lock & Command Center:** Target Device Profile Header, 3x3 Quick Commands Tile Grid, Command History Timeline.
4. **Distributors Management:** Master Distributors Registry, Credit Line Allocations, Status Badges.
5. **Retailers Oversight:** Read-only global POS merchant registry, performance rankings, overdue tracking.
6. **Customer Registry:** Dossier search (Aadhaar/IMEI/Mobile), EMI status, Linked Device.
7. **Device Details & Diagnostics:** Hardware pings, Policy v2.3.1, Root status, Bootloader lock, Knox state, SIM slot 1/2 info.
8. **Map View (Live Tracking):** Interactive dark map with global cluster pins and status filters.
9. **Reports & Analytics:** 30-Day Devices Trend chart, Collection Overview, Overdue Amount, Recovery Success 78.4%.
10. **Audit Logs:** Immutable forensics stream with User IP, Timestamp, and cryptographically signed payload events.
11. **Alerts & Threat Telemetry:** High Overdue, Offline > 48h, SIM Change, Root Detection, Payment Failed alerts.
12. **System Settings:** 10 Config Blocks (General, Notifications, Security, Firebase, Knox/OEM, Android Enterprise, SMS, Email, Backup, API).
13. **Payments & Collections:** Global revenue breakdown, top overdue distributors, 30-day collection trend.
14. **Recovery Management:** Platform-wide recovery docket cases (Total 126, In Progress, Resolved, Escalated).
15. **Policy Management:** Knox policy forge, lock policies, lockscreen wallpapers, `+ Create New Policy`.
16. **Broadcast / Bulk Commands:** Mass broadcast payload dispatch (`Lock`, `Unlock`, `Message`, `Wallpaper`, `Policy`).
17. **Geofence Management:** Zone maps (Office, Warehouse, City Boundary, High Risk Area), Geofence cards.
18. **Firmware & App Updates:** Target version v2.4.0 mandatory push update launcher.
19. **SIM & Network Monitoring:** SIM Swap alerts stream with old/new SIM pings, Retailer, Location, and Timestamp.
20. **Tamper & Security Events:** Security event counters (Root 56, ADB 34, Unlock Attempt 78, Factory Reset 12).
21. **Notifications Center:** System notification ticker with filter pills.
22. **Analytics & Insights:** Key metrics grid (Active 21,456, Collection Rate 78.4%, Recovery 82.6%, Lock Success 99.2%).
23. **Activity Timeline:** Chronological event dots across all platform nodes.
24. **Admin Profile & Security:** SuperAdmin dossier, 2FA status, active sessions, API tokens, security logs.
25. **Role Management (Screen 33):** System Roles (SuperAdmin, Distributor Admin, Retailer Admin, Support Agent, Finance Manager, View Only).
26. **Permission Matrix (Screen 34):** 9 Modules x 5 Roles Permission Checkmark Matrix (`✅ / ❌`).
27. **Territory Management (Screen 35):** Interactive Zone Map (North, East, West, South, Central Zones).
28. **Bulk Operations (Screen 36):** Bulk Lock, Bulk Unlock, Bulk Message, Bulk Wallpaper, Bulk Policy Update, Export Devices.
29. **Advanced Search (Screen 37):** Multi-param cross-query matrix (Device, Customer, Retailer, IMEI, Finance).
30. **Backup & Restore (Screen 39):** One-tap backup generation & restore selector.
31. **System Health (Screen 40):** Infrastructure component health monitor (Server Uptime 15d, API, Database, Firebase, SMS, Email, Knox, Storage).

---

### 🏢 B. Distributor App (`uniai-distributor-android`)
*Territory master operational hub for managing POS shop merchants, kit allocations, and territory ledgers.*

1. **Distributor Dashboard:** Territory active devices, active retailers, kit balance, territory revenue.
2. **Retailer Directory:** List of retailers under this distributor with credit limits and device counts.
3. **Create Retailer (Screen 26):** Onboard new POS merchant (Shop Name, Contact, Address, Kit Allocation, Credit Limit).
4. **Retailer Approval & KYC:** Verification docket for new store requests.
5. **Kit Allocation & Licensing:** Transfer key batches to retailers, track kit usage.
6. **Collections Ledger:** Track payments collected from retailers and outstanding dues.
7. **FastPass Transfer (QR Scanner):** 5-second QR code scan transfer for instant kit dispatch.
8. **Territory Performance:** Analytics on top-performing POS stores and overdue recovery.

---

### 🏪 C. Retailer App (`uniai-retailer-android`)
*POS merchant store operational app for customer finance onboarding, device registration, and daily EMI collection.*

1. **Retailer Workspace Dashboard:** Quick stats (Today's Sales, Active Finance, Overdue EMI, Available Kits), Bento Grid Action Cards.
2. **Customer Onboarding Wizard — Step 1: Customer Info (Screen 27):** Customer Name, Mobile, Alternate Mobile, Email, Address, Aadhaar/ID Proof.
3. **Customer Onboarding Wizard — Step 2: Device Registration (Screen 28):** IMEI Barcode Scan, Device Brand, Model, Android Version, SIM Slot, Purchase Date, Invoice PDF.
4. **Customer Onboarding Wizard — Step 3: Finance Agreement (Screen 29):** Device Price, Down Payment, Loan Amount, Monthly EMI, Tenure, EMI Due Dates, Agreement PDF, Complete Registration.
5. **EMI Collection & Store Wallet:** Receive cash/UPI EMI payments, print receipt, trigger instant device unlock.
6. **Local Device List:** Retailer's store customer devices with lock status and payment buttons.

---

## 🛠️ 3. Execution Strategy

1. **Super Admin App Overhaul (`uniai-superadmin-android`):** Build all 31 SuperAdmin-scoped screens in Jetpack Compose matching the exact designs in `4b91e148-01ff-4b20-85eb-c0331d1daa15.png`, `c379f3c9-6c76-4e6b-8d76-8343f4419603.png`, and `7d883ec7-e785-4eac-a390-b58070050c76.png`.
2. **Distributor App Synchronization (`uniai-distributor-android`):** Update `Create Retailer` (Screen 26) and Territory Management screens.
3. **Retailer App Synchronization (`uniai-retailer-android`):** Update the 3-Step Customer Onboarding Wizard (Screens 27, 28, 29).
4. **Compilation & Hardware Verification:** Rebuild with `./gradlew assembleDebug` and deploy to physical Realme device.

---

*Plan Location:* `<Artifact Directory>/uniguard_3_app_ecosystem_architectural_plan.md`  
*Signed by: Shoeb Ahmad*
