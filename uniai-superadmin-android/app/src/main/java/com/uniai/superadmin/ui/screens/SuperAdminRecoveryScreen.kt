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

data class RecoveryCase(
    val caseId: String,
    val customerName: String,
    val overdueDays: String,
    val amount: String,
    val agent: String,
    val status: String,
    val statusColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminRecoveryScreen() {
    val sampleCases = listOf(
        RecoveryCase("REC-401", "Vikram Singh", "45 Days Overdue", "₹ 7,250", "Agent Sunil Sharma", "IN PROGRESS", SolarAmber),
        RecoveryCase("REC-402", "Pankaj Sharma", "90 Days Overdue", "₹ 14,500", "Agent Amit Kumar", "ESCALATED", CrimsonRed),
        RecoveryCase("REC-403", "Anil Mehta", "15 Days Overdue", "₹ 2,450", "Unassigned", "PENDING", NeonCyan),
        RecoveryCase("REC-404", "Deepak Verma", "Cleared", "₹ 0", "Agent Sunil Sharma", "RESOLVED", EmeraldGreen)
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
                            text = "FIELD RECOVERY MANAGEMENT",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = CrimsonRed,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Recovery Management",
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
                            text = "126 ACTIVE CASES",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = CrimsonRed,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Summary Status Counters
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    RecStatBox(modifier = Modifier.weight(1f), title = "Overdue", count = "126", color = CrimsonRed)
                    RecStatBox(modifier = Modifier.weight(1f), title = "In Progress", count = "58", color = SolarAmber)
                    RecStatBox(modifier = Modifier.weight(1f), title = "Resolved", count = "62", color = EmeraldGreen)
                }
            }

            // Recovery Docket Cards
            item {
                Text("FIELD DOCKET STREAM", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
            }

            items(sampleCases) { c ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
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
                                    .background(c.statusColor.copy(alpha = 0.15f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Assignment, contentDescription = null, tint = c.statusColor, modifier = Modifier.size(22.dp))
                            }
                            Column {
                                Text(c.customerName, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("${c.caseId} • ${c.overdueDays}", fontSize = 11.sp, color = TextSecondary)
                                Text("Assigned: ${c.agent}", fontSize = 10.sp, color = NeonCyan, fontWeight = FontWeight.SemiBold)
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Surface(color = c.statusColor.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                                Text(c.status, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = c.statusColor, modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(c.amount, fontSize = 13.sp, fontWeight = FontWeight.Black, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RecStatBox(
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
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(count, fontSize = 16.sp, fontWeight = FontWeight.Black, color = color)
            Text(title, fontSize = 9.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
        }
    }
}
