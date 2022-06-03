package com.orels.deepsiam.presentation.mainscreen_user

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun MainScreenUser(
    navigator: DestinationsNavigator,
    viewModel: MainScreenUserViewModel
) {
    Text(text = "I am main screen user")
}