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

data class ServerNodeHealth(
    val id: String,
    val name: String,
    val ip: String,
    val cpuUsage: Int,
    val memoryUsage: Int,
    val status: String,
    val statusColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminSystemHealthScreen() {
    val serverNodes = listOf(
        ServerNodeHealth("NODE-01", "Core API Gateway Node A", "10.0.4.10", 24, 48, "HEALTHY", EmeraldGreen),
        ServerNodeHealth("NODE-02", "Knox Policy Engine Node B", "10.0.4.11", 38, 62, "HEALTHY", EmeraldGreen),
        ServerNodeHealth("NODE-03", "Geospatial MQTT Cluster C", "10.0.4.12", 74, 82, "HIGH LOAD", SolarAmber),
        ServerNodeHealth("NODE-04", "PostgreSQL Primary DB Node D", "10.0.4.20", 42, 56, "HEALTHY", EmeraldGreen),
        ServerNodeHealth("NODE-05", "FCM Push Dispatcher Node E", "10.0.4.30", 18, 34, "HEALTHY", EmeraldGreen)
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
                        text = "INFRASTRUCTURE MONITOR",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonCyan,
                        letterSpacing = 1.5.sp
                    )
                    Text(
                        text = "System Infrastructure Health",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }

            // Health Status Banner
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("OVERALL CLUSTER STATUS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = EmeraldGreen)
                            Text("HEALTHY (5/5 Server Nodes Operational)", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                            Text("Avg Cluster Load: 39% CPU • 56% RAM • Uptime: 99.98%", fontSize = 10.sp, color = TextSecondary)
                        }

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(EmeraldGreen.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Dns, contentDescription = null, tint = EmeraldGreen, modifier = Modifier.size(22.dp))
                        }
                    }
                }
            }

            // Live Server Nodes
            item {
                Text("CLUSTER SERVER NODES", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
            }

            items(serverNodes) { n ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, n.statusColor.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(n.name, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("${n.id} • ${n.ip}", fontSize = 10.sp, color = TextSecondary)
                            }

                            Surface(color = n.statusColor.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                                Text(n.status, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = n.statusColor, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
                            }
                        }

                        // Usage Gauges
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            Column(modifier = Modifier.weight(1f)) {
                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text("CPU LOAD", fontSize = 9.sp, color = TextSecondary)
                                    Text("${n.cpuUsage}%", fontSize = 9.sp, color = NeonCyan, fontWeight = FontWeight.Bold)
                                }
                                LinearProgressIndicator(
                                    progress = { n.cpuUsage / 100f },
                                    modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                                    color = NeonCyan,
                                    trackColor = ObsidianBackground
                                )
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text("MEMORY", fontSize = 9.sp, color = TextSecondary)
                                    Text("${n.memoryUsage}%", fontSize = 9.sp, color = SolarAmber, fontWeight = FontWeight.Bold)
                                }
                                LinearProgressIndicator(
                                    progress = { n.memoryUsage / 100f },
                                    modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                                    color = SolarAmber,
                                    trackColor = ObsidianBackground
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
