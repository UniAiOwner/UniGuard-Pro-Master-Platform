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

data class GeofenceZone(
    val id: String,
    val name: String,
    val center: String,
    val radius: String,
    val deviceCount: String,
    val status: String,
    val statusColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminGeofenceScreen() {
    val sampleZones = listOf(
        GeofenceZone("GF-01", "Delhi NCR Authorized Zone", "Connaught Place, New Delhi", "25 km Radius", "4,210 Devices", "ACTIVE", EmeraldGreen),
        GeofenceZone("GF-02", "Mumbai Metropolitan Territory", "Bandra West, Mumbai", "30 km Radius", "3,890 Devices", "ACTIVE", EmeraldGreen),
        GeofenceZone("GF-03", "Noida Special Economic Zone", "Sector 62, Noida", "10 km Radius", "890 Devices", "BREACH ALERT", CrimsonRed)
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
            // Header Bar with Add Zone Button
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "GEOSPATIAL BOUNDARY ENGINE",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Geofence Rules",
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
                        Icon(Icons.Default.AddLocation, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Add Zone", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Simulated Geofence Polygon Canvas Preview
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    color = Color(0xFF0F141C),
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.3f))
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Explore, contentDescription = null, tint = NeonCyan, modifier = Modifier.size(36.dp))
                            Spacer(modifier = Modifier.height(6.dp))
                            Text("ACTIVE GEOSPATIAL POLYGON MAP", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("3 Geofence Zones Configured Across India", fontSize = 10.sp, color = TextSecondary)
                        }
                    }
                }
            }

            // Active Geofence Zones List
            item {
                Text("CONFIGURED GEOFENCE BOUNDARIES", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
            }

            items(sampleZones) { zone ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, zone.statusColor.copy(alpha = 0.3f))
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
                                    .background(zone.statusColor.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Place, contentDescription = null, tint = zone.statusColor, modifier = Modifier.size(20.dp))
                            }
                            Column {
                                Text(zone.name, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("${zone.center} • ${zone.radius}", fontSize = 11.sp, color = TextSecondary)
                                Text("Monitored Fleet: ${zone.deviceCount}", fontSize = 10.sp, color = NeonCyan, fontWeight = FontWeight.SemiBold)
                            }
                        }

                        Surface(color = zone.statusColor.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                            Text(zone.status, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = zone.statusColor, modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
                        }
                    }
                }
            }
        }
    }
}
