package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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

data class SuperAdminDistributor(
    val id: String,
    val name: String,
    val owner: String,
    val phone: String,
    val region: String,
    val keysAllocated: String,
    val pricePerKey: String,
    val activeRetailers: Int,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DistributorManagementScreen() {
    var distributors by remember {
        mutableStateOf(
            listOf(
                SuperAdminDistributor("1", "Surya Telecom Master", "Surya Pratap Singh", "+91 98765 43210", "UP West (Agra/Mathura)", "12,400", "₹70", 238, "ACTIVE"),
                SuperAdminDistributor("2", "Vardhman Wholesale", "Vardhman Jain", "+91 98111 22334", "Delhi NCR / Noida", "8,500", "₹65", 142, "ACTIVE"),
                SuperAdminDistributor("3", "Apex Mobile Hub", "Vikram Rathore", "+91 97654 32109", "Rajasthan / Jaipur", "4,200", "₹70", 78, "ACTIVE")
            )
        )
    }
    var showAddDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header Title
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "REGIONAL DISTRIBUTORS",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 2.sp
                        )
                        Text(
                            text = "Distributor Directory & Credit Suite",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Button(
                        onClick = { showAddDialog = true },
                        colors = ButtonDefaults.buttonColors(containerColor = NeonCyan),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("+ ADD", color = ObsidianBackground, fontWeight = FontWeight.ExtraBold, fontSize = 12.sp)
                    }
                }
            }

            // Summary KPI Banner
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(14.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.2f))
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("DISTRIBUTORS", fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
                            Text("${distributors.size}", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.ExtraBold)
                        }
                        Column {
                            Text("KEYS ALLOCATED", fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
                            Text("25,100", fontSize = 20.sp, color = EmeraldGreen, fontWeight = FontWeight.ExtraBold)
                        }
                        Column {
                            Text("RETAILERS COVERED", fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
                            Text("458 Stores", fontSize = 20.sp, color = AmberWarning, fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }
            }

            // List Header
            item {
                Text(
                    text = "ACTIVE MASTER DISTRIBUTORS",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextSecondary,
                    letterSpacing = 1.sp
                )
            }

            // Distributors List
            items(distributors) { dist ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(14.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(NeonCyan.copy(alpha = 0.1f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("🏢", fontSize = 20.sp)
                                }
                                Column {
                                    Text(
                                        text = dist.name,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = "${dist.owner} • ${dist.phone}",
                                        fontSize = 11.sp,
                                        color = TextSecondary
                                    )
                                }
                            }
                            Surface(
                                color = EmeraldGreen.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(20.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.4f))
                            ) {
                                Text(
                                    text = dist.status,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = EmeraldGreen,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text("REGION", fontSize = 9.sp, color = TextSecondary)
                                Text(dist.region, fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                            }
                            Column {
                                Text("STOCK / BALANCE", fontSize = 9.sp, color = TextSecondary)
                                Text("${dist.keysAllocated} Keys", fontSize = 11.sp, color = EmeraldGreen, fontWeight = FontWeight.Bold)
                            }
                            Column {
                                Text("RATE", fontSize = 9.sp, color = TextSecondary)
                                Text("${dist.pricePerKey}/key", fontSize = 11.sp, color = NeonCyan, fontWeight = FontWeight.Bold)
                            }
                            Column {
                                Text("RETAILERS", fontSize = 9.sp, color = TextSecondary)
                                Text("${dist.activeRetailers} Stores", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                }
            }
        }

        if (showAddDialog) {
            AlertDialog(
                onDismissRequest = { showAddDialog = false },
                title = { Text("ONBOARD NEW DISTRIBUTOR", color = Color.White, fontWeight = FontWeight.Bold) },
                text = { Text("To onboard a new territory distributor, please navigate to the 'Create Distributor' wizard module.", color = TextSecondary) },
                confirmButton = {
                    Button(
                        onClick = { showAddDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = NeonCyan, contentColor = ObsidianBackground)
                    ) {
                        Text("OK")
                    }
                },
                containerColor = ObsidianCard
            )
        }
    }
}
