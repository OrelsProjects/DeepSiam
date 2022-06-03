package com.orels.deepsiam.presentation.mainscreen_admin

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun MainScreenAdmin(
    navigator: DestinationsNavigator,
    viewModel: MainScreenAdminViewModel
) {
    Text(text = "I am main screen admin")
}