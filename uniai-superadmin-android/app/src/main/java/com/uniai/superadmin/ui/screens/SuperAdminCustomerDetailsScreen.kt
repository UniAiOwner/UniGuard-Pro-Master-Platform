package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminCustomerDetailsScreen(
    customerId: String = "UG1007"
) {
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
                            text = "CUSTOMER DOSSIER #$customerId",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Customer Details",
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
                            text = "KYC VERIFIED",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldGreen,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Customer Profile Header Card
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(54.dp)
                                .clip(CircleShape)
                                .background(NeonCyan.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("RK", fontSize = 20.sp, fontWeight = FontWeight.Black, color = NeonCyan)
                        }
                        Column {
                            Text("Ravi Kumar", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("Mobile: +91 98765 43210", fontSize = 12.sp, color = TextSecondary)
                            Text("Email: ravi.kumar@gmail.com", fontSize = 11.sp, color = TextSecondary)
                        }
                    }
                }
            }

            // Identity & KYC Block
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("IDENTITY & KYC DOSSIER", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        InfoRow(label = "Aadhaar / ID:", value = "XXXX-XXXX-4892")
                        InfoRow(label = "Permanent Address:", value = "Flat 402, Green Park, Delhi")
                        InfoRow(label = "Onboarding Date:", value = "12 Jan 2026")
                        InfoRow(label = "Merchant POS:", value = "Metro Mobiles (Noida)")
                    }
                }
            }

            // Finance Agreement Card
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("FINANCE AGREEMENT", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                            Surface(color = CrimsonRed.copy(alpha = 0.15f), shape = RoundedCornerShape(8.dp)) {
                                Text("OVERDUE ₹ 2,450", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = CrimsonRed, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                            }
                        }
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        InfoRow(label = "Total Loan Amount:", value = "₹ 45,000")
                        InfoRow(label = "Monthly EMI:", value = "₹ 2,450 / month")
                        InfoRow(label = "Tenure:", value = "12 Months (4 Paid)")
                        InfoRow(label = "Next Due Date:", value = "05 Aug 2026")
                    }
                }
            }

            // Linked Device Card
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("LINKED HANDSET HARDWARE", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = EmeraldGreen)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        InfoRow(label = "Model:", value = "Samsung Galaxy S23 5G")
                        InfoRow(label = "IMEI Number:", value = "864209041234567")
                        InfoRow(label = "DPC Status:", value = "ACTIVE / ENROLLED")
                        InfoRow(label = "Battery & SIM:", value = "84% • Jio 5G")
                    }
                }
            }

            // Quick Action Dock
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = EmeraldGreen),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.Phone, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Call", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                    Button(
                        onClick = { },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = NeonCyan, contentColor = ObsidianBackground),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.Send, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("WhatsApp", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 12.sp, color = TextSecondary)
        Text(value, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}
