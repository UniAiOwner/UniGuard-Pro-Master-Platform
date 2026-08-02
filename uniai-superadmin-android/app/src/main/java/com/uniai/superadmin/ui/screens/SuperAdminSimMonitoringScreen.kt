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

data class SimRecord(
    val imei: String,
    val customer: String,
    val carrier: String,
    val iccid: String,
    val status: String,
    val statusColor: Color,
    val lastPing: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminSimMonitoringScreen() {
    val simLogs = listOf(
        SimRecord("864209041234567", "Ravi Kumar", "Jio 5G", "8991400284920194829", "SIM REMOVED (ALERT)", CrimsonRed, "2 mins ago"),
        SimRecord("864209049876543", "Priya Sharma", "Airtel 5G", "8991100294029482019", "ORIGINAL SIM ACTIVE", EmeraldGreen, "5 mins ago"),
        SimRecord("864209041112233", "Amit Verma", "Vi 4G", "8991200194820492810", "NEW SIM INSERTED", SolarAmber, "12 mins ago"),
        SimRecord("864209044455667", "Suresh Gupta", "Jio 5G", "8991400829104928102", "ORIGINAL SIM ACTIVE", EmeraldGreen, "1 hour ago")
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "SIM & CARRIER TELEMETRY",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "SIM Monitoring",
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
                            text = "3 SIM SWAP ALERTS",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = CrimsonRed,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Network Health Telemetry
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SimStatTile(modifier = Modifier.weight(1f), title = "Active SIM Ping", value = "98.2%", color = EmeraldGreen)
                    SimStatTile(modifier = Modifier.weight(1f), title = "SIM Swaps Detected", value = "14 Today", color = CrimsonRed)
                    SimStatTile(modifier = Modifier.weight(1f), title = "No SIM Devices", value = "21 Offline", color = SolarAmber)
                }
            }

            // SIM Records Table
            item {
                Text("LIVE CARRIER & ICCID FEED", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
            }

            items(simLogs) { s ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, s.statusColor.copy(alpha = 0.3f))
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
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(s.statusColor.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.SimCard, contentDescription = null, tint = s.statusColor, modifier = Modifier.size(20.dp))
                            }
                            Column {
                                Text(s.customer, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("ICCID: ${s.iccid.take(12)}...", fontSize = 10.sp, color = TextSecondary)
                                Text("Carrier: ${s.carrier} • IMEI: ${s.imei.take(8)}...", fontSize = 10.sp, color = NeonCyan)
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Surface(color = s.statusColor.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                                Text(s.status, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = s.statusColor, modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(s.lastPing, fontSize = 10.sp, color = TextSecondary)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SimStatTile(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
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
            Text(value, fontSize = 14.sp, fontWeight = FontWeight.Black, color = color)
            Text(title, fontSize = 9.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
        }
    }
}
