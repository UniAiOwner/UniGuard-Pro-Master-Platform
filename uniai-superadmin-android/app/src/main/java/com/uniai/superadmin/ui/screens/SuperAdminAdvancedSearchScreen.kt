package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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

data class SearchResultItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val type: String,
    val status: String,
    val statusColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminAdvancedSearchScreen() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("ALL") }
    var hasSearched by remember { mutableStateOf(false) }

    val categories = listOf("ALL", "DEVICES", "DISTRIBUTORS", "TRANSACTIONS", "LOGS")

    val sampleResults = listOf(
        SearchResultItem("DEV-84920", "Samsung Galaxy A14 5G (IMEI: 864920194829104)", "Assigned to: Ramesh Kumar • Delhi North", "DEVICE", "ENFORCED", EmeraldGreen),
        SearchResultItem("DIST-1042", "Metro Mobiles Wholesale Ltd", "Owner: Rajesh Gupta • Chandigarh", "DISTRIBUTOR", "ACTIVE", NeonCyan),
        SearchResultItem("TXN-984210", "License Batch Purchase (5,000 Keys)", "Amount: $25,000 • HDFC Escrow", "TRANSACTION", "SUCCESS", EmeraldGreen),
        SearchResultItem("AUDIT-9921", "SIM Swap Fraud Trigger Auto-Lock", "Device: DEV-84920 • IP: 103.42.18.9", "SECURITY LOG", "CRITICAL", CrimsonRed)
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
                        text = "UNIVERSAL QUERY ENGINE",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonCyan,
                        letterSpacing = 1.5.sp
                    )
                    Text(
                        text = "Advanced Search",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }

            // Multi-Field Search Input
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text("Search by IMEI, Name, Transaction ID, Phone...", color = TextSecondary, fontSize = 12.sp) },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = NeonCyan) },
                            trailingIcon = {
                                if (searchQuery.isNotEmpty()) {
                                    IconButton(onClick = { searchQuery = "" }) {
                                        Icon(Icons.Default.Close, contentDescription = null, tint = TextSecondary)
                                    }
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = NeonCyan,
                                unfocusedBorderColor = ObsidianCardBorder,
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White
                            ),
                            shape = RoundedCornerShape(12.dp)
                        )

                        // Category Filter Pills
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            categories.forEach { cat ->
                                val isSelected = selectedCategory == cat
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { selectedCategory = cat },
                                    label = { Text(cat, fontSize = 10.sp, fontWeight = FontWeight.Bold) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = NeonCyan,
                                        selectedLabelColor = ObsidianBackground,
                                        containerColor = ObsidianBackground,
                                        labelColor = TextSecondary
                                    )
                                )
                            }
                        }

                        Button(
                            onClick = { hasSearched = true },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = NeonCyan, contentColor = ObsidianBackground),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(Icons.Default.ManageSearch, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("EXECUTE MULTI-TABLE QUERY", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // Results List
            item {
                Text("QUERY SEARCH RESULTS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
            }

            items(sampleResults) { res ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, res.statusColor.copy(alpha = 0.3f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(res.id, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold, color = NeonCyan)
                            Text(res.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text(res.subtitle, fontSize = 10.sp, color = TextSecondary)
                        }

                        Surface(color = res.statusColor.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                            Text(res.status, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = res.statusColor, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
                        }
                    }
                }
            }
        }
    }
}
