package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RetailerNetworkScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Search Retailers") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Retailer Directory", style = MaterialTheme.typography.titleMedium)
    }
}
