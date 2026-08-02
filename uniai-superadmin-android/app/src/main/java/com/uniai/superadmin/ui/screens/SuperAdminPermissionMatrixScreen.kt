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
fun SuperAdminPermissionMatrixScreen() {
    var lockPerm by remember { mutableStateOf(true) }
    var wipePerm by remember { mutableStateOf(true) }
    var mintPerm by remember { mutableStateOf(true) }
    var exportPerm by remember { mutableStateOf(false) }
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
                            text = "GRANULAR ACCESS CONTROL",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Permission Matrix",
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
                        Text("Save Matrix", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Target Role Info
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("ROLE: Territory Distributor Admin", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        Text("Configuring module access rights for 14 active distributor accounts.", fontSize = 11.sp, color = TextSecondary)
                    }
                }
            }

            // Matrix Permission Toggles
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("MODULE PERMISSIONS GRID", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))

                        PermRow("Remote Lock / Unlock Commands", lockPerm) { lockPerm = it }
                        PermRow("Remote Factory Reset & Wipe Data", wipePerm) { wipePerm = it }
                        PermRow("License Key Minting & Allocation", mintPerm) { mintPerm = it }
                        PermRow("Export Financial PDF & CSV Ledger", exportPerm) { exportPerm = it }
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
                            text = "✓ Granular permission matrix saved & synced across active role sessions!",
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

@Composable
fun PermRow(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}
