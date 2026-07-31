package com.uniguard.core.domain

enum class DeviceState {
    UNVERIFIED,
    ACTIVE,
    PENDING_OVERDUE,
    LOCKED,
    HARD_LOCKED;

    fun canTransitionTo(target: DeviceState): Boolean {
        return when (this) {
            UNVERIFIED -> target == ACTIVE
            ACTIVE -> target == PENDING_OVERDUE || target == LOCKED
            PENDING_OVERDUE -> target == ACTIVE || target == LOCKED || target == HARD_LOCKED
            LOCKED -> target == ACTIVE || target == HARD_LOCKED
            HARD_LOCKED -> target == ACTIVE
        }
    }
}
