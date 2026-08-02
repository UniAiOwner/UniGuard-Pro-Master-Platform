# 📱 Screen 18: Firmware & OTA App Update

> **Target App Module:**  (UniGuard SuperAdmin Master App)  
> **UI Specification Location:**   
> **Screen Number:** Screen 18 of 35  

---

## 🎯 1. Purpose & Problem Solved
Over-The-Air update launcher for pushing mandatory DPC APK updates and system firmware packages.

---

## ⚙️ 2. Comprehensive Option-by-Option Explanation

| UI Element / Option | Description & Functionality | Underlying Action / API Trigger |
|---|---|---|
| **Update Status Card** | App Version (v4.1), Firmware Version (v3.2), Update Progress (55%). |  |
| **Release Notes Block** | Displays changelog and mandatory compliance updates. |  |
| **Target Selection** | Pills to select rollout percentage (10%, 50%, 100% Staged Rollout). |  |
| **Push Update Button** | Triggers background APK download and silent installation payload. |  |

---

## 🛡️ 3. RBAC & Security Governance
- **Role Authority Required:** 
- **Audit Logging:** Every interaction on Screen 18 is cryptographically signed and stored in immutable audit logs.

---
*Signed by: Shoeb Ahmad*
