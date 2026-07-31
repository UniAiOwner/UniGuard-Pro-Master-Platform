package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun KeyManagerScreen() {
    var forgeQuantity by remember { mutableStateOf("1000") }
    var selectedPartner by remember { mutableStateOf("Surya Telecom Master") }
    var dispatchQuantity by remember { mutableStateOf("500") }
    var partnerDropdownExpanded by remember { mutableStateOf(false) }

    val partners = listOf("Surya Telecom Master", "Vardhman Wholesale", "Apex Mobile Hub")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Text(
                    text = "LICENSE FORGE & DISPATCH",
                    color = NeonCyan,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            }

            // Key Stock Inventory Breakdown
            item {
                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(14.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("KEY STOCK INVENTORY", color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Column {
                                Text("Total Produced", color = TextSecondary, fontSize = 11.sp)
                                Text("50,000", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            }
                            Column {
                                Text("Admin Stock", color = TextSecondary, fontSize = 11.sp)
                                Text("15,000", color = EmeraldGreen, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            }
                            Column {
                                Text("Distributed", color = TextSecondary, fontSize = 11.sp)
                                Text("35,000", color = AmberWarning, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // Key Synthesis Forge
            item {
                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(14.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("KEY SYNTHESIS FORGE", color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        OutlinedTextField(
                            value = forgeQuantity,
                            onValueChange = { forgeQuantity = it },
                            label = { Text("Quantity (100 - 10000)") },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = NeonCyan,
                                unfocusedBorderColor = ObsidianBorder,
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp)
                        )
                        Button(
                            onClick = { /* INITIATE SYNTHESIS */ },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = NeonCyan)
                        ) {
                            Text("INITIATE SYNTHESIS", color = ObsidianBackground, fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }
            }

            // Vault Dispatcher
            item {
                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(14.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("VAULT DISPATCHER", color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        
                        ExposedDropdownMenuBox(
                            expanded = partnerDropdownExpanded,
                            onExpandedChange = { partnerDropdownExpanded = !partnerDropdownExpanded }
                        ) {
                            OutlinedTextField(
                                value = selectedPartner,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Select Partner") },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = partnerDropdownExpanded) },
                                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = NeonCyan,
                                    unfocusedBorderColor = ObsidianBorder,
                                    focusedTextColor = Color.White,
                                    unfocusedTextColor = Color.White
                                ),
                                modifier = Modifier.menuAnchor().fillMaxWidth(),
                                shape = RoundedCornerShape(10.dp)
                            )
                            ExposedDropdownMenu(
                                expanded = partnerDropdownExpanded,
                                onDismissRequest = { partnerDropdownExpanded = false },
                                modifier = Modifier.background(ObsidianCard)
                            ) {
                                partners.forEach { selectionOption ->
                                    DropdownMenuItem(
                                        text = { Text(selectionOption, color = Color.White) },
                                        onClick = {
                                            selectedPartner = selectionOption
                                            partnerDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }

                        OutlinedTextField(
                            value = dispatchQuantity,
                            onValueChange = { dispatchQuantity = it },
                            label = { Text("Quantity") },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = NeonCyan,
                                unfocusedBorderColor = ObsidianBorder,
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp)
                        )
                        
                        Button(
                            onClick = { /* START DISPATCH */ },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = EmeraldGreen)
                        ) {
                            Text("START DISPATCH", color = ObsidianBackground, fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }
            }
        }
    }
}
