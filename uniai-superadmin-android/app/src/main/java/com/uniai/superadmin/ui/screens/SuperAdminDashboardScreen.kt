package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

data class TelemetryEvent(
    val id: String,
    val tenant: String,
    val eventType: String,
    val timestamp: String,
    val isAlert: Boolean
)

@Composable
fun SuperAdminDashboardScreen(
    onNavigateToMint: () -> Unit,
    onNavigateToFraud: () -> Unit
) {
    val telemetryList = listOf(
        TelemetryEvent("EVT-9041", "Airtel Finance", "FRP Lock Enforced", "Just now", false),
        TelemetryEvent("EVT-9040", "TVS Credit", "SIM Swap Blocked", "2m ago", true),
        TelemetryEvent("EVT-9039", "Home Credit", "HMAC Key Minted", "5m ago", false),
        TelemetryEvent("EVT-9038", "Bajaj Finserv", "Monotonic Time Reset Attempt", "12m ago", true),
        TelemetryEvent("EVT-9037", "Muthoot Micro", "Remote Lock Heartbeat ACK", "18m ago", false)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp)
    ) {
        // Top Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "MISSION CONTROL",
                    color = NeonCyan,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "SuperAdmin Platform Command",
                    color = TextSecondary,
                    fontSize = 12.sp
                )
            }
            Surface(
                color = ObsidianSurface,
                shape = RoundedCornerShape(12.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(EmeraldGreen))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "LIVE R2DBC", color = EmeraldGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 2x2 Bento Grid KPI Cards
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
                BentoKpiCard(
                    modifier = Modifier.weight(1f),
                    title = "LOCKED DEVICES",
                    value = "124,850",
                    subtitle = "+1,420 Today",
                    accentColor = NeonCyan,
                    icon = "📱"
                )
                BentoKpiCard(
                    modifier = Modifier.weight(1f),
                    title = "TENANTS ACTIVE",
                    value = "48",
                    subtitle = "100% RLS Isolated",
                    accentColor = RoyalPurple,
                    icon = "🏢"
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
                BentoKpiCard(
                    modifier = Modifier.weight(1f),
                    title = "MONTHLY VOLUME",
                    value = "₹ 1.42 Cr",
                    subtitle = "+18.4% MoM",
                    accentColor = EmeraldGreen,
                    icon = "💰"
                )
                BentoKpiCard(
                    modifier = Modifier.weight(1f),
                    title = "SYSTEM HEALTH",
                    value = "99.99%",
                    subtitle = "0 Fatal Anomalies",
                    accentColor = AmberWarning,
                    icon = "⚡"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Quick Action Command Buttons
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = onNavigateToMint,
                modifier = Modifier.weight(1f).height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NeonCyan),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("🔑 Mint Keys", color = ObsidianBackground, fontWeight = FontWeight.Bold)
            }
            Button(
                onClick = onNavigateToFraud,
                modifier = Modifier.weight(1f).height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("🛡️ Fraud Console", color = TextPrimary, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Real-Time Telemetry Feed Stream
        Text(
            text = "LIVE TELEMETRY STREAM",
            color = TextSecondary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            items(telemetryList) { item ->
                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        if (item.isAlert) CrimsonRed else ObsidianBorder
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = item.eventType,
                                    color = if (item.isAlert) CrimsonRed else TextPrimary,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = item.id,
                                    color = TextSecondary,
                                    fontSize = 11.sp
                                )
                            }
                            Text(
                                text = "Tenant: ${item.tenant}",
                                color = TextSecondary,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }
                        Text(
                            text = item.timestamp,
                            color = NeonCyan,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BentoKpiCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    subtitle: String,
    accentColor: Color,
    icon: String
) {
    Surface(
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = title, color = TextSecondary, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
                Text(text = icon, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value, color = accentColor, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(text = subtitle, color = TextSecondary, fontSize = 11.sp, modifier = Modifier.padding(top = 2.dp))
        }
    }
}
