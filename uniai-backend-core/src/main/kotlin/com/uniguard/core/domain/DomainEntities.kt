package com.uniguard.core.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID

@Table("retailers")
data class Retailer(
    @Id val retailerId: UUID? = null,
    val distributorId: UUID,
    val shopName: String,
    val ownerName: String,
    val phoneNumber: String,
    val gstin: String?,
    val addressLine: String,
    val latitude: Double?,
    val longitude: Double?,
    val creditLimitAmount: BigDecimal,
    val outstandingBalance: BigDecimal,
    val pricingTier: String,
    val isSuspended: Boolean,
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null
)

@Table("license_keys")
data class LicenseKey(
    @Id val keyId: UUID? = null,
    val keyCode: String,
    val batchId: String,
    val mintedByTenantId: UUID,
    val currentOwnerDistributorId: UUID?,
    val currentOwnerRetailerId: UUID?,
    val status: String,
    val hmacSignature: String,
    val consumedAt: OffsetDateTime?,
    val consumedByDeviceId: UUID?,
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null
)


