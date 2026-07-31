package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LicenseMintingKernelScreen() {
    var selectedQuantity by remember { mutableIntStateOf(50000) }
    var selectedDistributor by remember { mutableStateOf("Surya Telecom Master (UP West)") }
    var selectedExpiry by remember { mutableStateOf("365 Days (1 Year)") }
    var totpInput by remember { mutableStateOf("884912") }

    var showDistributorMenu by remember { mutableStateOf(false) }
    var showExpiryMenu by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    val presetQuantities = listOf(1000, 10000, 50000, 100000)

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
                        text = "CRYPTOGRAPHIC LICENSE MINTING KERNEL",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = SolarAmber,
                        letterSpacing = 2.sp
                    )
                    Text(
                        text = "HMAC-SHA256 FIPS 140-3 Key Forge",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            // Minting Forge Panel (Matching superadmin_license_minting.jpg)
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(20.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(
                            text = "BATCH QUANTITY SELECTION",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextSecondary,
                            letterSpacing = 1.sp
                        )

                        // Preset Quantity Chips
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            presetQuantities.forEach { qty ->
                                val isSelected = selectedQuantity == qty
                                Surface(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable { selectedQuantity = qty },
                                    color = if (isSelected) SolarAmber.copy(alpha = 0.2f) else ObsidianSurface,
                                    shape = RoundedCornerShape(12.dp),
                                    border = androidx.compose.foundation.BorderStroke(
                                        1.dp,
                                        if (isSelected) SolarAmber else Color.White.copy(alpha = 0.05f)
                                    )
                                ) {
                                    Text(
                                        text = "${qty / 1000}k Keys",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isSelected) SolarAmber else Color.White,
                                        modifier = Modifier.padding(vertical = 10.dp),
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                    )
                                }
                            }
                        }

                        // Stepper Display Box
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(ObsidianSurface, RoundedCornerShape(14.dp))
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(
                                onClick = { if (selectedQuantity > 1000) selectedQuantity -= 1000 },
                                modifier = Modifier
                                    .size(36.dp)
                                    .border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape)
                            ) {
                                Icon(Icons.Default.Remove, contentDescription = null, tint = SolarAmber)
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "$selectedQuantity",
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color.White
                                )
                                Text("KEYS IN BATCH", fontSize = 9.sp, color = SolarAmber, fontWeight = FontWeight.ExtraBold)
                            }
                            IconButton(
                                onClick = { selectedQuantity += 1000 },
                                modifier = Modifier
                                    .size(36.dp)
                                    .border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape)
                            ) {
                                Icon(Icons.Default.Add, contentDescription = null, tint = SolarAmber)
                            }
                        }

                        // Target Master Distributor Selector Dropdown
                        Column {
                            Text("TARGET DISTRIBUTOR CREDIT LINE", fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(4.dp))
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { showDistributorMenu = true },
                                color = ObsidianSurface,
                                shape = RoundedCornerShape(12.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.3f))
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(selectedDistributor, fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
                                    Icon(Icons.Default.ArrowDropDown, contentDescription = null, tint = NeonCyan)
                                }
                            }
                        }

                        // Key Expiry Selector
                        Column {
                            Text("LICENSE DURATION & EXPIRY", fontSize = 10.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(4.dp))
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { showExpiryMenu = true },
                                color = ObsidianSurface,
                                shape = RoundedCornerShape(12.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.3f))
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(selectedExpiry, fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
                                    Icon(Icons.Default.ArrowDropDown, contentDescription = null, tint = EmeraldGreen)
                                }
                            }
                        }

                        // Hardware TOTP Verification Code Field
                        OutlinedTextField(
                            value = totpInput,
                            onValueChange = { if (it.length <= 6) totpInput = it },
                            label = { Text("6-Digit Hardware TOTP 2FA Code", color = TextSecondary) },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = SolarAmber,
                                unfocusedBorderColor = Color.White.copy(alpha = 0.1f),
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        )

                        // MINT BATCH BUTTON
                        Button(
                            onClick = { showSuccessDialog = true },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp),
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = SolarAmber, contentColor = ObsidianBackground)
                        ) {
                            Icon(Icons.Default.Bolt, contentDescription = null, modifier = Modifier.size(22.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("🔑 MINT BATCH (HMAC-SHA256 FIPS 140-3)", fontSize = 13.sp, fontWeight = FontWeight.Black)
                        }
                    }
                }
            }

            // Minted Batch History Stream
            item {
                Text("RECENT MINTED BATCH HISTORY", fontSize = 10.sp, fontWeight = FontWeight.ExtraBold, color = TextSecondary, letterSpacing = 1.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.05f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        MintHistoryRow("BATCH-8849-50K", "50,000 Keys", "Surya Telecom Master", "2 mins ago")
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        MintHistoryRow("BATCH-7102-10K", "10,000 Keys", "Vardhman Mobiles", "1 hour ago")
                    }
                }
            }
        }

        // Success Dialog
        if (showSuccessDialog) {
            AlertDialog(
                onDismissRequest = { showSuccessDialog = false },
                containerColor = ObsidianCard,
                title = { Text("BATCH SYNTHESIS COMPLETE", color = SolarAmber, fontWeight = FontWeight.Black, fontSize = 14.sp) },
                text = { Text("Successfully minted $selectedQuantity HMAC keys assigned to $selectedDistributor in < 1.2 seconds.", color = Color.White, fontSize = 12.sp) },
                confirmButton = {
                    Button(
                        onClick = { showSuccessDialog = false },
                        colors = ButtonDefaults.buttonColors(containerColor = SolarAmber)
                    ) {
                        Text("DONE", color = ObsidianBackground, fontWeight = FontWeight.ExtraBold)
                    }
                }
            )
        }
    }
}

@Composable
fun MintHistoryRow(
    batchId: String,
    quantity: String,
    distributor: String,
    time: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(batchId, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("$distributor • $time", fontSize = 10.sp, color = TextSecondary)
        }
        Surface(
            color = SolarAmber.copy(alpha = 0.15f),
            shape = RoundedCornerShape(10.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, SolarAmber.copy(alpha = 0.4f))
        ) {
            Text(quantity, fontSize = 11.sp, fontWeight = FontWeight.ExtraBold, color = SolarAmber, modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp))
        }
    }
}
