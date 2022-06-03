package com.orels.deepsiam.presentation.mainscreen_user

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.orels.deepsiam.presentation.mainscreen_admin.MainScreenAdminViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun MainScreenUser(
    navigator: DestinationsNavigator,
    viewModel: MainScreenAdminViewModel
) {
    Text(text = "I am main screen user")
}