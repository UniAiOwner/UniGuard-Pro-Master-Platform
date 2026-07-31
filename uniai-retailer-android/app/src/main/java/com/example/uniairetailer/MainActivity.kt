package com.example.uniairetailer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.uniairetailer.ui.theme.UniAiRetailerTheme
import com.example.uniairetailer.ui.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) } // Default to false or system

            UniAiRetailerTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(
                        isDarkTheme = isDarkTheme,
                        onThemeChange = { isDarkTheme = it }
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavigation(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    var currentScreen by remember { mutableStateOf("auth") }

    when (currentScreen) {
        "auth" -> StaffAuthGatewayScreen(onAuthSuccess = { currentScreen = "home" })
        "home" -> RetailerHomeScreen(onNavigate = { currentScreen = it })
        "directory" -> CustomerDirectoryScreen(onBack = { currentScreen = "home" })
        "onboarding" -> DeviceOnboardingScreen(onBack = { currentScreen = "home" })
        "licenses" -> LicenseWalletScreen(onBack = { currentScreen = "home" })
        "settings" -> ShopSettingsScreen(
            isDarkTheme = isDarkTheme,
            onThemeChange = onThemeChange,
            onBack = { currentScreen = "home" }
        )
    }
}
