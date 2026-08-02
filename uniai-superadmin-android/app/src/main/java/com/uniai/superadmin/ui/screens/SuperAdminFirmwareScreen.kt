package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
fun SuperAdminFirmwareScreen() {
    var selectedRollout by remember { mutableStateOf("10% Staging") }
    val rolloutOptions = listOf("10% Staging", "50% Beta", "100% Production Global")
    var isUpdating by remember { mutableStateOf(false) }

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
                Column {
                    Text(
                        text = "OTA DPC & FIRMWARE DEPLOYER",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonCyan,
                        letterSpacing = 1.5.sp
                    )
                    Text(
                        text = "Firmware & App Updates",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }

            // Current Version & Rollout Card
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("TARGET DPC RELEASE v4.2.0-STABLE", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                            Surface(color = EmeraldGreen.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                                Text("READY TO PUSH", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = EmeraldGreen, modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
                            }
                        }
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        Text("• APK Hash: e3b0c44298fc1c149afbf4c8996fb92427ae", fontSize = 11.sp, color = TextSecondary)
                        Text("• Release Notes: Mandatory security patch for Android 14 USB debugging bypass shield and anti-tamper heartbeat.", fontSize = 11.sp, color = Color.White)
                        Text("• Payload Size: 18.4 MB • Signature: RSA-4096 VALID", fontSize = 10.sp, color = NeonCyan)
                    }
                }
            }

            // Staged Rollout Target Selection
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("STAGED ROLLOUT PHASE", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            items(rolloutOptions) { opt ->
                                val isSelected = selectedRollout == opt
                                Surface(
                                    modifier = Modifier.clickable { selectedRollout = opt },
                                    color = if (isSelected) NeonCyan else ObsidianSurface,
                                    shape = RoundedCornerShape(12.dp),
                                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) NeonCyan else ObsidianCardBorder)
                                ) {
                                    Text(
                                        text = opt,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isSelected) ObsidianBackground else Color.White,
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Deploy OTA Button
            item {
                Button(
                    onClick = { isUpdating = true },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldGreen),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Icon(Icons.Default.SystemUpdate, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("TRIGGER SILENT OTA UPDATE PUSH", fontSize = 13.sp, fontWeight = FontWeight.Black)
                }
            }

            if (isUpdating) {
                item {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = EmeraldGreen.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen)
                    ) {
                        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text("✓ Silent OTA Push Dispatched to $selectedRollout!", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = EmeraldGreen)
                            LinearProgressIndicator(progress = { 0.65f }, modifier = Modifier.fillMaxWidth(), color = EmeraldGreen, trackColor = Color.White.copy(alpha = 0.1f))
                            Text("Fleet Download Progress: 65% (16,075 / 24,731 devices updated)", fontSize = 10.sp, color = TextSecondary)
                        }
                    }
                }
            }
        }
    }
}
