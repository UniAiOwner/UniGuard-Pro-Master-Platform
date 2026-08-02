package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminLiveMapScreen() {
    var selectedFilter by remember { mutableStateOf("All (543)") }
    var selectedPin by remember { mutableStateOf<String?>("Samsung Galaxy S23 (Ramesh Kumar)") }

    val filterOptions = listOf("All (543)", "Online (490)", "Locked (32)", "Tampered (21)")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
    ) {
        // Simulated Interactive Map Canvas Container
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0F141C))
        ) {
            // Simulated Map Grid Lines
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(6) {
                    HorizontalDivider(color = Color.White.copy(alpha = 0.03f))
                }
            }

            // Simulated Map Pin 1 (Mumbai)
            Surface(
                modifier = Modifier
                    .offset(x = 100.dp, y = 220.dp)
                    .clickable { selectedPin = "Samsung Galaxy S23 (Ramesh Kumar)" },
                color = EmeraldGreen,
                shape = CircleShape
            ) {
                Box(modifier = Modifier.padding(10.dp), contentAlignment = Alignment.Center) {
                    Icon(Icons.Default.LocationOn, contentDescription = null, tint = ObsidianBackground, modifier = Modifier.size(20.dp))
                }
            }

            // Simulated Map Pin 2 (Delhi - Locked)
            Surface(
                modifier = Modifier
                    .offset(x = 240.dp, y = 150.dp)
                    .clickable { selectedPin = "Pixel 7 Pro (Priya Sharma - LOCKED)" },
                color = CrimsonRed,
                shape = CircleShape
            ) {
                Box(modifier = Modifier.padding(10.dp), contentAlignment = Alignment.Center) {
                    Icon(Icons.Default.Lock, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                }
            }

            // Simulated Map Pin 3 (Jaipur - Tampered Alert)
            Surface(
                modifier = Modifier
                    .offset(x = 180.dp, y = 320.dp)
                    .clickable { selectedPin = "Realme GT 3 (Vikram Singh - GEOFENCE BREACH)" },
                color = SolarAmber,
                shape = CircleShape
            ) {
                Box(modifier = Modifier.padding(10.dp), contentAlignment = Alignment.Center) {
                    Icon(Icons.Default.Warning, contentDescription = null, tint = ObsidianBackground, modifier = Modifier.size(20.dp))
                }
            }
        }

        // Top Control Overlay
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(EmeraldGreen))
                        Text("GEOSPATIAL LIVE FEED", fontSize = 10.sp, fontWeight = FontWeight.ExtraBold, color = NeonCyan)
                    }
                }

                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Layers, contentDescription = "Map Layers", tint = Color.White)
                    }
                }
            }

            // Filter Pills
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(filterOptions) { filter ->
                    val isSelected = selectedFilter == filter
                    Surface(
                        modifier = Modifier.clickable { selectedFilter = filter },
                        color = if (isSelected) NeonCyan else ObsidianCard,
                        shape = RoundedCornerShape(20.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) NeonCyan else ObsidianCardBorder)
                    ) {
                        Text(
                            text = filter,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) ObsidianBackground else Color.White,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }

        // Selected Pin Detail Popup (Bottom Sheet Card)
        selectedPin?.let { pinText ->
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(16.dp),
                color = ObsidianCard,
                shape = RoundedCornerShape(20.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("SELECTED PIN TELEMETRY", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        IconButton(onClick = { selectedPin = null }, modifier = Modifier.size(24.dp)) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = TextSecondary)
                        }
                    }
                    Text(pinText, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("IMEI: 864209041234567", fontSize = 11.sp, color = TextSecondary)
                        Text("Speed: 0 km/h • Battery: 84%", fontSize = 11.sp, color = EmeraldGreen, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
