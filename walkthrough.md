# 🚀 Parallel Agency Swarm Execution Plan — UniGuard Pro v1.0

> **Artifact Path:** `<Artifact Directory>/parallel_agency_swarm_execution_plan.md`  
> **Target Standard:** Commercial DPC Standard (T-Cop / M-Cop Market Leader Architecture)  
> **Execution Strategy:** **Dual Parallel Agency Swarm (2x Development Velocity)**  
> **User Review Required:** YES — Please review proposed architecture before kickoff.

---

## 🎯 1. Goal & Architecture Overview

To build UniGuard Pro with maximum speed, zero shortcuts, and 100% production code quality, we will deploy **2 Specialized Agency Subagents** simultaneously:

```
┌────────────────────────────────────────────────────────────────────────┐
│                   PARALLEL AGENCY SWARM ARCHITECTURE                   │
├───────────────────────────────────┬────────────────────────────────────┤
│ 🛠️ SWARM AGENT A: BACKEND CORE    │ 📱 SWARM AGENT B: CUSTOMER DPC APP │
│ (Spring Boot 3.x + PostgreSQL 16) │ (Native Android DPC + Kiosk Lock)  │
├───────────────────────────────────┼────────────────────────────────────┤
│ ◾ Scaffolds `uniai-backend-core`  │ ◾ Scaffolds `uniai-dpc-android`    │
│ ◾ Writes `docker-compose.yml` DB  │ ◾ Configures `DeviceAdminReceiver` │
│ ◾ Executes PostgreSQL DDL scripts │ ◾ Implements Lock Screen Kiosk UI  │
│ ◾ Builds WebFlux API Controllers  │ ◾ Integrates Telemetry Heartbeat   │
└───────────────────────────────────┴────────────────────────────────────┘
```

---

## 🔬 2. Detailed Breakdown of Subagent Roles

### 🛠️ Agent A: Backend Microservices & Database Architect
- **Module Directory:** `uniai-backend-core/`
- **Tech Stack:** Spring Boot 3.3 (WebFlux Reactive), Kotlin 1.9, PostgreSQL 16, Redis 7, Liquibase DB migrations.
- **Key Tasks:**
  1. Create `docker-compose.yml` for PostgreSQL 16 (`port 5432`) and Redis 7 (`port 6379`).
  2. Implement Liquibase migration scripts for `tenants`, `distributors`, `retailers`, `license_keys`, `finance_cases`, `timeline_events`, `audit_logs`.
  3. Create Spring Boot WebFlux API Controllers for:
     - `POST /api/v1/admin/licenses/mint` (SuperAdmin Key Minting)
     - `POST /api/v1/retailer/devices/onboard` (Retailer 45s Onboarding)
     - `POST /api/v1/dpc/telemetry/heartbeat` (Customer DPC Telemetry Ping)
     - `POST /api/v1/payments/webhook` (Razorpay/Cashfree Auto-Debit Webhook)

### 📱 Agent B: Customer DPC Companion Shield Specialist
- **Module Directory:** `uniai-dpc-android/`
- **Tech Stack:** Native Android (Kotlin), Jetpack Compose, Material 3, Android Enterprise DevicePolicyManager API.
- **Key Tasks:**
  1. Create `uniai-dpc-android` Gradle project with Android Enterprise provisioning manifest (`<receiver android:name=".dpc.UniGuardAdminReceiver" ...>`).
  2. Implement `UniGuardDeviceAdminReceiver.kt` handling Device Owner provisioning callbacks, FRP key binding, and Knox hardware attestation.
  3. Implement **Kiosk Lock Screen UI (`LockedKioskScreen.kt`)** in Jetpack Compose featuring:
     - Dynamic EMI Overdue Banner (`₹ 1,400.00 Due`).
     - Live UPI QR Code Generator for instant customer self-payment.
     - 1-Tap Emergency Call Launcher (`112` emergency & Retailer Call button).
  4. Implement **72-Hour Offline Hard-Lock Worker (`OfflineLockWorker.kt`)** using hardware boot uptime calculations.

---

## 📑 3. Proposed File Tree Structure (To Be Created)

```
UniGuard Pro/
├── docker-compose.yml                      [NEW - Docker PostgreSQL 16 & Redis 7]
├── uniai-backend-core/                     [NEW - Spring Boot 3.x WebFlux Backend]
│   ├── build.gradle.kts
│   └── src/main/kotlin/com/uniguard/backend/
│       ├── config/
│       ├── controller/
│       ├── domain/
│       ├── repository/
│       └── service/
├── uniai-dpc-android/                      [NEW - Native Android DPC App]
│   ├── build.gradle.kts
│   └── src/main/java/com/uniguard/dpc/
│       ├── dpc/
│       │   ├── UniGuardAdminReceiver.kt
│       │   └── OfflineLockWorker.kt
│       ├── ui/
│       │   ├── theme/
│       │   └── screens/
│       │       └── LockedKioskScreen.kt
│       └── MainActivity.kt
└── dev_logs.txt
```

---

## 🧪 4. Verification & Testing Plan

1. **Backend Verification:**
   - Run `docker-compose up -d` to launch PostgreSQL 16 & Redis.
   - Execute Gradle build `./gradlew :uniai-backend-core:bootRun` and verify database tables created with RLS.
   - Run API health check `curl http://localhost:8080/actuator/health`.
2. **Android DPC Verification:**
   - Execute `./gradlew :uniai-dpc-android:assembleDebug` and verify zero compilation errors.
   - Verify `UniGuardAdminReceiver` declared in `AndroidManifest.xml`.

---

## ❓ Open Questions for User Approval

> [!IMPORTANT]
> **User Review Required:**
> 1. Do you approve launching the **Dual Parallel Agency Swarm** right now to build `uniai-backend-core` and `uniai-dpc-android` simultaneously?
> 2. Should we start creating the project files as outlined in the file tree above?

---

*Plan Location:* `<Artifact Directory>/parallel_agency_swarm_execution_plan.md`  
*Signed by: Shoeb Ahmad*
