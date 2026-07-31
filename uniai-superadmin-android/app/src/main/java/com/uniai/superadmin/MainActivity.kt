package com.uniai.superadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.uniai.superadmin.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    Column {
                        SuperAdminAuthGatewayScreen()
                        SuperAdminDashboardScreen()
                        TenantRegistryScreen()
                        LicenseMintingKernelScreen()
                        AiFraudOverrideScreen()
                        RevenueAnalyticsScreen()
                        AuditVaultScreen()
                    }
                }
            }
        }
    }
}
