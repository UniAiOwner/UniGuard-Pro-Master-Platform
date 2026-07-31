package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RetailerPerformanceScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Retailer Performance") },
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
            items(8) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    ListItem(
                        headlineContent = { Text("Retailer ${'A' + index}") },
                        supportingContent = { Text("Sales: ${1000 + index * 50} units | Rating: 4.${index % 9}") },
                        leadingContent = {
                            Icon(Icons.Default.Star, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        }
                    )
                }
            }
        }
    }
}
