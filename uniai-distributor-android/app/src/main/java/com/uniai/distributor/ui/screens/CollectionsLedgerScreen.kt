package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollectionsLedgerScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Collections Ledger") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    ListItem(
                        headlineContent = { Text("Transaction #${1000 + index}") },
                        supportingContent = { Text("Amount: \$${150 + index * 10} - Status: Completed") },
                        leadingContent = {
                            Icon(Icons.Default.CheckCircle, contentDescription = null)
                        }
                    )
                }
            }
        }
    }
}
