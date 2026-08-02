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

data class DeviceItem(
    val imei: String,
    val model: String,
    val customerName: String,
    val status: String,
    val statusColor: Color,
    val lastSeen: String,
    val location: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminDeviceOverviewScreen(
    onNavigateToDeviceDetail: (String) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("All") }

    val filterOptions = listOf("All", "Online", "Locked", "Offline", "Tampered")

    val sampleDevices = listOf(
        DeviceItem("864209041234567", "Samsung Galaxy S23", "Ramesh Kumar", "Online", EmeraldGreen, "2 mins ago", "Mumbai, IN"),
        DeviceItem("359128059876543", "Pixel 7 Pro", "Priya Sharma", "Locked", CrimsonRed, "10 mins ago", "Delhi, IN"),
        DeviceItem("861234098765432", "OnePlus 11 5G", "Amit Verma", "Offline", SolarAmber, "4 hours ago", "Jaipur, IN"),
        DeviceItem("354987012345678", "Vivo V50 5G", "Suresh Gupta", "Online", EmeraldGreen, "Just now", "Indore, IN"),
        DeviceItem("869876043210987", "Realme GT 3", "Vikram Singh", "Tampered", CrimsonRed, "1 day ago", "Lucknow, IN")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // 1. Header Title & Count Badge
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "DEVICE FLEET DIRECTORY",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = NeonCyan,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "Device Overview",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
            Surface(
                color = NeonCyan.copy(alpha = 0.12f),
                shape = RoundedCornerShape(12.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.4f))
            ) {
                Text(
                    text = "24,731 TOTAL",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeonCyan,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
        }

        // 2. Universal Search Bar + Barcode Scanner Trigger Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search IMEI, Customer Name, Mobile...", color = TextSecondary, fontSize = 12.sp) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TextSecondary) },
                singleLine = true,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NeonCyan,
                    unfocusedBorderColor = ObsidianCardBorder,
                    focusedContainerColor = ObsidianCard,
                    unfocusedContainerColor = ObsidianCard,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Surface(
                modifier = Modifier
                    .size(52.dp)
                    .clickable { },
                color = ObsidianCard,
                shape = RoundedCornerShape(14.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.5f))
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(Icons.Default.QrCodeScanner, contentDescription = "Scan QR/Barcode", tint = SolarAmber)
                }
            }
        }

        // 3. Status Filter Pills
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
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
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                        color = if (isSelected) ObsidianBackground else Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                    )
                }
            }
        }

        // 4. Metric Summary Chips
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SummaryCountChip(modifier = Modifier.weight(1f), title = "Active", count = "21,456", color = EmeraldGreen)
            SummaryCountChip(modifier = Modifier.weight(1f), title = "Locked", count = "1,842", color = CrimsonRed)
            SummaryCountChip(modifier = Modifier.weight(1f), title = "Offline", count = "1,433", color = SolarAmber)
        }

        // 5. Device List Cards
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(sampleDevices) { device ->
                DeviceListItemCard(device = device, onClick = { onNavigateToDeviceDetail(device.imei) })
            }
        }
    }
}

@Composable
fun SummaryCountChip(
    modifier: Modifier = Modifier,
    title: String,
    count: String,
    color: Color
) {
    Surface(
        modifier = modifier,
        color = ObsidianCard,
        shape = RoundedCornerShape(12.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(count, fontSize = 14.sp, fontWeight = FontWeight.Black, color = color)
            Text(title, fontSize = 9.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DeviceListItemCard(
    device: DeviceItem,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
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
                        .background(device.statusColor.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Smartphone, contentDescription = null, tint = device.statusColor, modifier = Modifier.size(22.dp))
                }
                Column {
                    Text(device.model, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text("Customer: ${device.customerName}", fontSize = 11.sp, color = TextSecondary)
                    Text("IMEI: ${device.imei}", fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.SemiBold)
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Surface(
                    color = device.statusColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = device.status,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = device.statusColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(device.lastSeen, fontSize = 10.sp, color = TextSecondary)
            }
        }
    }
}
