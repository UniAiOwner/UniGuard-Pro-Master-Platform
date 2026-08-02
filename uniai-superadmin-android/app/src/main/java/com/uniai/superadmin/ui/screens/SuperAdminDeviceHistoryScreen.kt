package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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

data class DeviceHistoryLog(
    val id: String,
    val event: String,
    val detail: String,
    val timestamp: String,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminDeviceHistoryScreen(
    imei: String = "864209041234567"
) {
    val historyLogs = listOf(
        DeviceHistoryLog("LOG-301", "HARD LOCK COMMAND DISPATCHED", "Triggered due to 15 days EMI overdue", "2026-08-01 14:22:10", CrimsonRed),
        DeviceHistoryLog("LOG-302", "SIM SWAP ALERT RESOLVED", "Original Jio SIM re-inserted into slot 1", "2026-07-28 11:05:44", EmeraldGreen),
        DeviceHistoryLog("LOG-303", "TEMPORARY GRACE UNLOCK GRANTED", "24-hour unlock window granted by Admin", "2026-07-20 09:12:30", SolarAmber),
        DeviceHistoryLog("LOG-304", "INITIAL DPC ENROLLMENT", "Device enrolled at Metro Mobiles POS", "2026-07-12 16:45:00", NeonCyan)
    )

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
                        text = "HISTORIC HARDWARE AUDIT TRAIL",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonCyan,
                        letterSpacing = 1.5.sp
                    )
                    Text(
                        text = "Device History",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }

            // Target IMEI Dossier Card
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("TARGET HANDSET: Samsung Galaxy A14 5G", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("IMEI: $imei • Customer: Ravi Kumar", fontSize = 11.sp, color = TextSecondary)
                    }
                }
            }

            // Audit Logs Stream
            items(historyLogs) { log ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, log.color.copy(alpha = 0.3f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(CircleShape)
                                .background(log.color.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.History, contentDescription = null, tint = log.color, modifier = Modifier.size(20.dp))
                        }
                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(log.event, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                            Text(log.detail, fontSize = 11.sp, color = TextSecondary)
                            Text(log.timestamp, fontSize = 10.sp, color = NeonCyan)
                        }
                    }
                }
            }
        }
    }
}
