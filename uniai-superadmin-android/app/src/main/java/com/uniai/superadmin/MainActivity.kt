package com.uniai.superadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.screens.*
import com.uniai.superadmin.ui.theme.*

enum class SuperAdminTab(val title: String, val icon: String) {
    DASHBOARD("Control", "🏠"),
    DISTRIBUTORS("Distro", "🏢"),
    FORGE("Forge", "🔑"),
    DEVICE_CONTROL("Device", "📱"),
    CONFIG("Config", "⚙️"),
    AUDIT("Vault", "📜")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperAdminTheme {
                var isAuthenticated by remember { mutableStateOf(false) }
                var selectedTab by remember { mutableStateOf(SuperAdminTab.DASHBOARD) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = ObsidianBackground
                ) {
                    if (!isAuthenticated) {
                        SuperAdminAuthGatewayScreen(
                            onAuthSuccess = { isAuthenticated = true }
                        )
                    } else {
                        Scaffold(
                            bottomBar = {
                                NavigationBar(
                                    containerColor = ObsidianSurface,
                                    contentColor = TextPrimary,
                                    tonalElevation = 8.dp
                                ) {
                                    SuperAdminTab.values().forEach { tab ->
                                        val isSelected = selectedTab == tab
                                        NavigationBarItem(
                                            selected = isSelected,
                                            onClick = { selectedTab = tab },
                                            icon = {
                                                Text(
                                                    text = tab.icon,
                                                    fontSize = if (isSelected) 18.sp else 15.sp
                                                )
                                            },
                                            label = {
                                                Text(
                                                    text = tab.title,
                                                    color = if (isSelected) NeonCyan else TextSecondary,
                                                    fontSize = 10.sp,
                                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                                )
                                            },
                                            colors = NavigationBarItemDefaults.colors(
                                                indicatorColor = ObsidianCard
                                            )
                                        )
                                    }
                                }
                            }
                        ) { innerPadding ->
                            Box(modifier = Modifier.padding(innerPadding)) {
                                when (selectedTab) {
                                    SuperAdminTab.DASHBOARD -> SuperAdminDashboardScreen(
                                        onNavigateToMint = { selectedTab = SuperAdminTab.FORGE },
                                        onNavigateToFraud = { selectedTab = SuperAdminTab.AUDIT }
                                    )
                                    SuperAdminTab.DISTRIBUTORS -> DistributorManagementScreen()
                                    SuperAdminTab.FORGE -> KeyManagerScreen()
                                    SuperAdminTab.DEVICE_CONTROL -> DeviceControlScreen()
                                    SuperAdminTab.CONFIG -> SystemConfigScreen()
                                    SuperAdminTab.AUDIT -> AuditVaultScreen()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
