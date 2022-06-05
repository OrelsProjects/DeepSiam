package com.orels.deepsiam.presentation.mainscreen_admin.components

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SnackbarScreen(
    message: String = "",
    duration: SnackbarDuration = SnackbarDuration.Short,
    withDismissAction: Boolean = false,
    actionLabel: String = "",
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(snackbarHostState) {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = message,
                duration = duration,
                withDismissAction = withDismissAction,
                actionLabel = actionLabel
            )
        }
    }
    SnackbarHost(hostState = snackbarHostState)
}