package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Distributor(val id: String, val name: String, val region: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DistributorManagementScreen() {
    var distributors by remember { 
        mutableStateOf(listOf(
            Distributor("1", "Alpha Dist", "North America"),
            Distributor("2", "Beta Dist", "Europe")
        )) 
    }
    var showAddDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Distributor Management") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddDialog = true }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            items(distributors) { dist ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Name: ${dist.name}", style = MaterialTheme.typography.titleMedium)
                        Text(text = "Region: ${dist.region}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }

    if (showAddDialog) {
        AddDistributorDialog(
            onDismiss = { showAddDialog = false },
            onAdd = { name, region ->
                distributors = distributors + Distributor(
                    id = (distributors.size + 1).toString(),
                    name = name,
                    region = region
                )
                showAddDialog = false
            }
        )
    }
}
