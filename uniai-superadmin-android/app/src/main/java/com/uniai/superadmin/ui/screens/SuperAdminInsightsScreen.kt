package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminInsightsScreen() {
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
                            text = "SYSTEM PERFORMANCE ANALYTICS",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Analytics & Insights",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    }
                    Surface(
                        color = EmeraldGreen.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.4f))
                    ) {
                        Text(
                            text = "98.6% HEALTH",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldGreen,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Health Gauge & Active Users Visualizer
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("SYSTEM UPTIME & HEALTH RATING", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = EmeraldGreen)
                            Text("Last 30 Days", fontSize = 10.sp, color = TextSecondary)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text("99.98%", fontSize = 28.sp, fontWeight = FontWeight.Black, color = Color.White)
                                Text("Core API Server Uptime", fontSize = 11.sp, color = TextSecondary)
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text("1,432 MS", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = NeonCyan)
                                Text("Avg FCM Response Latency", fontSize = 10.sp, color = TextSecondary)
                            }
                        }
                    }
                }
            }

            // Key KPI Analytics Tiles
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    InsightStatTile(modifier = Modifier.weight(1f), title = "Active Admins", value = "42 Online", badge = "+4 Today", color = NeonCyan)
                    InsightStatTile(modifier = Modifier.weight(1f), title = "Total Incidents", value = "18 Flagged", badge = "-12% Prev", color = SolarAmber)
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    InsightStatTile(modifier = Modifier.weight(1f), title = "Auto Resolution", value = "94.2%", badge = "Optimal", color = EmeraldGreen)
                    InsightStatTile(modifier = Modifier.weight(1f), title = "Escalated Cases", value = "3 Active", badge = "Requires Review", color = CrimsonRed)
                }
            }
        }
    }
}

@Composable
fun InsightStatTile(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    badge: String,
    color: Color
) {
    Surface(
        modifier = modifier,
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(title, fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
                Surface(color = color.copy(alpha = 0.15f), shape = RoundedCornerShape(6.dp)) {
                    Text(badge, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = color, modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(value, fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color.White)
        }
    }
}
