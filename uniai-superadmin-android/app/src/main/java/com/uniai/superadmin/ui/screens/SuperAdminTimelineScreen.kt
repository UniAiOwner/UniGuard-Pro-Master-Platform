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

data class TimelineEvent(
    val id: String,
    val title: String,
    val actor: String,
    val timestamp: String,
    val category: String,
    val dotColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminTimelineScreen() {
    val sampleEvents = listOf(
        TimelineEvent("TL-801", "Global Standard Policy v2.3 Updated", "Admin Shoeb Ahmad", "10:14 AM Today", "POLICY_CHANGE", SolarAmber),
        TimelineEvent("TL-802", "5,000 License Keys Minted for Metro Mobiles", "System Kernel", "09:42 AM Today", "KEY_MINT", EmeraldGreen),
        TimelineEvent("TL-803", "SIM Swap Detected & Auto-Locked (UG-4892)", "AI Security Engine", "08:15 AM Today", "SECURITY_ALERT", CrimsonRed),
        TimelineEvent("TL-804", "SuperAdmin Master Login via 2FA Passkey", "Admin Shoeb Ahmad", "08:00 AM Today", "ADMIN_LOGIN", NeonCyan)
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
                        text = "CHRONOLOGICAL EVENT FEED",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonCyan,
                        letterSpacing = 1.5.sp
                    )
                    Text(
                        text = "Activity Timeline",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }

            // Timeline Stream Cards
            items(sampleEvents) { evt ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .clip(CircleShape)
                                .background(evt.dotColor)
                        )
                        Box(
                            modifier = Modifier
                                .width(2.dp)
                                .height(50.dp)
                                .background(Color.White.copy(alpha = 0.1f))
                        )
                    }

                    Surface(
                        modifier = Modifier.weight(1f),
                        color = ObsidianCard,
                        shape = RoundedCornerShape(14.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                    ) {
                        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(evt.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text(evt.timestamp, fontSize = 10.sp, color = TextSecondary)
                            }
                            Text("By: ${evt.actor} • ${evt.category}", fontSize = 10.sp, color = NeonCyan)
                        }
                    }
                }
            }
        }
    }
}
