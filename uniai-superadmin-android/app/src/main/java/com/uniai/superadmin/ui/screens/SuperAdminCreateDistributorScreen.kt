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
fun SuperAdminCreateDistributorScreen() {
    var companyName by remember { mutableStateOf("") }
    var contactPerson by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var territory by remember { mutableStateOf("Delhi NCR Region") }
    var keyQuota by remember { mutableStateOf("5000") }
    var isSubmitted by remember { mutableStateOf(false) }

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
                        text = "ONBOARDING FORM WIZARD",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = NeonCyan,
                        letterSpacing = 1.5.sp
                    )
                    Text(
                        text = "Create Distributor",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White
                    )
                }
            }

            // Form Inputs
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text("1. DISTRIBUTOR ENTITY DETAILS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)

                        OutlinedTextField(
                            value = companyName,
                            onValueChange = { companyName = it },
                            label = { Text("Company Legal Name", color = TextSecondary) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = NeonCyan, unfocusedBorderColor = ObsidianCardBorder, focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                        )

                        OutlinedTextField(
                            value = contactPerson,
                            onValueChange = { contactPerson = it },
                            label = { Text("Contact Person Name", color = TextSecondary) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = NeonCyan, unfocusedBorderColor = ObsidianCardBorder, focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                        )

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email Address", color = TextSecondary) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = NeonCyan, unfocusedBorderColor = ObsidianCardBorder, focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                        )

                        OutlinedTextField(
                            value = phone,
                            onValueChange = { phone = it },
                            label = { Text("Mobile Phone Number", color = TextSecondary) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = NeonCyan, unfocusedBorderColor = ObsidianCardBorder, focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                        )

                        OutlinedTextField(
                            value = territory,
                            onValueChange = { territory = it },
                            label = { Text("Assigned Territory Zone", color = TextSecondary) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = NeonCyan, unfocusedBorderColor = ObsidianCardBorder, focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                        )

                        OutlinedTextField(
                            value = keyQuota,
                            onValueChange = { keyQuota = it },
                            label = { Text("Initial License Key Quota Allocation", color = TextSecondary) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = NeonCyan, unfocusedBorderColor = ObsidianCardBorder, focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                        )
                    }
                }
            }

            // Submit Button
            item {
                Button(
                    onClick = { isSubmitted = true },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = EmeraldGreen),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Icon(Icons.Default.AddBusiness, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("ONBOARD MASTER DISTRIBUTOR", fontSize = 13.sp, fontWeight = FontWeight.Black)
                }
            }

            if (isSubmitted) {
                item {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = EmeraldGreen.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(12.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen)
                    ) {
                        Text(
                            text = "✓ Master Distributor onboarding payload processed! Credentials dispatched to partner email.",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = EmeraldGreen,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }
    }
}
