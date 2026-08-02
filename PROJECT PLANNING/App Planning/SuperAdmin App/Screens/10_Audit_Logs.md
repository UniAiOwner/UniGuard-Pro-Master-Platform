# 📱 Screen 10: Audit Logs

> **Target App Module:**  (UniGuard SuperAdmin Master App)  
> **UI Specification Location:**   
> **Screen Number:** Screen 10 of 35  

---

## 🎯 1. Purpose & Problem Solved
Cryptographically signed audit stream tracking all administrative actions, logins, and remote commands.

---

## ⚙️ 2. Comprehensive Option-by-Option Explanation

| UI Element / Option | Description & Functionality | Underlying Action / API Trigger |
|---|---|---|
| **Audit Search & Filters** | Filters logs by All, Commands, User Action, System Event, Policy Change. |  |
| **Log Entry Stream** | Chronological event cards showing Admin Identity (Admin m.chen), IP Address, Action (Changed User Policy), Target ID, and Timestamp. |  |
| **Security Hash Badge** | Displays HMAC-SHA256 signature status verifying log immutability. |  |

---

## 🛡️ 3. RBAC & Security Governance
- **Role Authority Required:** 
- **Audit Logging:** Every interaction on Screen 10 is cryptographically signed and stored in immutable audit logs.

---
*Signed by: Shoeb Ahmad*
