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
fun DeviceControlScreen() {
    var imeiQuery by remember { mutableStateOf("") }
    var globalLock by remember { mutableStateOf(false) }
    var cameraBlock by remember { mutableStateOf(false) }
    var usbBlock by remember { mutableStateOf(false) }
    var frpLock by remember { mutableStateOf(false) }
    var recoveryCodeVisible by remember { mutableStateOf(false) }
    var showTotpDialog by remember { mutableStateOf(false) }
    var pendingAction by remember { mutableStateOf("") }

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
                    text = "DEVICE CONTROL CENTER",
                    color = NeonCyan,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            }

            // IMEI Search
            item {
                OutlinedTextField(
                    value = imeiQuery,
                    onValueChange = { imeiQuery = it },
                    label = { Text("Enter Device IMEI") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonCyan,
                        unfocusedBorderColor = ObsidianBorder,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                )
            }

            // Identity Card
            item {
                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(14.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("DEVICE IDENTITY", color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Owner:", color = TextSecondary, fontSize = 14.sp)
                            Text("Ramesh Kumar", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Retailer:", color = TextSecondary, fontSize = 14.sp)
                            Text("Apex Mobile Hub", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Model:", color = TextSecondary, fontSize = 14.sp)
                            Text("Samsung Galaxy M34", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text("Last Sync:", color = TextSecondary, fontSize = 14.sp)
                            Text("2 mins ago", color = EmeraldGreen, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // Toggles
            item {
                Surface(
                    color = ObsidianCard,
                    shape = RoundedCornerShape(14.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianBorder),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("POLICY CONTROLS", color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Text("Global Lock", color = Color.White)
                            Switch(checked = globalLock, onCheckedChange = { globalLock = it })
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Text("Camera Block", color = Color.White)
                            Switch(checked = cameraBlock, onCheckedChange = { cameraBlock = it })
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Text("USB Debugging Block", color = Color.White)
                            Switch(checked = usbBlock, onCheckedChange = { usbBlock = it })
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Text("Factory Reset / FRP Lock", color = Color.White)
                            Switch(checked = frpLock, onCheckedChange = { frpLock = it })
                        }
                    }
                }
            }

            // Recovery & Actions
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Button(
                        onClick = { recoveryCodeVisible = !recoveryCodeVisible },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = NeonCyan)
                    ) {
                        Text(if (recoveryCodeVisible) "PIN: 847291" else "Generate Recovery Code", color = ObsidianBackground)
                    }

                    Button(
                        onClick = { 
                            pendingAction = "Send Alert"
                            showTotpDialog = true 
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = AmberWarning)
                    ) {
                        Text("Send Alert", color = ObsidianBackground)
                    }

                    Button(
                        onClick = { 
                            pendingAction = "Remote Wipe Data"
                            showTotpDialog = true 
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed)
                    ) {
                        Text("Remote Wipe Data", color = Color.White)
                    }
                }
            }
        }

        if (showTotpDialog) {
            TotpDialog(
                action = pendingAction,
                onDismiss = { showTotpDialog = false },
                onConfirm = { code, reason ->
                    // Perform action
                    showTotpDialog = false
                }
            )
        }
    }
}

@Composable
fun TotpDialog(action: String, onDismiss: () -> Unit, onConfirm: (String, String) -> Unit) {
    var totpCode by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = ObsidianCard,
        titleContentColor = Color.White,
        textContentColor = Color.White,
        title = { Text("MFA Required for $action") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedTextField(
                    value = totpCode,
                    onValueChange = { totpCode = it },
                    label = { Text("Enter TOTP Code") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonCyan,
                        unfocusedBorderColor = ObsidianBorder,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                )
                OutlinedTextField(
                    value = reason,
                    onValueChange = { reason = it },
                    label = { Text("Reason for Action") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonCyan,
                        unfocusedBorderColor = ObsidianBorder,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                )
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(totpCode, reason) }, colors = ButtonDefaults.buttonColors(containerColor = NeonCyan)) {
                Text("Confirm", color = ObsidianBackground)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = TextSecondary)
            }
        }
    )
}
