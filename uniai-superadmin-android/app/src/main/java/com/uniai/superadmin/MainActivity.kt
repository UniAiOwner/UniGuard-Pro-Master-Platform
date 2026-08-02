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
    DEVICES("Devices", "📱"),
    COMMANDS("Lock Cmd", "🔒"),
    DISTRIBUTORS("Distro", "🏢"),
    RETAILERS("Retailers", "🏪"),
    CUSTOMER("Customer", "👤"),
    DIAGNOSTICS("Diag", "⚡"),
    MAP("Live Map", "🌐"),
    REPORTS("Reports", "📊"),
    AUDIT("Audit Vault", "🛡️"),
    THREATS("Threats", "⚠️"),
    CONFIG("Settings", "⚙️"),
    PAYMENTS("Payments", "💳"),
    RECOVERY("Recovery", "🚨"),
    POLICY("Policy", "📜"),
    BROADCAST("Broadcast", "📢"),
    GEOFENCE("Geofence", "📍"),
    FIRMWARE("Firmware", "📲"),
    SIM_MONITOR("SIM Alert", "📶"),
    TAMPER("Tamper", "🔍"),
    NOTIFICATIONS("Alerts", "🔔"),
    INSIGHTS("Insights", "📈"),
    TIMELINE("Timeline", "🕒"),
    PROFILE("Profile", "👤"),
    CREATE_DISTRO("New Distro", "➕"),
    ACTIONS("Actions", "⚡"),
    HISTORY("History", "📜"),
    ROLES("Roles", "🔑"),
    MATRIX("Matrix", "⚙️"),
    TERRITORY("Territory", "🗺️"),
    BULK_OPS("Bulk Ops", "⚡"),
    ADV_SEARCH("Search", "🔍"),
    NOTIF_SETTING("Notif Set", "🔔"),
    BACKUP("Backup", "💾"),
    SYS_HEALTH("Sys Health", "🩺"),
    MINT("Kernel", "🔑")
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
                                                    color = if (isSelected) SolarAmber else TextSecondary,
                                                    fontSize = 8.sp,
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
                                        onNavigateToMint = { selectedTab = SuperAdminTab.MINT },
                                        onNavigateToFraud = { selectedTab = SuperAdminTab.THREATS },
                                        onNavigateToDevices = { selectedTab = SuperAdminTab.DEVICES },
                                        onNavigateToCommands = { selectedTab = SuperAdminTab.COMMANDS },
                                        onNavigateToDistributors = { selectedTab = SuperAdminTab.DISTRIBUTORS }
                                    )
                                    SuperAdminTab.DEVICES -> SuperAdminDeviceOverviewScreen(
                                        onNavigateToDeviceDetail = { selectedTab = SuperAdminTab.DIAGNOSTICS }
                                    )
                                    SuperAdminTab.COMMANDS -> DeviceControlScreen()
                                    SuperAdminTab.DISTRIBUTORS -> DistributorManagementScreen()
                                    SuperAdminTab.RETAILERS -> SuperAdminRetailersOversightScreen()
                                    SuperAdminTab.CUSTOMER -> SuperAdminCustomerDetailsScreen()
                                    SuperAdminTab.DIAGNOSTICS -> SuperAdminDeviceDiagnosticsScreen()
                                    SuperAdminTab.MAP -> SuperAdminLiveMapScreen()
                                    SuperAdminTab.REPORTS -> SuperAdminReportsAnalyticsScreen()
                                    SuperAdminTab.AUDIT -> AuditVaultScreen()
                                    SuperAdminTab.THREATS -> AiFraudOverrideScreen()
                                    SuperAdminTab.CONFIG -> SystemConfigScreen()
                                    SuperAdminTab.PAYMENTS -> SuperAdminPaymentsScreen()
                                    SuperAdminTab.RECOVERY -> SuperAdminRecoveryScreen()
                                    SuperAdminTab.POLICY -> SuperAdminPolicyScreen()
                                    SuperAdminTab.BROADCAST -> SuperAdminBroadcastScreen()
                                    SuperAdminTab.GEOFENCE -> SuperAdminGeofenceScreen()
                                    SuperAdminTab.FIRMWARE -> SuperAdminFirmwareScreen()
                                    SuperAdminTab.SIM_MONITOR -> SuperAdminSimMonitoringScreen()
                                    SuperAdminTab.TAMPER -> SuperAdminSecurityEventsScreen()
                                    SuperAdminTab.NOTIFICATIONS -> SuperAdminNotificationsScreen()
                                    SuperAdminTab.INSIGHTS -> SuperAdminInsightsScreen()
                                    SuperAdminTab.TIMELINE -> SuperAdminTimelineScreen()
                                    SuperAdminTab.PROFILE -> SuperAdminProfileScreen()
                                    SuperAdminTab.CREATE_DISTRO -> SuperAdminCreateDistributorScreen()
                                    SuperAdminTab.ACTIONS -> SuperAdminRemoteActionsScreen()
                                    SuperAdminTab.HISTORY -> SuperAdminDeviceHistoryScreen()
                                    SuperAdminTab.ROLES -> SuperAdminRoleManagementScreen()
                                    SuperAdminTab.MATRIX -> SuperAdminPermissionMatrixScreen()
                                    SuperAdminTab.TERRITORY -> SuperAdminTerritoryScreen()
                                    SuperAdminTab.BULK_OPS -> SuperAdminBulkOperationsScreen()
                                    SuperAdminTab.ADV_SEARCH -> SuperAdminAdvancedSearchScreen()
                                    SuperAdminTab.NOTIF_SETTING -> SuperAdminNotificationSettingsScreen()
                                    SuperAdminTab.BACKUP -> SuperAdminBackupRestoreScreen()
                                    SuperAdminTab.SYS_HEALTH -> SuperAdminSystemHealthScreen()
                                    SuperAdminTab.MINT -> LicenseMintingKernelScreen()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
