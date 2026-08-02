package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
fun SuperAdminReportsAnalyticsScreen() {
    var selectedRange by remember { mutableStateOf("30 Days") }
    val timeRanges = listOf("Today", "7 Days", "30 Days", "This Month")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Header Bar with Export Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "EXECUTIVE BI TELEMETRY",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = NeonCyan,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "Reports & Analytics",
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
                Icon(Icons.Default.Download, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Export PDF", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Time Range Filter
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(timeRanges) { range ->
                val isSelected = selectedRange == range
                Surface(
                    modifier = Modifier.clickable { selectedRange = range },
                    color = if (isSelected) NeonCyan else ObsidianCard,
                    shape = RoundedCornerShape(20.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) NeonCyan else ObsidianCardBorder)
                ) {
                    Text(
                        text = range,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) ObsidianBackground else Color.White,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                    )
                }
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.weight(1f)
        ) {
            // Key BI Metrics Cards Grid
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ReportStatTile(modifier = Modifier.weight(1f), title = "Total Revenue", value = "$4.2M", badge = "+8.1%", color = EmeraldGreen)
                    ReportStatTile(modifier = Modifier.weight(1f), title = "Recovery Rate", value = "78.4%", badge = "High", color = NeonCyan)
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ReportStatTile(modifier = Modifier.weight(1f), title = "Lock Commands", value = "12,431", badge = "Enforced", color = CrimsonRed)
                    ReportStatTile(modifier = Modifier.weight(1f), title = "Unlock Verifications", value = "11,890", badge = "Verified", color = SolarAmber)
                }
            }

            // Simulated Collection Trend Visualizer
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
                            Text("30-DAY EMI COLLECTION TREND", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = EmeraldGreen)
                            Text("Target: $5.0M", fontSize = 10.sp, color = TextSecondary)
                        }

                        // Simulated Chart Bars
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            listOf(40, 65, 55, 80, 95, 70, 85, 100, 90, 110).forEach { height ->
                                Box(
                                    modifier = Modifier
                                        .width(22.dp)
                                        .height(height.dp)
                                        .background(EmeraldGreen.copy(alpha = 0.7f), shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ReportStatTile(
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
            Text(value, fontSize = 20.sp, fontWeight = FontWeight.Black, color = Color.White)
        }
    }
}
