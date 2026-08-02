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
fun SuperAdminBroadcastScreen() {
    var selectedType by remember { mutableStateOf("Push Message") }
    var selectedTarget by remember { mutableStateOf("All Active Devices (24,731)") }
    var messageText by remember { mutableStateOf("Urgent Payment Reminder: Please clear your overdue EMI of ₹2,450 to avoid device lockdown.") }
    var showSendSuccess by remember { mutableStateOf(false) }

    val commandTypes = listOf("Push Message", "Wallpaper Push", "Lock Command", "Policy Sync")
    val targetSegments = listOf("All Active Devices (24,731)", "Delhi NCR Region (4,210)", "Overdue > 15 Days (1,240)", "Metro Mobiles POS (890)")

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
                        text = "FLEET BROADCAST ENGINE",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonCyan,
                        letterSpacing = 1.5.sp
                    )
                    Text(
                        text = "Broadcast Commands",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }

            // Command Type Selection
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("1. SELECT COMMAND TYPE", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            items(commandTypes) { type ->
                                val isSelected = selectedType == type
                                Surface(
                                    modifier = Modifier.clickable { selectedType = type },
                                    color = if (isSelected) NeonCyan else ObsidianSurface,
                                    shape = RoundedCornerShape(12.dp),
                                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) NeonCyan else ObsidianCardBorder)
                                ) {
                                    Text(
                                        text = type,
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

            // Target Audience Segment Filter
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("2. SELECT TARGET FLEET SEGMENT", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        targetSegments.forEach { seg ->
                            val isSelected = selectedTarget == seg
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { selectedTarget = seg }
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(seg, fontSize = 12.sp, color = if (isSelected) Color.White else TextSecondary, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
                                RadioButton(selected = isSelected, onClick = { selectedTarget = seg })
                            }
                        }
                    }
                }
            }

            // Message Composition Box
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("3. BROADCAST PAYLOAD CONTENT", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        OutlinedTextField(
                            value = messageText,
                            onValueChange = { messageText = it },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = NeonCyan,
                                unfocusedBorderColor = ObsidianCardBorder,
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White
                            ),
                            maxLines = 4
                        )
                    }
                }
            }

            // Dispatch Button
            item {
                Button(
                    onClick = { showSendSuccess = true },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Icon(Icons.Default.Send, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("DISPATCH BROADCAST PAYLOAD", fontSize = 13.sp, fontWeight = FontWeight.Black)
                }
            }

            if (showSendSuccess) {
                item {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = EmeraldGreen.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen)
                    ) {
                        Text(
                            text = "✓ Broadcast payload successfully queued for 24,731 target devices!",
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
