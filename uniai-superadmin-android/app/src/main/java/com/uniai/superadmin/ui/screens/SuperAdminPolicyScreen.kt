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

data class PolicyPreset(
    val name: String,
    val description: String,
    val activeDevices: String,
    val isDefault: Boolean,
    val usbBlocked: Boolean,
    val frpEnforced: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminPolicyScreen() {
    var selectedCategory by remember { mutableStateOf("Device Policy") }
    val categories = listOf("Device Policy", "Lock Policy", "Wallpaper Policy", "Network Policy")

    val samplePolicies = listOf(
        PolicyPreset("Global Standard Policy v2.3", "Default DPC profile applied upon enrollment", "84,320 Handsets", true, true, true),
        PolicyPreset("High Security Enterprise Shield", "Paralyzes USB, Bluetooth & App Installs", "8,450 Handsets", false, true, true),
        PolicyPreset("Grace Period Restricted Policy", "Allows incoming calls & payment app only", "1,550 Handsets", false, false, true)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Header Bar with Create Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "DPC POLICY FORGE",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = NeonCyan,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "Policy Management",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = SolarAmber, contentColor = ObsidianBackground),
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("New Policy", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Category Filter
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(categories) { cat ->
                val isSelected = selectedCategory == cat
                Surface(
                    modifier = Modifier.clickable { selectedCategory = cat },
                    color = if (isSelected) NeonCyan else ObsidianCard,
                    shape = RoundedCornerShape(20.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) NeonCyan else ObsidianCardBorder)
                ) {
                    Text(
                        text = cat,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) ObsidianBackground else Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                    )
                }
            }
        }

        // Policy Presets List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(samplePolicies) { policy ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (policy.isDefault) SolarAmber.copy(alpha = 0.5f) else ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(policy.name, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            if (policy.isDefault) {
                                Surface(color = SolarAmber.copy(alpha = 0.15f), shape = RoundedCornerShape(6.dp)) {
                                    Text("DEFAULT", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = SolarAmber, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                                }
                            }
                        }
                        Text(policy.description, fontSize = 11.sp, color = TextSecondary)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Enforced Devices: ${policy.activeDevices}", fontSize = 11.sp, color = EmeraldGreen, fontWeight = FontWeight.Bold)
                            Text("USB Block: YES • FRP: YES", fontSize = 10.sp, color = TextSecondary)
                        }
                    }
                }
            }
        }
    }
}
