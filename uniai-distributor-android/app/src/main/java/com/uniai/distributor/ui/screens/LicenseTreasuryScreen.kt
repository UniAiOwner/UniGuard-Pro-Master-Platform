package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LicenseTreasuryScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("License Treasury (SuperAdmin)", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Bulk Key Ordering")
        }
    }
}
