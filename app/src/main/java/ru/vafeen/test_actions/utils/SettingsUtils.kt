package ru.vafeen.test_actions.utils

import android.content.SharedPreferences
import androidx.compose.ui.graphics.Color
import ru.vafeen.test_actions.noui.shared_preferences.SharedPreferencesValue
import ru.vafeen.test_actions.noui.shared_preferences.saveInOrRemoveFromSharedPreferences
import ru.vafeen.test_actions.ui.components.Settings

fun SharedPreferences.save(
    settings: Settings,
) = saveInOrRemoveFromSharedPreferences {
    putString(SharedPreferencesValue.Settings.key, settings.toJsonString())
}


fun Settings.getMainColorForThisTheme(isDark: Boolean): Color? =
    if (isDark) darkThemeColor else lightThemeColor