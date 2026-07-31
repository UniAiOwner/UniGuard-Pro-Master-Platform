package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RetailerDetailDocketScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Retailer Shop Docket", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: Suspend Kill-Switch */ },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
        ) {
            Text("Suspend Retailer (Kill-Switch)")
        }
    }
}
