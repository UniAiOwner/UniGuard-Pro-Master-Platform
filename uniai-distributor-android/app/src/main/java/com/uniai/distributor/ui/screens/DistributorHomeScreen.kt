package com.uniai.distributor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DistributorHomeScreen() {
    val darkBg = Color(0xFF0B0E14)
    val cardBg = Color(0xFF161B26)
    val neonCyan = Color(0xFF00F5FF)
    val emerald = Color(0xFF10B981)
    val amber = Color(0xFFF59E0B)
    val crimson = Color(0xFFEF4444)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkBg)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header Banner
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "UNIGUARD HUB",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = neonCyan,
                            letterSpacing = 2.sp
                        )
                        Text(
                            text = "Surya Telecom Master",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Surface(
                        color = emerald.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(20.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, emerald.copy(alpha = 0.4f))
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(emerald)
                            )
                            Text(
                                text = "REGION: UP WEST",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = emerald
                            )
                        }
                    }
                }
            }

            // Bento Grid KPIs (2x2)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        DistributorKpiCard(
                            modifier = Modifier.weight(1f),
                            title = "Active Retailers",
                            value = "238",
                            subtext = "+12 This Month",
                            accentColor = neonCyan,
                            cardBg = cardBg
                        )
                        DistributorKpiCard(
                            modifier = Modifier.weight(1f),
                            title = "License Stock",
                            value = "12,400",
                            subtext = "Health: 84%",
                            accentColor = emerald,
                            cardBg = cardBg
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        DistributorKpiCard(
                            modifier = Modifier.weight(1f),
                            title = "Today's Activations",
                            value = "82",
                            subtext = "+18.4% vs Yday",
                            accentColor = amber,
                            cardBg = cardBg
                        )
                        DistributorKpiCard(
                            modifier = Modifier.weight(1f),
                            title = "Pending Dues",
                            value = "₹14.2L",
                            subtext = "11 Retailers Overdue",
                            accentColor = crimson,
                            cardBg = cardBg
                        )
                    }
                }
            }

            // Quick Actions Bar
            item {
                Text(
                    text = "QUICK ACTIONS",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    DistributorActionButton(
                        modifier = Modifier.weight(1f),
                        label = "FastPass Transfer",
                        icon = Icons.Default.QrCodeScanner,
                        color = neonCyan
                    )
                    DistributorActionButton(
                        modifier = Modifier.weight(1f),
                        label = "+ Onboard Store",
                        icon = Icons.Default.AddBusiness,
                        color = emerald
                    )
                    DistributorActionButton(
                        modifier = Modifier.weight(1f),
                        label = "Order Stock",
                        icon = Icons.Default.ShoppingCart,
                        color = amber
                    )
                }
            }

            // Recent Transfer Feed Title
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "LIVE RECENT ACTIVITY",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "View All",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = neonCyan
                    )
                }
            }

            // Activity Items
            items(
                listOf(
                    Triple("Vardhman Mobiles (Agra)", "500 Keys Transferred", "12 mins ago"),
                    Triple("Gupta Telecom (Mathura)", "100 Keys Transferred", "45 mins ago"),
                    Triple("Sharma Electronics (Aligarh)", "₹ 45,000 Payment Received", "2 hours ago"),
                    Triple("Chaudhary Mobiles (Meerut)", "250 Keys Transferred", "5 hours ago")
                )
            ) { item ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = cardBg,
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White.copy(alpha = 0.05f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = emerald,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.first,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = item.second,
                                fontSize = 12.sp,
                                color = Color.LightGray
                            )
                        }
                        Text(
                            text = item.third,
                            fontSize = 11.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DistributorKpiCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    subtext: String,
    accentColor: Color,
    cardBg: Color
) {
    Surface(
        modifier = modifier,
        color = cardBg,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, accentColor.copy(alpha = 0.2f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title.uppercase(),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtext,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = accentColor
            )
        }
    }
}

@Composable
fun DistributorActionButton(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector,
    color: Color
) {
    Surface(
        modifier = modifier,
        color = color.copy(alpha = 0.1f),
        shape = RoundedCornerShape(12.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier.size(22.dp)
            )
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
