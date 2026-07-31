package com.uniai.superadmin.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = NeonCyan,
    secondary = EmeraldGreen,
    tertiary = RoyalPurple,
    background = ObsidianBackground,
    surface = ObsidianSurface,
    onPrimary = ObsidianBackground,
    onSecondary = ObsidianBackground,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    error = CrimsonRed
)

@Composable
fun SuperAdminTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
