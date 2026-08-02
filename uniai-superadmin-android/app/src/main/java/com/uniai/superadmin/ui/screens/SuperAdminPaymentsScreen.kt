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

data class PaymentTx(
    val txId: String,
    val customerName: String,
    val method: String,
    val amount: String,
    val timestamp: String,
    val status: String,
    val statusColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminPaymentsScreen() {
    val sampleTxs = listOf(
        PaymentTx("TXN-984102", "Ravi Kumar", "UPI (Razorpay)", "₹ 2,450", "10 mins ago", "SUCCESS", EmeraldGreen),
        PaymentTx("TXN-984101", "Priya Sharma", "Cash (POS)", "₹ 2,450", "45 mins ago", "SUCCESS", EmeraldGreen),
        PaymentTx("TXN-984100", "Amit Verma", "Debit Card", "₹ 2,450", "2 hours ago", "FAILED", CrimsonRed),
        PaymentTx("TXN-984099", "Suresh Gupta", "UPI AutoPay", "₹ 2,450", "3 hours ago", "SUCCESS", EmeraldGreen)
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
                            text = "FINANCIAL LEDGER & COLLECTIONS",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Payment & Collections",
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
                            text = "₹ 12.45L TODAY",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldGreen,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            // Financial Summary Cards
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    PaySummaryBox(modifier = Modifier.weight(1f), title = "Today Collections", amount = "₹ 12.45L", color = EmeraldGreen)
                    PaySummaryBox(modifier = Modifier.weight(1f), title = "Monthly MTD", amount = "₹ 48.75L", color = NeonCyan)
                    PaySummaryBox(modifier = Modifier.weight(1f), title = "Total Overdue", amount = "₹ 22.10L", color = CrimsonRed)
                }
            }

            // Payment Stream
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("REAL-TIME TRANSACTION STREAM", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))

                        sampleTxs.forEach { tx ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(tx.statusColor.copy(alpha = 0.15f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(Icons.Default.MonetizationOn, contentDescription = null, tint = tx.statusColor, modifier = Modifier.size(18.dp))
                                    }
                                    Column {
                                        Text(tx.customerName, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        Text("${tx.txId} • ${tx.method}", fontSize = 10.sp, color = TextSecondary)
                                    }
                                }

                                Column(horizontalAlignment = Alignment.End) {
                                    Text(tx.amount, fontSize = 13.sp, fontWeight = FontWeight.Black, color = Color.White)
                                    Text(tx.timestamp, fontSize = 10.sp, color = TextSecondary)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PaySummaryBox(
    modifier: Modifier = Modifier,
    title: String,
    amount: String,
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
            Text(amount, fontSize = 14.sp, fontWeight = FontWeight.Black, color = color)
            Text(title, fontSize = 9.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
        }
    }
}
