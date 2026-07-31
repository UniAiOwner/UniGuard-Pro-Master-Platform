package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminDashboardScreen(
    onNavigateToMint: () -> Unit = {},
    onNavigateToFraud: () -> Unit = {}
) {
    var isHindiLanguage by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Header Bar with Vernacular Switcher & SaaS Title
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(EmeraldGreen)
                            )
                            Text(
                                text = "SYSTEM ONLINE • SAAS MASTER",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = EmeraldGreen,
                                letterSpacing = 1.sp
                            )
                        }
                        Text(
                            text = if (isHindiLanguage) "यूनीगार्ड ग्लोबल मास्टर" else "UNIGUARD GLOBAL MASTER",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            letterSpacing = 0.5.sp
                        )
                    }

                    // Vernacular Language Switcher Chip
                    Surface(
                        modifier = Modifier.clickable { isHindiLanguage = !isHindiLanguage },
                        color = ObsidianSurface,
                        shape = RoundedCornerShape(20.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.4f))
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(Icons.Default.Language, contentDescription = null, tint = NeonCyan, modifier = Modifier.size(16.dp))
                            Text(
                                text = if (isHindiLanguage) "हिंदी" else "English",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            // 2. Global Fleet Hero Banner (As in superadmin_app_ui_sample.jpg)
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(20.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.4f))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        SolarAmber.copy(alpha = 0.12f),
                                        ObsidianCard,
                                        NeonCyan.copy(alpha = 0.08f)
                                    )
                                )
                            )
                            .padding(20.dp)
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Text("🌐", fontSize = 18.sp)
                                    Text(
                                        text = "GLOBAL BOUND FLEET TELEMETRY",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = SolarAmber,
                                        letterSpacing = 1.5.sp
                                    )
                                }
                                Surface(
                                    color = EmeraldGreen.copy(alpha = 0.15f),
                                    shape = RoundedCornerShape(12.dp),
                                    border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.5f))
                                ) {
                                    Text(
                                        text = "LIVE SYNC",
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = EmeraldGreen,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "1,42,850",
                                fontSize = 42.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White,
                                letterSpacing = (-1).sp
                            )
                            Text(
                                text = "ACTIVE FINANCED HANDSETS WORLDWIDE (+1,420 TODAY)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextSecondary,
                                letterSpacing = 0.5.sp
                            )
                        }
                    }
                }
            }

            // 3. 3 Top Metric Grid Cards (Minted Licenses, Master Distributors, YTD Revenue)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    DashboardMetricTile(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Default.VpnKey,
                        title = "Minted Keys",
                        value = "5,00,000",
                        accentColor = SolarAmber
                    )
                    DashboardMetricTile(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Default.BusinessCenter,
                        title = "Distributors",
                        value = "42 Master",
                        accentColor = NeonCyan
                    )
                    DashboardMetricTile(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Default.AccountBalanceWallet,
                        title = "YTD Revenue",
                        value = "₹ 3.5 Cr",
                        accentColor = EmeraldGreen
                    )
                }
            }

            // 4. Primary Action Launcher (Glowing Amber Button: MINT NEW LICENSE BATCH)
            item {
                Button(
                    onClick = onNavigateToMint,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SolarAmber,
                        contentColor = ObsidianBackground
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
                ) {
                    Icon(Icons.Default.Bolt, contentDescription = null, modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "🔑 MINT NEW LICENSE BATCH (HMAC KERNEL)",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    )
                }
            }

            // 5. Quick Action Grid Title
            item {
                Text(
                    text = "COMMAND MODULES & DIRECTORIES",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextSecondary,
                    letterSpacing = 1.sp
                )
            }

            // Quick Action Grid Items
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    QuickActionDockTile(
                        modifier = Modifier.weight(1f),
                        title = "Master Distributors",
                        subtitle = "42 Regional Partners",
                        icon = Icons.Default.Group,
                        accentColor = NeonCyan,
                        onClick = { }
                    )
                    QuickActionDockTile(
                        modifier = Modifier.weight(1f),
                        title = "AI Fraud Threat Engine",
                        subtitle = "98.4% Risk Shield",
                        icon = Icons.Default.Shield,
                        accentColor = CrimsonRed,
                        onClick = onNavigateToFraud
                    )
                }
            }

            // 6. Live Telemetry Activity Stream
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "REAL-TIME TELEMETRY STREAM",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                letterSpacing = 1.sp
                            )
                            Text("120 events/min", fontSize = 10.sp, color = TextSecondary)
                        }

                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))

                        ActivityLogItem(
                            icon = Icons.Default.VpnKey,
                            title = "HMAC Batch Minted • 50,000 Keys",
                            subtitle = "Target: Surya Telecom Master • 2 mins ago",
                            badgeColor = SolarAmber
                        )
                        ActivityLogItem(
                            icon = Icons.Default.Shield,
                            title = "FRP Bypass Attempt Blocked",
                            subtitle = "IMEI 864209041234567 • Jaipur • Just now",
                            badgeColor = CrimsonRed
                        )
                        ActivityLogItem(
                            icon = Icons.Default.Business,
                            title = "New Distributor Onboarded",
                            subtitle = "Vardhman Mobiles (MP Central) • 1 hour ago",
                            badgeColor = EmeraldGreen
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DashboardMetricTile(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    value: String,
    accentColor: Color
) {
    Surface(
        modifier = modifier,
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, accentColor.copy(alpha = 0.25f))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Icon(icon, contentDescription = null, tint = accentColor, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(value, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
            Text(title, fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun QuickActionDockTile(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    icon: ImageVector,
    accentColor: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, accentColor.copy(alpha = 0.3f))
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(accentColor.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = accentColor, modifier = Modifier.size(20.dp))
            }
            Column {
                Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text(subtitle, fontSize = 10.sp, color = TextSecondary)
            }
        }
    }
}

@Composable
fun ActivityLogItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    badgeColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(badgeColor.copy(alpha = 0.15f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = badgeColor, modifier = Modifier.size(16.dp))
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(subtitle, fontSize = 10.sp, color = TextSecondary)
        }
    }
}
