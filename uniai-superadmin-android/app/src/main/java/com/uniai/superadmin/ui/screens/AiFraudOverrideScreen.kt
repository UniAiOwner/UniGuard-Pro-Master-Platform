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
fun AiFraudOverrideScreen() {
    var showSuspendConfirm by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header Title
            item {
                Column {
                    Text(
                        text = "AI FRAUD ENGINE & MASTER OVERRIDES",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = CrimsonRed,
                        letterSpacing = 2.sp
                    )
                    Text(
                        text = "Real-Time Threat Detection & Kill-Switches",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            // Threat Telemetry Hero Card (Matching superadmin_ai_fraud_overrides.jpg)
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(20.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CrimsonRed.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Icon(Icons.Default.Shield, contentDescription = null, tint = CrimsonRed, modifier = Modifier.size(24.dp))
                                Text("SYSTEM THREAT SCORE", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = CrimsonRed, letterSpacing = 1.sp)
                            }
                            Surface(
                                color = CrimsonRed.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(10.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, CrimsonRed.copy(alpha = 0.5f))
                            ) {
                                Text("HIGH ALERT", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = CrimsonRed, modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text("98.4%", fontSize = 42.sp, fontWeight = FontWeight.Black, color = Color.White)
                        Text("CRITICAL ANOMALY SHIELD ACTIVE • 14 FLAGGED HANDSETS", fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Suspicious Threat Stream Title
            item {
                Text("REAL-TIME SUSPICIOUS THREAT STREAM", fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = TextSecondary, letterSpacing = 1.sp)
            }

            // Threat Items
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    FraudThreatCard(
                        title = "⚠️ FRP Bypass Attempt Detected",
                        details = "IMEI 864209041234567 • Jaipur • Factory Reset Intercepted",
                        riskLevel = "CRITICAL",
                        riskColor = CrimsonRed,
                        onAction = { showSuspendConfirm = true }
                    )
                    FraudThreatCard(
                        title = "⚠️ Retailer Rate-Limit Spike",
                        details = "Gupta Mobiles • 50 IMEI Scans in 60 seconds (Possible Botnet)",
                        riskLevel = "HIGH",
                        riskColor = AmberWarning,
                        onAction = { showSuspendConfirm = true }
                    )
                    FraudThreatCard(
                        title = "⚠️ SIM Swap Removal Alert",
                        details = "IMEI 359124089912345 • Customer SIM removed without payment",
                        riskLevel = "MEDIUM",
                        riskColor = SolarAmber,
                        onAction = { showSuspendConfirm = true }
                    )
                }
            }
        }

        if (showSuspendConfirm) {
            AlertDialog(
                onDismissRequest = { showSuspendConfirm = false },
                containerColor = ObsidianCard,
                title = { Text("EXECUTE KILL-SWITCH OVERRIDE", color = CrimsonRed, fontWeight = FontWeight.Black, fontSize = 14.sp) },
                text = { Text("Issue remote hard-lock command and suspend retailer account immediately?", color = Color.White, fontSize = 12.sp) },
                confirmButton = {
                    Button(
                        onClick = { showSuspendConfirm = false },
                        colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed)
                    ) {
                        Text("EXECUTE SUSPEND", color = Color.White, fontWeight = FontWeight.ExtraBold)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showSuspendConfirm = false }) {
                        Text("Cancel", color = TextSecondary)
                    }
                }
            )
        }
    }
}

@Composable
fun FraudThreatCard(
    title: String,
    details: String,
    riskLevel: String,
    riskColor: Color,
    onAction: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = ObsidianCard,
        shape = RoundedCornerShape(16.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, riskColor.copy(alpha = 0.3f))
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Surface(
                    color = riskColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, riskColor.copy(alpha = 0.4f))
                ) {
                    Text(riskLevel, fontSize = 9.sp, fontWeight = FontWeight.ExtraBold, color = riskColor, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                }
            }
            Text(details, fontSize = 11.sp, color = TextSecondary)

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(
                    onClick = onAction,
                    modifier = Modifier.weight(1f).height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed.copy(alpha = 0.2f)),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CrimsonRed.copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("⛔ SUSPEND RETAILER", color = CrimsonRed, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
                }
                Button(
                    onClick = onAction,
                    modifier = Modifier.weight(1f).height(40.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = ObsidianSurface),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.1f)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("🔒 HARD LOCK", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
