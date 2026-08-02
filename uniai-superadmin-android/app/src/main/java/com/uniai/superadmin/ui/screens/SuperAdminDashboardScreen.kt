package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    onNavigateToFraud: () -> Unit = {},
    onNavigateToDevices: () -> Unit = {},
    onNavigateToCommands: () -> Unit = {},
    onNavigateToDistributors: () -> Unit = {},
    onNavigateToSettings: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        // 1. Top Header Bar (Menu Icon, Title "UniGuard Super Admin", Notification Bell)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
            }
            Text(
                text = "UniGuard Super Admin",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            IconButton(onClick = { }) {
                BadgedBox(badge = { Badge { Text("3") } }) {
                    Icon(Icons.Default.Notifications, contentDescription = "Alerts", tint = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 2. Greeting Title
        Text(
            text = "Welcome, David.",
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 4.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        // 3. 2x4 Metric Cards Grid (8 Core Platform Telemetry Cards)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            // Card 1: Active Devices
            item {
                MetricCardTile(
                    title = "ACTIVE DEVICES",
                    value = "94,321",
                    badgeText = "+5.2%",
                    badgeColor = EmeraldGreen,
                    icon = Icons.Default.Smartphone,
                    borderColor = NeonCyan,
                    accentColor = NeonCyan
                )
            }

            // Card 2: Critical Threats
            item {
                MetricCardTile(
                    title = "CRITICAL THREATS",
                    value = "14",
                    badgeText = "Amber",
                    badgeColor = SolarAmber,
                    icon = Icons.Default.Warning,
                    borderColor = SolarAmber,
                    accentColor = SolarAmber
                )
            }

            // Card 3: Subscriptions
            item {
                MetricCardTile(
                    title = "SUBSCRIPTIONS",
                    value = "128,450",
                    badgeText = "Active",
                    badgeColor = EmeraldGreen,
                    icon = Icons.Default.AccountBalanceWallet,
                    borderColor = ObsidianCardBorder,
                    accentColor = Color.White
                )
            }

            // Card 4: Master Distributors
            item {
                MetricCardTile(
                    title = "MASTER DISTRS",
                    value = "245",
                    badgeText = "Territory",
                    badgeColor = NeonCyan,
                    icon = Icons.Default.Person,
                    borderColor = ObsidianCardBorder,
                    accentColor = Color.White
                )
            }

            // Card 5: Active Retailers
            item {
                MetricCardTile(
                    title = "ACTIVE RETAILERS",
                    value = "1,890",
                    badgeText = "POS",
                    badgeColor = NeonCyan,
                    icon = Icons.Default.Storefront,
                    borderColor = ObsidianCardBorder,
                    accentColor = Color.White
                )
            }

            // Card 6: Revenue
            item {
                MetricCardTile(
                    title = "REVENUE (USD)",
                    value = "$4.2M",
                    badgeText = "+8.1%",
                    badgeColor = EmeraldGreen,
                    icon = Icons.Default.MonetizationOn,
                    borderColor = EmeraldGreen.copy(alpha = 0.4f),
                    accentColor = EmeraldGreen
                )
            }

            // Card 7: App Version
            item {
                MetricCardTile(
                    title = "APP VERSION",
                    value = "v4.2.1",
                    badgeText = "Latest",
                    badgeColor = TextSecondary,
                    icon = Icons.Default.Description,
                    borderColor = ObsidianCardBorder,
                    accentColor = TextSecondary
                )
            }

            // Card 8: Network Health
            item {
                MetricCardTile(
                    title = "NETWORK HEALTH",
                    value = "99.8%",
                    badgeText = "Healthy",
                    badgeColor = EmeraldGreen,
                    icon = Icons.Default.ShowChart,
                    borderColor = EmeraldGreen.copy(alpha = 0.4f),
                    accentColor = EmeraldGreen
                )
            }
        }
    }
}

@Composable
fun MetricCardTile(
    title: String,
    value: String,
    badgeText: String,
    badgeColor: Color,
    icon: ImageVector,
    borderColor: Color,
    accentColor: Color
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp),
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(20.dp)
                )
                Surface(
                    color = badgeColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = badgeText,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Column {
                Text(
                    text = title,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextSecondary,
                    letterSpacing = 0.5.sp
                )
                Text(
                    text = value,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White,
                    letterSpacing = (-0.5).sp
                )
            }
        }
    }
}

