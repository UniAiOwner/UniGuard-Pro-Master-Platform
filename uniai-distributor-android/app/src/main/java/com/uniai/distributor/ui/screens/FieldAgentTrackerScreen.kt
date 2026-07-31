package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FieldAgentTrackerScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Field Agent Tracker", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth().height(300.dp)) {
            Text("[ GPS Visit Tracker Map ]", modifier = Modifier.align(androidx.compose.ui.Alignment.Center))
        }
    }
}
