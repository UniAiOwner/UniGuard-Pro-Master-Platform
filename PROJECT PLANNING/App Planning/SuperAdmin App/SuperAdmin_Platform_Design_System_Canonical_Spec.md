# 📐 UniGuard SuperAdmin Platform — Canonical Design System v1.0

> **Document Location:** `/PROJECT PLANNING/App Planning/SuperAdmin App/SuperAdmin_Platform_Design_System_Canonical_Spec.md`  
> **Ecosystem Surface:** Native Android App (`uniai-superadmin-android`) + Web Portal (`uniai-superadmin-web`)  
> **Design Theme:** Dual Adaptive Engine (Porcelain White Light Mode ☀️ + Obsidian Dark Mode 🌙)  
> **CPO Rating:** **10 / 10 Masterpiece Standard**

---

## 🎨 1. Palette & Dual-Theme Matrix

```
┌────────────────────────────────────────────────────────────────────────┐
│               SUPERADMIN DUAL THEME ENGINE (MANDATORY ALL APPS)        │
├───────────────────────────────────┬────────────────────────────────────┤
│ ☀️ LIGHT MODE (Porcelain White):  │ 🌙 DARK MODE (Obsidian Dark):      │
│ ◾ Canvas: Clean White (#F8F9FA)   │ ◾ Canvas: Deep Obsidian (#0B0E14)  │
│ ◾ Cards: Crisp White Translucent  │ ◾ Cards: Glass Translucent 75%     │
│ ◾ Text: Pure Dark Slate (#0F172A) │ ◾ Text: Specular White (#FFFFFF)   │
│ ◾ Accents: Solar Amber / Cyan     │ ◾ Accents: Solar Amber / Cyan      │
└───────────────────────────────────┴────────────────────────────────────┘
```

---

## ⚙️ 2. Theme Switcher Rule (Mandatory in App Settings)

Every app (SuperAdmin, Distributor, Retailer, Customer) features a **Theme Switcher Component (`ThemeModeSelector.kt`)** in Settings ⚙️ with 3 options:
- `☀️ Light Mode` (Porcelain White)
- `🌙 Dark Mode` (Obsidian Dark)
- `🔄 System Default` (Follows Android OS system theme)

---

*Spec Location:* `/PROJECT PLANNING/App Planning/SuperAdmin App/SuperAdmin_Platform_Design_System_Canonical_Spec.md`  
*Signed by: Shoeb Ahmad*
