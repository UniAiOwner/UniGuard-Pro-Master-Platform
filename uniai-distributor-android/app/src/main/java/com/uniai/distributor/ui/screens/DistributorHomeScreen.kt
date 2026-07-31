package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DistributorHomeScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Card(
            modifier = Modifier.fillMaxWidth().height(120.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("Treasury Hero Card", style = MaterialTheme.typography.titleLarge)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Bento Grid Actions", style = MaterialTheme.typography.titleMedium)
        // Add Grid implementation
    }
}
