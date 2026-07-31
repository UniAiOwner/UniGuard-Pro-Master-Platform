package com.uniguard.core.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID

@Table("finance_cases")
data class FinanceCase(
    @Id val caseId: UUID? = null,
    val retailerId: UUID,
    val licenseKeyId: UUID,
    val customerName: String,
    val customerMobile: String,
    val customerAadhaarHash: String?,
    val deviceMake: String,
    val deviceModel: String,
    val primaryImei: String,
    val secondaryImei: String?,
    val serialNumber: String?,
    val totalFinancedAmount: BigDecimal,
    val downpaymentAmount: BigDecimal,
    val emiAmount: BigDecimal,
    val totalTenureMonths: Int,
    val completedTenureMonths: Int,
    val nextDueDate: LocalDate,
    val caseStatus: String,
    val currentLockState: DeviceState,
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null
) {
    fun transitionLockState(target: DeviceState): FinanceCase {
        require(currentLockState.canTransitionTo(target)) {
            "Invalid state transition from $currentLockState to $target"
        }
        return this.copy(currentLockState = target)
    }
}
