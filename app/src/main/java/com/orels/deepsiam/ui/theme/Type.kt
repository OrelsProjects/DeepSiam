package com.orels.deepsiam.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.orels.deepsiam.R

val fontsVarelaround = FontFamily(
    Font(R.font.varelaround)
)

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = fontsVarelaround,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    titleSmall = TextStyle(
        fontFamily = fontsVarelaround,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp
    )
)