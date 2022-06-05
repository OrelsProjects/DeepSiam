package com.orels.deepsiam.presentation.mainscreen_admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.orels.deepsiam.R
import com.orels.deepsiam.data.remote.APIExceptions
import com.orels.deepsiam.presentation.mainscreen_admin.components.SnackbarScreen
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Destination(start = true)
fun MainScreenAdmin(
    viewModel: MainScreenAdminViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val keyboardController = LocalSoftwareKeyboardController.current
    if (state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(1f)
                .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f))
                .zIndex(2f),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimaryContainer)
        }
    }
    Box(
        modifier = Modifier
            .zIndex(2f)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        if (state.error != null) {
            when (state.error) {
                APIExceptions.EmptyBodyOrTitle -> {
                    SnackbarScreen(
                        message = stringResource(R.string.error_message_empty_body_title),
                        duration = SnackbarDuration.Long,
                        withDismissAction = true,
                        actionLabel = stringResource(R.string.message_taking_care_of_it)
                    )
                }
                else -> {
                    SnackbarScreen(
                        message = stringResource(R.string.error_unknown),
                        duration = SnackbarDuration.Long,
                        withDismissAction = true,
                        actionLabel = stringResource(R.string.retry)
                    )
                }
            }
        } else if (state.isNotificationSent) {
            SnackbarScreen(
                message = stringResource(R.string.notification_sent_successfully),
                duration = SnackbarDuration.Short,
                withDismissAction = true,
                actionLabel = stringResource(id = R.string.thank_you)
            )
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .zIndex(1f)
    ) {
        Text(
            text = stringResource(R.string.notification_board_title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Text(
            text = stringResource(R.string.notification_board_explanation),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
        )
        OutlinedTextField(
            value = state.title,
            maxLines = 2,
            onValueChange = { viewModel.setTitle(it) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(R.string.notification_title))
            },
        )
        OutlinedTextField(
            value = state.body,
            maxLines = 10,
            onValueChange = { viewModel.setBody(it) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(R.string.notification_content))
            },
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier
                    .clickable {
                        viewModel.setTitle("")
                        viewModel.setBody("")
                    },
                text = stringResource(R.string.clear),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.error
            )
        }
        Button(
            onClick = {
                viewModel.sendNotification()
                keyboardController?.hide()
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        ) {
            Text(stringResource(R.string.send_notification))
        }
    }
}

@Preview
@Composable
fun MainScreenAdmin_Preview() {
    MainScreenAdmin()
}