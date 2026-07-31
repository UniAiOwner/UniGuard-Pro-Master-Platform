package com.uniai.distributor.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PricingTierConfiguratorScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Pricing Tier Configurator", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Configure pricing rules for network here.")
    }
}
