package ru.vafeen.test_actions.ui.components.ui_utils

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.vafeen.test_actions.R
import ru.vafeen.test_actions.ui.theme.FontSize

@Composable
fun WeekDay(context: Context, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextForThisTheme(
            text = context.getString(R.string.holiday),
            fontSize = FontSize.huge27,
            modifier = Modifier
        )
    }
}