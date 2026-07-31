package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

data class TenantInfo(
    val name: String,
    val tenantId: String,
    val activeDevices: String,
    val rlsStatus: String,
    val rateLimit: String
)

@Composable
fun TenantRegistryScreen() {
    val tenantList = listOf(
        TenantInfo("Airtel Finance Ltd", "TNT-AIRTEL-001", "48,250", "PostgreSQL RLS Active", "10,000 req/min"),
        TenantInfo("TVS Credit Services", "TNT-TVS-002", "32,100", "PostgreSQL RLS Active", "10,000 req/min"),
        TenantInfo("Home Credit India", "TNT-HOMECRED-003", "24,500", "PostgreSQL RLS Active", "8,000 req/min"),
        TenantInfo("Bajaj Finserv Direct", "TNT-BAJAJ-004", "18,900", "PostgreSQL RLS Active", "15,000 req/min"),
        TenantInfo("Muthoot Microfinance", "TNT-MUTHOOT-005", "1,100", "PostgreSQL RLS Active", "5,000 req/min")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp)
    ) {
        Text(
            text = "ENTERPRISE TENANT REGISTRY",
            color = RoyalPurple,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp
        )
        Text(
            text = "PostgreSQL Row-Level Security (RLS) Multi-Tenant Isolation",
            color = TextSecondary,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 2.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            items(tenantList) { tenant ->
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
                            Text(
                                text = tenant.name,
                                color = TextPrimary,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Surface(
                                color = RoyalPurple.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = tenant.tenantId,
                                    color = RoyalPurple,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Active Devices: ${tenant.activeDevices}", color = NeonCyan, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                            Text(text = tenant.rateLimit, color = TextSecondary, fontSize = 12.sp)
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "🛡️ ${tenant.rlsStatus}", color = EmeraldGreen, fontSize = 11.sp)
                    }
                }
            }
        }
    }
}
