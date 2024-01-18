package com.client.ui.components

import androidx.compose.ui.graphics.Color

data class Step(
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val selectedStepColor: Color,
    val unSelectedStepColor: Color,
    val number: Int
)
