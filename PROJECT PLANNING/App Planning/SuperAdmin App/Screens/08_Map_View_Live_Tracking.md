# 📱 Screen 08: Map View (Live Tracking)

> **Target App Module:**  (UniGuard SuperAdmin Master App)  
> **UI Specification Location:**   
> **Screen Number:** Screen 08 of 35  

---

## 🎯 1. Purpose & Problem Solved
Interactive geospatial map displaying global device fleet clusters, live GPS pings, and boundary alerts.

---

## ⚙️ 2. Comprehensive Option-by-Option Explanation

| UI Element / Option | Description & Functionality | Underlying Action / API Trigger |
|---|---|---|
| **Map Layer Controls** | Satellite view toggle, Dark vector map toggle, Cluster heatmap overlay. |  |
| **Status Filter Bar** | Pills: All (543), Online, Locked, Offline, Tampered. |  |
| **Device Pin Popup** | Tapping a pin reveals Device IMEI, Customer Name, Speed, Battery, and Last Ping timestamp. |  |
| **Geofence Violation Alerts** | Highlights devices operating outside permitted geographical boundaries. |  |

---

## 🛡️ 3. RBAC & Security Governance
- **Role Authority Required:** 
- **Audit Logging:** Every interaction on Screen 08 is cryptographically signed and stored in immutable audit logs.

---
*Signed by: Shoeb Ahmad*
