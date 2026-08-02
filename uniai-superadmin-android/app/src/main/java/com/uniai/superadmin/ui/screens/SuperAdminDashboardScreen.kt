package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

// Exact colors matching 01_Dashboard_Overview.jpg
val CardPurple = Color(0xFF6B4EFF)
val CardGreen = Color(0xFF10B981)
val CardRed = Color(0xFFEF4444)
val CardAmber = Color(0xFFF59E0B)
val CardBlue = Color(0xFF3B82F6)
val ChartGrey = Color(0xFF4B5563)

data class ExactMetricCard(
    val title: String,
    val value: String,
    val trend: String,
    val isUp: Boolean,
    val isRedTrend: Boolean = false,
    val icon: ImageVector,
    val iconBgColor: Color
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
    val cards = listOf(
        ExactMetricCard("Protected Devices", "24,731", "↑ 2,150 (8.7%)", true, false, Icons.Default.PhonelinkLock, CardPurple),
        ExactMetricCard("Online Devices", "18,652", "↑ 1,240 (7.2%)", true, false, Icons.Default.Group, CardGreen),
        ExactMetricCard("Locked Devices", "312", "↓ 18 (5.4%)", false, true, Icons.Default.Lock, CardRed),
        ExactMetricCard("Overdue Payments", "₹ 48,75,230", "↑ 12.6%", true, false, Icons.Default.Schedule, CardAmber),
        ExactMetricCard("Active Retailers", "842", "↑ 68 (8.8%)", true, false, Icons.Default.Storefront, CardAmber),
        ExactMetricCard("Active Distributors", "28", "↑ 6 (21.7%)", true, false, Icons.Default.Business, CardGreen),
        ExactMetricCard("Recovery Cases", "126", "↑ 14 (12.5%)", true, false, Icons.Default.Shield, CardAmber),
        ExactMetricCard("Commands Today", "1,842", "↑ 231 (14.3%)", true, false, Icons.Default.TrendingUp, CardBlue)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B0F19))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // 1. Header Bar (1:1 with 01_Dashboard_Overview.jpg)
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(CardPurple.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Shield, contentDescription = null, tint = CardPurple, modifier = Modifier.size(20.dp))
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("UniGuard", fontSize = 16.sp, fontWeight = FontWeight.Black, color = Color.White)
                            Text("Super Admin", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = CardPurple)
                        }
                    }

                    Box {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Notifications, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                        }
                        Surface(
                            modifier = Modifier.align(Alignment.TopEnd),
                            color = CardRed,
                            shape = CircleShape
                        ) {
                            Text(
                                text = "13",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                            )
                        }
                    }
                }
            }

            // 2. Section Header: "Live Status"
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Live Status", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)

                    Surface(
                        color = Color(0xFF13231B),
                        shape = RoundedCornerShape(20.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, CardGreen.copy(alpha = 0.4f))
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(CircleShape)
                                    .background(CardGreen)
                            )
                            Text("Live Status", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = CardGreen)
                        }
                    }
                }
            }

            // 3. 2x4 Metric Cards Grid (1:1 with 01_Dashboard_Overview.jpg)
            items(cards.chunked(2).size) { rowIndex ->
                val rowCards = cards.chunked(2)[rowIndex]
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    rowCards.forEach { card ->
                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .height(108.dp),
                            color = Color(0xFF131A29),
                            shape = RoundedCornerShape(14.dp),
                            border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(card.iconBgColor.copy(alpha = 0.2f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(card.icon, contentDescription = null, tint = card.iconBgColor, modifier = Modifier.size(16.dp))
                                    }
                                    Text(card.title, fontSize = 11.sp, fontWeight = FontWeight.Medium, color = Color(0xFF9CA3AF))
                                }

                                Text(card.value, fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color.White)

                                Text(
                                    text = card.trend,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (card.isRedTrend) CardRed else CardGreen
                                )
                            }
                        }
                    }
                }
            }

            // 4. Device Status Donut Chart (1:1 with 01_Dashboard_Overview.jpg)
            item {
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Device Status", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text("View All", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = CardPurple)
                }
            }

            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF131A29),
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Canvas Donut Ring Chart
                        Box(
                            modifier = Modifier.size(120.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Canvas(modifier = Modifier.size(110.dp)) {
                                val strokeWidth = 14.dp.toPx()
                                // Online (75.4%)
                                drawArc(
                                    color = CardGreen,
                                    startAngle = -90f,
                                    sweepAngle = 271.4f,
                                    useCenter = false,
                                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                                )
                                // Offline (17.1%)
                                drawArc(
                                    color = CardPurple,
                                    startAngle = 181.4f,
                                    sweepAngle = 61.5f,
                                    useCenter = false,
                                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                                )
                                // Locked (1.3%)
                                drawArc(
                                    color = CardRed,
                                    startAngle = 242.9f,
                                    sweepAngle = 4.68f,
                                    useCenter = false,
                                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                                )
                                // Tampered (0.8%)
                                drawArc(
                                    color = CardAmber,
                                    startAngle = 247.58f,
                                    sweepAngle = 2.88f,
                                    useCenter = false,
                                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                                )
                                // Others (5.4%)
                                drawArc(
                                    color = ChartGrey,
                                    startAngle = 250.46f,
                                    sweepAngle = 19.44f,
                                    useCenter = false,
                                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("24,731", fontSize = 14.sp, fontWeight = FontWeight.Black, color = Color.White)
                                Text("Total", fontSize = 9.sp, color = Color(0xFF9CA3AF))
                            }
                        }

                        // Donut Legend Breakdown
                        Column(
                            verticalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.padding(start = 12.dp)
                        ) {
                            LegendRow("Online", "18,652 (75.4%)", CardGreen)
                            LegendRow("Offline", "4,231 (17.1%)", CardPurple)
                            LegendRow("Locked", "313 (1.3%)", CardRed)
                            LegendRow("Tampered", "196 (0.8%)", CardAmber)
                            LegendRow("Others", "1,340 (5.4%)", ChartGrey)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LegendRow(label: String, detail: String, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(color)
        )
        Column {
            Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(detail, fontSize = 9.sp, color = Color(0xFF9CA3AF))
        }
    }
}
