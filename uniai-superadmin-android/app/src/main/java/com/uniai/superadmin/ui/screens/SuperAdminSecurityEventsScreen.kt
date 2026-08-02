package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

data class TamperRecord(
    val eventId: String,
    val deviceImei: String,
    val customer: String,
    val eventType: String,
    val autoResponse: String,
    val severity: String,
    val severityColor: Color,
    val timestamp: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminSecurityEventsScreen() {
    var selectedFilter by remember { mutableStateOf("High Severity") }
    val filters = listOf("High Severity", "Medium", "Low", "All Events")

    val sampleEvents = listOf(
        TamperRecord("EVT-9041", "864209041234567", "Ravi Kumar", "USB Debugging Enabled Attempt", "HARD LOCK TRIGGERED", "HIGH", CrimsonRed, "Just now"),
        TamperRecord("EVT-9040", "864209049876543", "Priya Sharma", "Bootloader Unlock Command Detected", "KNOX SHIELD ENFORCED", "CRITICAL", CrimsonRed, "12 mins ago"),
        TamperRecord("EVT-9039", "864209041112233", "Amit Verma", "Safe Mode Boot Detected", "PASSTHROUGH KIOSK RESTART", "MEDIUM", SolarAmber, "1 hour ago"),
        TamperRecord("EVT-9038", "864209044455667", "Suresh Gupta", "Factory Reset Attempt Blocked", "FRP SHIELD ACTIVE", "HIGH", CrimsonRed, "3 hours ago")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "HARDWARE FORENSIC MONITOR",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = CrimsonRed,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "Tamper & Security Events",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
            Surface(
                color = CrimsonRed.copy(alpha = 0.15f),
                shape = RoundedCornerShape(12.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, CrimsonRed.copy(alpha = 0.4f))
            ) {
                Text(
                    text = "AUTO-LOCK ENFORCED",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = CrimsonRed,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }

        // Severity Filters
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(filters) { f ->
                val isSelected = selectedFilter == f
                Surface(
                    modifier = Modifier.clickable { selectedFilter = f },
                    color = if (isSelected) CrimsonRed else ObsidianCard,
                    shape = RoundedCornerShape(20.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) CrimsonRed else ObsidianCardBorder)
                ) {
                    Text(
                        text = f,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color.White else TextSecondary,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                    )
                }
            }
        }

        // Event Stream Cards
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(sampleEvents) { evt ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, evt.severityColor.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(evt.severityColor.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Security, contentDescription = null, tint = evt.severityColor, modifier = Modifier.size(22.dp))
                            }
                            Column {
                                Text(evt.eventType, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("IMEI: ${evt.deviceImei.take(8)}... • ${evt.customer}", fontSize = 10.sp, color = TextSecondary)
                                Text("Auto Response: ${evt.autoResponse}", fontSize = 10.sp, color = NeonCyan, fontWeight = FontWeight.Bold)
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Surface(color = evt.severityColor.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                                Text(evt.severity, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = evt.severityColor, modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(evt.timestamp, fontSize = 10.sp, color = TextSecondary)
                        }
                    }
                }
            }
        }
    }
}
