package com.orels.deepsiam.presentation.mainscreen_admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.orels.deepsiam.R
import com.orels.deepsiam.util.ui.DefaultDestinationNavigator
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun MainScreenAdmin(
    navigator: DestinationsNavigator,
    viewModel: MainScreenAdminViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(R.string.notification_board_title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            textAlign = TextAlign.Right
        )
        Text(
            text = stringResource(R.string.notification_board_explanation),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha=0.7f),
            textAlign = TextAlign.Right
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
        Button(
            onClick = { viewModel.sendNotification() },
            modifier = Modifier
//                .align()
        ) {
            Text(stringResource(R.string.send_notification))
        }
    }
}

@Preview
@Composable
fun MainScreenAdmin_Preview() {
    MainScreenAdmin(DefaultDestinationNavigator())
}