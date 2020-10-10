package com.angkorteam.uicompose.master.style

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.ResourceFont
import com.angkorteam.uicompose.master.R

val FontFamily.Companion.RobotoBlack: ResourceFont
    get() {
        return ResourceFont(
            resId = R.font.roboto_black,
            weight = FontWeight.W900,
            style = FontStyle.Normal
        )
    }

