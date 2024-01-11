package com.client.designSystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.client.designSystem.theme.colors.EmployColors

@Composable
fun EmployM3Theme(
    dark: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (dark) employDarkColorScheme() else employLightColorScheme(),
        content = content
    )
}

private fun employLightColorScheme(): ColorScheme = ColorScheme(
    primary = EmployColors.Blue.primary,
    onPrimary = EmployColors.White,
    primaryContainer = EmployColors.Blue.light,
    onPrimaryContainer = EmployColors.White,
    inversePrimary = EmployColors.Blue.dark,
    secondary = EmployColors.Green.primary,
    onSecondary = EmployColors.White,
    secondaryContainer = EmployColors.Green.light,
    onSecondaryContainer = EmployColors.White,
    tertiary = EmployColors.Green.primary,
    onTertiary = EmployColors.White,
    tertiaryContainer = EmployColors.Green.light,
    onTertiaryContainer = EmployColors.White,

    error = EmployColors.Red.primary,
    onError = EmployColors.White,
    errorContainer = EmployColors.Red.light,
    onErrorContainer = EmployColors.White,

    background = EmployColors.White,
    onBackground = EmployColors.Black,
    surface = EmployColors.White,
    onSurface = EmployColors.Black,
    surfaceVariant = EmployColors.ExtraLightGray,
    onSurfaceVariant = EmployColors.Black,
    surfaceTint = EmployColors.Black,
    inverseSurface = EmployColors.DarkGray,
    inverseOnSurface = EmployColors.White,

    outline = EmployColors.Gray,
    outlineVariant = EmployColors.DarkGray,
    scrim = EmployColors.ExtraDarkGray.copy(alpha = 0.8f)
)

private fun employDarkColorScheme(): ColorScheme = ColorScheme(
    primary = EmployColors.Blue.primary,
    onPrimary = EmployColors.White,
    primaryContainer = EmployColors.Blue.light,
    onPrimaryContainer = EmployColors.White,
    inversePrimary = EmployColors.Blue.dark,
    secondary = EmployColors.Green.primary,
    onSecondary = EmployColors.White,
    secondaryContainer = EmployColors.Green.light,
    onSecondaryContainer = EmployColors.White,
    tertiary = EmployColors.Green.primary,
    onTertiary = EmployColors.White,
    tertiaryContainer = EmployColors.Green.light,
    onTertiaryContainer = EmployColors.White,

    error = EmployColors.Red.primary,
    onError = EmployColors.White,
    errorContainer = EmployColors.Red.light,
    onErrorContainer = EmployColors.White,

    background = EmployColors.Black,
    onBackground = EmployColors.White,
    surface = EmployColors.Black,
    onSurface = EmployColors.White,
    surfaceVariant = EmployColors.ExtraDarkGray,
    onSurfaceVariant = EmployColors.White,
    surfaceTint = EmployColors.White,
    inverseSurface = EmployColors.LightGray,
    inverseOnSurface = EmployColors.Black,

    outline = EmployColors.Gray,
    outlineVariant = EmployColors.LightGray,
    scrim = EmployColors.ExtraLightGray.copy(alpha = 0.8f)
)
