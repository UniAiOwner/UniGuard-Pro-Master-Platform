package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminNotificationSettingsScreen() {
    var adminAlerts by remember { mutableStateOf(true) }
    var threatAlerts by remember { mutableStateOf(true) }
    var policyViolations by remember { mutableStateOf(true) }
    var deviceStatusAlerts by remember { mutableStateOf(false) }

    var maintenanceAlerts by remember { mutableStateOf(true) }
    var newAdminActivity by remember { mutableStateOf(true) }

    var pushChannel by remember { mutableStateOf(true) }
    var emailChannel by remember { mutableStateOf(true) }
    var smsChannel by remember { mutableStateOf(false) }

    var isSaved by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "ALERT PREFERENCE CONFIGURATOR",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Notification Settings",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    }

                    Button(
                        onClick = { isSaved = true },
                        colors = ButtonDefaults.buttonColors(containerColor = EmeraldGreen),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(Icons.Default.Save, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Save Config", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Security Alert Section
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CrimsonRed.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("SECURITY & THREAT NOTIFICATIONS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = CrimsonRed)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))

                        PermRow("Sovereign Root & Admin Access Alerts", adminAlerts) { adminAlerts = it }
                        PermRow("SIM Swap & AI Fraud Threat Alerts", threatAlerts) { threatAlerts = it }
                        PermRow("DPC Policy Violation Events", policyViolations) { policyViolations = it }
                        PermRow("Individual Handset Offline Events", deviceStatusAlerts) { deviceStatusAlerts = it }
                    }
                }
            }

            // System Activity Section
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("SYSTEM & INFRASTRUCTURE ALERTS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))

                        PermRow("Server Infrastructure Maintenance", maintenanceAlerts) { maintenanceAlerts = it }
                        PermRow("Sub-Admin Login & Role Activity", newAdminActivity) { newAdminActivity = it }
                    }
                }
            }

            // Delivery Channels Section
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("DISPATCH DELIVERY CHANNELS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = NeonCyan)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))

                        PermRow("Push Notifications (FCM Mobile)", pushChannel) { pushChannel = it }
                        PermRow("Email Digest (Secured TLS Mail)", emailChannel) { emailChannel = it }
                        PermRow("SMS Gateway Alerts (High Priority)", smsChannel) { smsChannel = it }
                    }
                }
            }

            if (isSaved) {
                item {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = EmeraldGreen.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen)
                    ) {
                        Text(
                            text = "✓ Notification preferences updated & saved to cloud profile!",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldGreen,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }
    }
}
