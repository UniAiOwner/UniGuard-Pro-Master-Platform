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
fun SuperAdminDeviceDiagnosticsScreen(
    imei: String = "864209041234567"
) {
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
                            text = "TELEMETRY DIAGNOSTICS",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Device Diagnostics",
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
                            text = "HEALTHY",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldGreen,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Hardware Spec Banner
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Samsung Galaxy A14 5G", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("IMEI 1: $imei • IMEI 2: 864209049876543", fontSize = 11.sp, color = TextSecondary)
                        Text("Serial Number: R58T409XYZ • OS: Android 14 (API 34)", fontSize = 11.sp, color = TextSecondary)
                    }
                }
            }

            // Real-Time Telemetry Bar Cards
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    DiagMetricBox(modifier = Modifier.weight(1f), title = "Battery", value = "68%", sub = "Charging", color = EmeraldGreen)
                    DiagMetricBox(modifier = Modifier.weight(1f), title = "Signal", value = "5G", sub = "Excellent", color = NeonCyan)
                    DiagMetricBox(modifier = Modifier.weight(1f), title = "GPS", value = "Active", sub = "±5m Acc.", color = SolarAmber)
                }
            }

            // Security & Compliance Diagnostics List
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("SECURITY & COMPLIANCE CHECKS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        DiagCheckRow("Device Admin Status", "Enrolled & Active", EmeraldGreen)
                        DiagCheckRow("Bootloader Lock", "LOCKED (SECURE)", EmeraldGreen)
                        DiagCheckRow("Root / Magisk Detection", "NONE (Clean Kernel)", EmeraldGreen)
                        DiagCheckRow("SIM Swap Monitor", "Original SIM (Jio)", EmeraldGreen)
                        DiagCheckRow("FRP Bypass Shield", "ACTIVE (Enforced)", EmeraldGreen)
                        DiagCheckRow("Policy Version", "v2.3.1 (Latest)", NeonCyan)
                    }
                }
            }
        }
    }
}

@Composable
fun DiagMetricBox(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    sub: String,
    color: Color
) {
    Surface(
        modifier = modifier,
        color = ObsidianCard,
        shape = RoundedCornerShape(12.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(value, fontSize = 16.sp, fontWeight = FontWeight.Black, color = color)
            Text(title, fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Text(sub, fontSize = 9.sp, color = TextSecondary)
        }
    }
}

@Composable
fun DiagCheckRow(label: String, result: String, resultColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, fontSize = 12.sp, color = TextSecondary)
        Surface(color = resultColor.copy(alpha = 0.15f), shape = RoundedCornerShape(6.dp)) {
            Text(result, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = resultColor, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
        }
    }
}
