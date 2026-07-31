package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SystemHealthScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("System Health") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            MetricCard(title = "Database Load", value = "42%", status = "Healthy")
            Spacer(modifier = Modifier.height(8.dp))
            MetricCard(title = "Redis Cache Hit Rate", value = "94%", status = "Optimal")
            Spacer(modifier = Modifier.height(8.dp))
            MetricCard(title = "FCM Delivery Latency", value = "120ms", status = "Normal")
        }
    }
}

@Composable
fun MetricCard(title: String, value: String, status: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Value: $value", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Status: $status", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
