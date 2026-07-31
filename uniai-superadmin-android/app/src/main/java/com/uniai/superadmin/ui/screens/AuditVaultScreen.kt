package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

data class AuditLogEntry(
    val id: String,
    val action: String,
    val actor: String,
    val timestamp: String,
    val hash: String
)

@Composable
fun AuditVaultScreen() {
    val auditLogs = listOf(
        AuditLogEntry("AUD-9901", "SUPERADMIN_HMAC_MINT_5000", "Shoeb Ahmad (Master)", "2026-07-31 20:01:14", "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"),
        AuditLogEntry("AUD-9900", "TENANT_RLS_CONTEXT_INJECTED", "System Kernel", "2026-07-31 19:42:08", "a5da3f27af272c4e69d86a0584cf92ef0522784c5cdb1e03c5588ea8f619e469"),
        AuditLogEntry("AUD-9899", "GLOBAL_EMERGENCY_LOCK_DISABLED", "Shoeb Ahmad (Master)", "2026-07-31 18:22:45", "11e9b12d8cf8c2d48787d49d65ae733a6ec323f4ddfbc1cc7d18f32f95cd7551"),
        AuditLogEntry("AUD-9898", "AI_FRAUD_ANOMALY_OVERRIDDEN", "Shoeb Ahmad (Master)", "2026-07-31 17:15:30", "35fee3b86d6d614474de1c896201b7e2e374e9e1406628894e70d32960cd4447")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp)
    ) {
        Text(
            text = "IMMUTABLE AUDIT VAULT",
            color = EmeraldGreen,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp
        )
        Text(
            text = "Cryptographically Signed Master Audit Log",
            color = TextSecondary,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 2.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            items(auditLogs) { log ->
                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(14.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = log.action, color = NeonCyan, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            Text(text = log.id, color = TextSecondary, fontSize = 11.sp)
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Actor: ${log.actor}", color = TextPrimary, fontSize = 12.sp)
                            Text(text = log.timestamp, color = TextSecondary, fontSize = 11.sp)
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = "SHA-256 Hash:", color = TextSecondary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        Text(text = log.hash, color = EmeraldGreen, fontSize = 10.sp)
                    }
                }
            }
        }
    }
}
