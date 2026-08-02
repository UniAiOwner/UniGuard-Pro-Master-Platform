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

data class TerritoryZone(
    val id: String,
    val name: String,
    val masterDistributor: String,
    val deviceCount: String,
    val totalRevenue: String,
    val status: String,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminTerritoryScreen() {
    val zones = listOf(
        TerritoryZone("TZ-01", "North India Zone (Delhi, UP, PB)", "Metro Mobiles Wholesale", "42,100 Devices", "$1.8M", "ACTIVE", EmeraldGreen),
        TerritoryZone("TZ-02", "West India Zone (MH, GJ, RJ)", "Apex Telecom West", "34,800 Devices", "$1.4M", "ACTIVE", EmeraldGreen),
        TerritoryZone("TZ-03", "South India Zone (KA, TN, TS)", "Deccan Mobility Corp", "18,900 Devices", "$850K", "ACTIVE", NeonCyan),
        TerritoryZone("TZ-04", "East India Zone (WB, OR, AS)", "Eastern Digital Hub", "8,500 Devices", "$380K", "EXPANDING", SolarAmber)
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
                            text = "NATIONAL TERRITORY ALLOCATION",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Territory Management",
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
                        Icon(Icons.Default.Map, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Add Zone", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Interactive Vector India Map Canvas
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
                            Icon(Icons.Default.Public, contentDescription = null, tint = NeonCyan, modifier = Modifier.size(36.dp))
                            Spacer(modifier = Modifier.height(6.dp))
                            Text("INDIA MASTER TERRITORY VECTOR MAP", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("4 Master Zones • 245 Distributors Enrolled", fontSize = 10.sp, color = TextSecondary)
                        }
                    }
                }
            }

            // Zone Performance Cards
            item {
                Text("OPERATIONAL TERRITORY ZONES", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
            }

            items(zones) { z ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, z.color.copy(alpha = 0.3f))
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
                                    .background(z.color.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.PinDrop, contentDescription = null, tint = z.color, modifier = Modifier.size(20.dp))
                            }
                            Column {
                                Text(z.name, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("Master: ${z.masterDistributor}", fontSize = 10.sp, color = TextSecondary)
                                Text("Fleet: ${z.deviceCount} • Revenue: ${z.totalRevenue}", fontSize = 10.sp, color = NeonCyan, fontWeight = FontWeight.SemiBold)
                            }
                        }

                        Surface(color = z.color.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                            Text(z.status, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = z.color, modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
                        }
                    }
                }
            }
        }
    }
}
