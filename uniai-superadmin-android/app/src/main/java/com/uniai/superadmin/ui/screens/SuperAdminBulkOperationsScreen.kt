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

data class BulkOperationAction(
    val id: String,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminBulkOperationsScreen() {
    var selectedAction by remember { mutableStateOf<BulkOperationAction?>(null) }
    var showConfirmDialog by remember { mutableStateOf(false) }

    val bulkActions = listOf(
        BulkOperationAction("BO-01", "Apply Security Policy", "Mass enforce DPC policy preset across 10,000+ devices", Icons.Default.Security, NeonCyan),
        BulkOperationAction("BO-02", "Revoke Access Credentials", "Revoke OAuth/TOTP keys for inactive sub-admins", Icons.Default.VpnKey, CrimsonRed),
        BulkOperationAction("BO-03", "Force Password Reset", "Trigger compulsory passkey rotation on next unlock", Icons.Default.LockReset, SolarAmber),
        BulkOperationAction("BO-04", "Disable Non-Compliant", "Auto-lock devices failing hardware integrity checks", Icons.Default.Block, CrimsonRed),
        BulkOperationAction("BO-05", "Push Certificate Update", "Deploy updated TLS/SSL root CA certs fleetwide", Icons.Default.Verified, EmeraldGreen),
        BulkOperationAction("BO-06", "Wipe Remote Fleet Data", "Emergency mass factory reset for compromised inventory", Icons.Default.DeleteForever, CrimsonRed)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Header
        Column {
            Text(
                text = "MASS EXECUTION HUB",
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                color = NeonCyan,
                letterSpacing = 1.5.sp
            )
            Text(
                text = "Bulk Operations",
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                color = Color.White
            )
        }

        // Fleet Target Banner
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = ObsidianCard,
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("TARGET FLEET SCOPE", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                    Text("94,321 Active Connected Handsets", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                }

                Surface(color = NeonCyan.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                    Text("ALL REGIONS", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = NeonCyan, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
                }
            }
        }

        // Actions Grid
        Text("SELECT BATCH OPERATION", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(bulkActions) { act ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedAction = act
                            showConfirmDialog = true
                        },
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, act.color.copy(alpha = 0.3f))
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(act.color.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(act.icon, contentDescription = null, tint = act.color, modifier = Modifier.size(18.dp))
                        }
                        Text(act.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Text(act.description, fontSize = 10.sp, color = TextSecondary, lineHeight = 13.sp)
                    }
                }
            }
        }

        if (showConfirmDialog && selectedAction != null) {
            AlertDialog(
                onDismissRequest = { showConfirmDialog = false },
                title = { Text("CONFIRM BATCH EXECUTION", color = Color.White, fontWeight = FontWeight.Bold) },
                text = { Text("Are you sure you want to execute '${selectedAction?.title}' across 94,321 active handsets?", color = TextSecondary) },
                confirmButton = {
                    Button(
                        onClick = { showConfirmDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = selectedAction!!.color, contentColor = ObsidianBackground)
                    ) {
                        Text("CONFIRM EXECUTION", fontWeight = FontWeight.Bold)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showConfirmDialog = false }) {
                        Text("CANCEL", color = TextSecondary)
                    }
                },
                containerColor = ObsidianCard
            )
        }
    }
}
