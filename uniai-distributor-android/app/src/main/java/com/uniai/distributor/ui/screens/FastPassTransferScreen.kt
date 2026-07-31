package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FastPassTransferScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("FastPass Transfer", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth().height(300.dp),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Text("[ 5s QR Scan Viewfinder ]")
        }
    }
}
