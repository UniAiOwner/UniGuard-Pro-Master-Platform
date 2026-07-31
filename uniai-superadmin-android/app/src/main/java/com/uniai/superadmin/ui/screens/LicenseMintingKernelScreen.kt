package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

@Composable
fun LicenseMintingKernelScreen() {
    var keyCount by remember { mutableFloatStateOf(1000f) }
    var isMinting by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp)
    ) {
        Text(
            text = "HMAC KEY MINTING KERNEL",
            color = NeonCyan,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp
        )
        Text(
            text = "Cryptographic Batch License Key Generator",
            color = TextSecondary,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 2.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Secret Key Status Card
        Surface(
            color = ObsidianCard,
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "CRYPTOGRAPHIC SIGNATURE ENGINE", color = TextSecondary, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Algorithm", color = TextPrimary, fontSize = 14.sp)
                    Text(text = "HmacSHA256 (FIPS 140-3)", color = EmeraldGreen, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Master Secret Key", color = TextPrimary, fontSize = 14.sp)
                    Text(text = "e3b0c44298fc1c149afbf4c8996...", color = TextSecondary, fontSize = 12.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Quantity Selector Slider Card
        Surface(
            color = ObsidianCard,
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "BATCH QUANTITY SELECTOR", color = TextSecondary, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "${keyCount.toInt()} Keys",
                    color = NeonCyan,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Slider(
                    value = keyCount,
                    onValueChange = { keyCount = it },
                    valueRange = 100f..10000f,
                    steps = 9,
                    colors = SliderDefaults.colors(
                        thumbColor = NeonCyan,
                        activeTrackColor = NeonCyan,
                        inactiveTrackColor = ObsidianBorder
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "100", color = TextSecondary, fontSize = 11.sp)
                    Text(text = "5,000", color = TextSecondary, fontSize = 11.sp)
                    Text(text = "10,000", color = TextSecondary, fontSize = 11.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (isMinting) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth().height(6.dp),
                color = NeonCyan,
                trackColor = ObsidianBorder
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Minting ${keyCount.toInt()} cryptographic keys...",
                color = TextSecondary,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                isMinting = true
                showSuccessDialog = true
            },
            modifier = Modifier.fillMaxWidth().height(52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = NeonCyan),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "⚡ EXECUTE HMAC MINT KERNEL",
                color = ObsidianBackground,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        if (showSuccessDialog) {
            AlertDialog(
                onDismissRequest = {
                    showSuccessDialog = false
                    isMinting = false
                },
                containerColor = ObsidianCard,
                title = {
                    Text("🔑 Keys Minted Successfully", color = EmeraldGreen, fontWeight = FontWeight.Bold)
                },
                text = {
                    Column {
                        Text(
                            "Generated ${keyCount.toInt()} HMAC-SHA256 signature keys into PostgreSQL Master Registry.",
                            color = TextPrimary,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Master Batch Hash:",
                            color = TextSecondary,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "2e3ad9c4969f800418c40fcb56375394f5...",
                            color = NeonCyan,
                            fontSize = 11.sp
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showSuccessDialog = false
                            isMinting = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = EmeraldGreen)
                    ) {
                        Text("DONE", color = ObsidianBackground, fontWeight = FontWeight.Bold)
                    }
                }
            )
        }
    }
}
