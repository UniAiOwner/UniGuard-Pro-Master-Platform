package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminSettingsScreen() {
    var webhooksEnabled by remember { mutableStateOf(true) }
    var rbacLevel by remember { mutableStateOf("Full Access") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Super Admin Settings") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Webhooks", style = MaterialTheme.typography.titleMedium)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Enable Webhooks")
                Switch(checked = webhooksEnabled, onCheckedChange = { webhooksEnabled = it })
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text("Sub-Admin RBAC", style = MaterialTheme.typography.titleMedium)
            OutlinedTextField(
                value = rbacLevel,
                onValueChange = { rbacLevel = it },
                label = { Text("Current Role Level") },
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(onClick = { /* Save Settings */ }) {
                Text("Save Settings")
            }
        }
    }
}
