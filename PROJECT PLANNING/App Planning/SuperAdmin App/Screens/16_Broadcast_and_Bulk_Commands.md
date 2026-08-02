# 📱 Screen 16: Broadcast / Bulk Commands

> **Target App Module:**  (UniGuard SuperAdmin Master App)  
> **UI Specification Location:**   
> **Screen Number:** Screen 16 of 35  

---

## 🎯 1. Purpose & Problem Solved
Mass payload dispatch engine for executing bulk actions across targeted device segments.

---

## ⚙️ 2. Comprehensive Option-by-Option Explanation

| UI Element / Option | Description & Functionality | Underlying Action / API Trigger |
|---|---|---|
| **Command Type Selector** | Text Message, Wallpaper Push, Lock Command, Policy Update, App Update. |  |
| **Target Audience Filter** | Segments: All 24,731 Devices, By Distributor, By Retailer, By Status, By Region. |  |
| **Message Input Box** | Text area to compose broadcast message or payment warning. |  |
| **Send Broadcast Button** | Dispatches bulk FCM payload to selected device segment. |  |

---

## 🛡️ 3. RBAC & Security Governance
- **Role Authority Required:** 
- **Audit Logging:** Every interaction on Screen 16 is cryptographically signed and stored in immutable audit logs.

---
*Signed by: Shoeb Ahmad*
