package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminRemoteActionsScreen(
    imei: String = "864209041234567"
) {
    var selectedAction by remember { mutableStateOf<String?>(null) }
    var showConfirmDialog by remember { mutableStateOf(false) }

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
                            text = "ADVANCED HARDWARE COMMAND MATRIX",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Remote Actions",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    }
                    Surface(
                        color = EmeraldGreen.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.4f))
                    ) {
                        Text(
                            text = "ONLINE",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldGreen,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Target Handset Dossier
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text("TARGET HANDSET DOSSIER", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        Text("Samsung Galaxy A14 5G", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("IMEI: $imei • Customer: Ravi Kumar", fontSize = 11.sp, color = TextSecondary)
                        Text("DPC Container: Enrolled & Active • Battery: 84%", fontSize = 10.sp, color = EmeraldGreen)
                    }
                }
            }

            // Action Tile Grid
            item {
                Text("EXECUTIVE COMMAND PALETTE", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ActionTile(modifier = Modifier.weight(1f), title = "Lock Device", icon = Icons.Default.Lock, color = CrimsonRed) {
                        selectedAction = "Hard Lock Device"
                        showConfirmDialog = true
                    }
                    ActionTile(modifier = Modifier.weight(1f), title = "Unlock Device", icon = Icons.Default.LockOpen, color = EmeraldGreen) {
                        selectedAction = "Unlock Device"
                        showConfirmDialog = true
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ActionTile(modifier = Modifier.weight(1f), title = "Wipe Data", icon = Icons.Default.DeleteForever, color = CrimsonRed) {
                        selectedAction = "Factory Reset & Wipe"
                        showConfirmDialog = true
                    }
                    ActionTile(modifier = Modifier.weight(1f), title = "Reboot Device", icon = Icons.Default.RestartAlt, color = SolarAmber) {
                        selectedAction = "Remote Reboot"
                        showConfirmDialog = true
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ActionTile(modifier = Modifier.weight(1f), title = "Sound Siren", icon = Icons.Default.VolumeUp, color = SolarAmber) {
                        selectedAction = "Trigger Emergency Siren"
                        showConfirmDialog = true
                    }
                    ActionTile(modifier = Modifier.weight(1f), title = "Force Sync", icon = Icons.Default.Sync, color = NeonCyan) {
                        selectedAction = "Force Telemetry Sync"
                        showConfirmDialog = true
                    }
                }
            }
        }
    }

    if (showConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showConfirmDialog = false },
            title = { Text("EXECUTE REMOTE COMMAND?", color = Color.White, fontWeight = FontWeight.Bold) },
            text = { Text("Are you sure you want to trigger '$selectedAction' on target IMEI $imei? This operation will be cryptographically signed.", color = TextSecondary) },
            confirmButton = {
                Button(
                    onClick = { showConfirmDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed)
                ) {
                    Text("Confirm & Execute")
                }
            },
            dismissButton = {
                TextButton(onClick = { showConfirmDialog = false }) {
                    Text("Cancel", color = TextSecondary)
                }
            },
            containerColor = ObsidianCard
        )
    }
}

@Composable
fun ActionTile(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(28.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(title, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}
