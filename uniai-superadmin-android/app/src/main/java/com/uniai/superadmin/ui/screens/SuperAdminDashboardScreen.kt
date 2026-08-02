package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

data class MetricCardData(
    val title: String,
    val value: String,
    val trend: String,
    val isPositive: Boolean,
    val icon: ImageVector,
    val accentColor: Color,
    val onClick: () -> Unit
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminDashboardScreen(
    onNavigateToMint: () -> Unit = {},
    onNavigateToFraud: () -> Unit = {},
    onNavigateToDevices: () -> Unit = {},
    onNavigateToCommands: () -> Unit = {},
    onNavigateToDistributors: () -> Unit = {}
) {
    val metricCards = listOf(
        MetricCardData(
            title = "ACTIVE CONNECTED FLEET",
            value = "94,321",
            trend = "+5.2% Growth",
            isPositive = true,
            icon = Icons.Default.PhonelinkRing,
            accentColor = NeonCyan,
            onClick = onNavigateToDevices
        ),
        MetricCardData(
            title = "CRITICAL THREAT ALERTS",
            value = "14 Active",
            trend = "Action Required",
            isPositive = false,
            icon = Icons.Default.Warning,
            accentColor = CrimsonRed,
            onClick = onNavigateToFraud
        ),
        MetricCardData(
            title = "ACTIVE SUBSCRIPTIONS",
            value = "128,450",
            trend = "+12.4% MTD",
            isPositive = true,
            icon = Icons.Default.CheckCircle,
            accentColor = EmeraldGreen,
            onClick = {}
        ),
        MetricCardData(
            title = "MASTER DISTRIBUTORS",
            value = "245",
            trend = "Territory Coverage",
            isPositive = true,
            icon = Icons.Default.Business,
            accentColor = SolarAmber,
            onClick = onNavigateToDistributors
        ),
        MetricCardData(
            title = "POS RETAILERS DIRECTORY",
            value = "1,890",
            trend = "Active Outlets",
            isPositive = true,
            icon = Icons.Default.Storefront,
            accentColor = NeonCyan,
            onClick = {}
        ),
        MetricCardData(
            title = "PLATFORM REVENUE",
            value = "$4.2M",
            trend = "+8.1% MTD",
            isPositive = true,
            icon = Icons.Default.MonetizationOn,
            accentColor = EmeraldGreen,
            onClick = {}
        ),
        MetricCardData(
            title = "SYSTEM DPC RELEASE",
            value = "v4.2.1",
            trend = "STABLE BUILD",
            isPositive = true,
            icon = Icons.Default.SystemUpdate,
            accentColor = SolarAmber,
            onClick = {}
        ),
        MetricCardData(
            title = "SERVER UPTIME HEALTH",
            value = "99.8%",
            trend = "All Nodes Green",
            isPositive = true,
            icon = Icons.Default.Dns,
            accentColor = EmeraldGreen,
            onClick = {}
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Status Header (Original Blueprint Style)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(SolarAmber.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("SA", fontSize = 18.sp, fontWeight = FontWeight.Black, color = SolarAmber)
                }
                Column {
                    Text(
                        text = "UNIGUARD PRO MASTER",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonCyan,
                        letterSpacing = 1.5.sp
                    )
                    Text(
                        text = "Mission Control Center",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }

            Surface(
                color = EmeraldGreen.copy(alpha = 0.15f),
                shape = RoundedCornerShape(12.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.4f))
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(EmeraldGreen)
                    )
                    Text(
                        text = "NODE 01 ONLINE",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = EmeraldGreen
                    )
                }
            }
        }

        // Hero Command Telemetry Banner
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = ObsidianCard,
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("SOVEREIGN PLATFORM METRICS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                    Text("Real-Time Fleet & Revenue Telemetry", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                    Text("Last synced: 2 seconds ago • Cryptographically Signed", fontSize = 10.sp, color = TextSecondary)
                }

                Button(
                    onClick = onNavigateToMint,
                    colors = ButtonDefaults.buttonColors(containerColor = SolarAmber, contentColor = ObsidianBackground),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(Icons.Default.VpnKey, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Mint Keys", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // 2x4 Metric Cards Grid (Matching Screen 01 Blueprint Exactly)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(metricCards) { card ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { card.onClick() },
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, card.accentColor.copy(alpha = 0.3f))
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(34.dp)
                                    .clip(CircleShape)
                                    .background(card.accentColor.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = card.icon,
                                    contentDescription = null,
                                    tint = card.accentColor,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            Surface(
                                color = if (card.isPositive) EmeraldGreen.copy(alpha = 0.15f) else CrimsonRed.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text(
                                    text = card.trend,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (card.isPositive) EmeraldGreen else CrimsonRed,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Text(
                            text = card.value,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )

                        Text(
                            text = card.title,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextSecondary,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }
        }
    }
}
