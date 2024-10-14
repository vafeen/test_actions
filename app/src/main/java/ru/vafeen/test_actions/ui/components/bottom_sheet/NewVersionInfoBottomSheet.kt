package ru.vafeen.test_actions.ui.components.bottom_sheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import ru.vafeen.test_actions.ui.theme.updateAvailableColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewVersionInfoBottomSheet(onDismissRequest: () -> Unit) {
    val state =
        rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        sheetState = state,
        onDismissRequest = onDismissRequest,
        containerColor = updateAvailableColor,
    ) {
    }
}