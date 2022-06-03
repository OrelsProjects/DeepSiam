package com.orels.deepsiam.ui.theme

import com.orels.deepsiam.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val fontsVarelaround = FontFamily(
    Font(R.font.varelaround)
)

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = fontsVarelaround,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    titleSmall = TextStyle(
        fontFamily = fontsVarelaround,
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp
    )
)