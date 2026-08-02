package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun DeviceControlScreen(
    targetImei: String = "864209041234567"
) {
    var imeiInput by remember { mutableStateOf(targetImei) }
    var selectedAction by remember { mutableStateOf<String?>(null) }
    var showConfirmDialog by remember { mutableStateOf(false) }
    var actionStatusMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // 1. Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "HARDWARE COMMAND TOWER",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = CrimsonRed,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "Lock & Command Center",
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
                    text = "FCM ACTIVE",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = EmeraldGreen,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }

        // 2. Target Device Dossier Card
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = ObsidianCard,
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.4f))
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Text("TARGET DEVICE DOSSIER", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = imeiInput,
                    onValueChange = { imeiInput = it },
                    label = { Text("Target Device IMEI", color = TextSecondary) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonCyan,
                        unfocusedBorderColor = ObsidianCardBorder,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Customer: Ramesh Kumar", fontSize = 11.sp, color = TextPrimary)
                    Text("Battery: 84% • Online", fontSize = 11.sp, color = EmeraldGreen, fontWeight = FontWeight.Bold)
                }
            }
        }

        actionStatusMessage?.let { msg ->
            Surface(
                color = SolarAmber.copy(alpha = 0.15f),
                shape = RoundedCornerShape(12.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber)
            ) {
                Text(
                    text = msg,
                    fontSize = 12.sp,
                    color = SolarAmber,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }

        // 3. Command Grid Tiles (10 Action Modules)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            item {
                CommandActionTile(
                    title = "Lock Device",
                    subtitle = "Trigger DPC Kiosk Paralyze",
                    icon = Icons.Default.Lock,
                    color = CrimsonRed,
                    onClick = { selectedAction = "LOCK_DEVICE"; showConfirmDialog = true }
                )
            }
            item {
                CommandActionTile(
                    title = "Unlock Device",
                    subtitle = "Clear DPC Restrictions",
                    icon = Icons.Default.LockOpen,
                    color = EmeraldGreen,
                    onClick = { selectedAction = "UNLOCK_DEVICE"; showConfirmDialog = true }
                )
            }
            item {
                CommandActionTile(
                    title = "Temp Unlock",
                    subtitle = "24h EMI Grace Period",
                    icon = Icons.Default.Timer,
                    color = SolarAmber,
                    onClick = { selectedAction = "TEMP_UNLOCK"; showConfirmDialog = true }
                )
            }
            item {
                CommandActionTile(
                    title = "Send Message",
                    subtitle = "Custom Screen Banner",
                    icon = Icons.Default.Message,
                    color = NeonCyan,
                    onClick = { actionStatusMessage = "Message Payload Queued for IMEI $imeiInput" }
                )
            }
            item {
                CommandActionTile(
                    title = "Set Wallpaper",
                    subtitle = "Remote Payment Banner",
                    icon = Icons.Default.Image,
                    color = Color.White,
                    onClick = { actionStatusMessage = "Wallpaper Payload Sent to IMEI $imeiInput" }
                )
            }
            item {
                CommandActionTile(
                    title = "Play Siren Alert",
                    subtitle = "Override Silent Mode",
                    icon = Icons.Default.VolumeUp,
                    color = SolarAmber,
                    onClick = { actionStatusMessage = "Siren Command Fired to IMEI $imeiInput" }
                )
            }
            item {
                CommandActionTile(
                    title = "Restart Device",
                    subtitle = "Soft Remote Reboot",
                    icon = Icons.Default.RestartAlt,
                    color = NeonCyan,
                    onClick = { selectedAction = "RESTART"; showConfirmDialog = true }
                )
            }
            item {
                CommandActionTile(
                    title = "Wipe Data",
                    subtitle = "Factory Reset & Wipe",
                    icon = Icons.Default.DeleteForever,
                    color = CrimsonRed,
                    onClick = { selectedAction = "WIPE_DATA"; showConfirmDialog = true }
                )
            }
            item {
                CommandActionTile(
                    title = "Force Sync",
                    subtitle = "Instant Heartbeat Ping",
                    icon = Icons.Default.Sync,
                    color = EmeraldGreen,
                    onClick = { actionStatusMessage = "FCM Sync Ping Executed for IMEI $imeiInput" }
                )
            }
            item {
                CommandActionTile(
                    title = "Block USB",
                    subtitle = "Paralyze ADB/OTG Port",
                    icon = Icons.Default.Usb,
                    color = SolarAmber,
                    onClick = { actionStatusMessage = "USB Port Block Payload Active" }
                )
            }
        }
    }

    if (showConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showConfirmDialog = false },
            title = { Text("Confirm Action: $selectedAction", color = CrimsonRed, fontWeight = FontWeight.Bold) },
            text = { Text("Are you sure you want to execute $selectedAction on IMEI $imeiInput? This action will be signed and logged.", color = Color.White) },
            confirmButton = {
                Button(
                    onClick = {
                        showConfirmDialog = false
                        actionStatusMessage = "SUCCESS: Payload [$selectedAction] Executed for IMEI $imeiInput"
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed)
                ) {
                    Text("EXECUTE PAYLOAD", color = Color.White, fontWeight = FontWeight.Bold)
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
fun CommandActionTile(
    title: String,
    subtitle: String,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onClick() },
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(22.dp))
            Column {
                Text(title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Text(subtitle, fontSize = 9.sp, color = TextSecondary)
            }
        }
    }
}
