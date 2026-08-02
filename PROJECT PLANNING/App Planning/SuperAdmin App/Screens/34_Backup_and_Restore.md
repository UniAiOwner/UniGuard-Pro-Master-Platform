# 📱 Screen 34: Backup & Restore

> **Target App Module:**  (UniGuard SuperAdmin Master App)  
> **UI Specification Location:**   
> **Screen Number:** Screen 34 of 35  

---

## 🎯 1. Purpose & Problem Solved
Disaster recovery center for managing automated database snapshots and system restores.

---

## ⚙️ 2. Comprehensive Option-by-Option Explanation

| UI Element / Option | Description & Functionality | Underlying Action / API Trigger |
|---|---|---|
| **Last Backup Summary** | Displays timestamp (1 Hr Ago), Status (Success), Destination (AWS S3 - Active). |  |
| **Disaster Restore Card** | Buttons to Restore Full System snapshot or Selective Data Restore. |  |
| **Create Snapshot Button** | Triggers immediate manual PostgreSQL/R2DBC database dump. |  |

---

## 🛡️ 3. RBAC & Security Governance
- **Role Authority Required:** 
- **Audit Logging:** Every interaction on Screen 34 is cryptographically signed and stored in immutable audit logs.

---
*Signed by: Shoeb Ahmad*
