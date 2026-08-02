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

data class NotificationItem(
    val id: String,
    val title: String,
    val detail: String,
    val category: String,
    val timestamp: String,
    val isUnread: Boolean,
    val iconColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminNotificationsScreen() {
    var selectedFilter by remember { mutableStateOf("All") }
    val filters = listOf("All", "High Priority", "Critical Alert", "Low Priority")

    val sampleNotifications = listOf(
        NotificationItem("NTF-101", "Unauthorized Admin Login Attempt", "IP 192.168.1.45 failed 2FA verification from Mumbai.", "Critical Alert", "2 mins ago", true, CrimsonRed),
        NotificationItem("NTF-102", "SIM Swap Detected on Handset UG-4892", "Customer Ravi Kumar's SIM was removed without auth.", "High Priority", "15 mins ago", true, SolarAmber),
        NotificationItem("NTF-103", "OTA DPC Package v4.2.0 Deployed", "Silent update completed successfully for 16,075 devices.", "Low Priority", "1 hour ago", false, EmeraldGreen),
        NotificationItem("NTF-104", "Distributor Quota Exhaustion Warning", "Metro Mobiles POS has utilized 95% of allocated license keys.", "High Priority", "3 hours ago", false, NeonCyan)
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
                    text = "REAL-TIME ALERT HUB",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = NeonCyan,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "Notifications Center",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
            TextButton(onClick = { }) {
                Text("Mark All Read", fontSize = 11.sp, color = NeonCyan, fontWeight = FontWeight.Bold)
            }
        }

        // Category Filters
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(filters) { f ->
                val isSelected = selectedFilter == f
                Surface(
                    modifier = Modifier.clickable { selectedFilter = f },
                    color = if (isSelected) NeonCyan else ObsidianCard,
                    shape = RoundedCornerShape(20.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) NeonCyan else ObsidianCardBorder)
                ) {
                    Text(
                        text = f,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) ObsidianBackground else Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                    )
                }
            }
        }

        // Notification Cards Stream
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(sampleNotifications) { n ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = if (n.isUnread) ObsidianCard else ObsidianSurface,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (n.isUnread) n.iconColor.copy(alpha = 0.5f) else ObsidianCardBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(CircleShape)
                                .background(n.iconColor.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Notifications, contentDescription = null, tint = n.iconColor, modifier = Modifier.size(20.dp))
                        }
                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(n.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text(n.timestamp, fontSize = 10.sp, color = TextSecondary)
                            }
                            Text(n.detail, fontSize = 11.sp, color = TextSecondary)
                        }
                    }
                }
            }
        }
    }
}
