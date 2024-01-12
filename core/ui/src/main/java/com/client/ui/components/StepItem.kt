package com.client.ui.components

import android.graphics.Paint
import android.graphics.Paint.Align
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StepItem(
    step: Step
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StepCircle(
            isCompleted = step.isCompleted,
            selectedStepColor = step.selectedStepColor,
            unSelectedStepColor = step.unSelectedStepColor,
            stepNumber = step.number
        )
        Column(
            modifier = Modifier.padding(start = 4.dp)
        ) {
            Text(
                text = step.title,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = step.description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
private fun StepCircle(
    modifier: Modifier = Modifier,
    isCompleted: Boolean,
    selectedStepColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedStepColor: Color = MaterialTheme.colorScheme.onSurface,
    stepNumber: Int
) {
    Canvas(
        modifier = modifier.size(40.dp)
    ) {
        val isCompletedColor = if (isCompleted) {
            selectedStepColor
        } else {
            unSelectedStepColor
        }
        drawCircle(
            color = isCompletedColor,
            radius = 40f
        )

        val paint = Paint().apply {
            textSize = 30f
            textAlign = Align.CENTER
            typeface = Typeface.DEFAULT_BOLD
        }
        drawIntoCanvas { canvas ->
            canvas.nativeCanvas.drawText(
                stepNumber.toString(),
                center.x,
                center.y - (paint.descent() + paint.ascent()) / 2,
                paint
            )
        }
    }
}

@Composable
fun VerticalLine(
    modifier: Modifier = Modifier,
    isCompleted: Boolean
) {
    val color = if (isCompleted) {
        MaterialTheme.colorScheme.primary
    } else {
        Color.LightGray
    }
    Canvas(
        modifier = modifier
            .padding(start = 19.dp)
            .progressSemantics(0.5f)
            .height(16.dp)
    ) {
        val halfHeight = size.height / 2

        drawLine(
            color = color,
            start = Offset(x = size.width / 2, y = halfHeight),
            end = Offset(x = size.width / 2, y = 0f),
            strokeWidth = 4f
        )

        drawLine(
            color = Color.LightGray,
            start = Offset(x = size.width / 2, y = size.height),
            end = Offset(x = size.width / 2, y = halfHeight),
            strokeWidth = 4f
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun StepItemPreview() {
    StepItem(
        step = Step(
            title = "Step 1",
            description = "Basic information",
            isCompleted = true,
            selectedStepColor = Color.Green,
            unSelectedStepColor = Color.LightGray,
            number = 1
        )
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun VerticalProgressStepsPreview() {
    val steps: List<Step> = listOf(
        Step(
            title = "Step 1",
            description = "Basic information",
            isCompleted = true,
            selectedStepColor = MaterialTheme.colorScheme.primary,
            unSelectedStepColor = Color.LightGray,
            number = 1
        ),
        Step(
            title = "Step 2",
            description = "Complete your profile",
            isCompleted = true,
            selectedStepColor = MaterialTheme.colorScheme.primary,
            unSelectedStepColor = Color.LightGray,
            number = 2
        ),
        Step(
            title = "Step 3",
            description = "Onboarding",
            isCompleted = false,
            selectedStepColor = MaterialTheme.colorScheme.primary,
            unSelectedStepColor = Color.LightGray,
            number = 3
        ),
        Step(
            title = "Step 4",
            description = "AI Matching",
            isCompleted = false,
            selectedStepColor = MaterialTheme.colorScheme.primary,
            unSelectedStepColor = Color.LightGray,
            number = 4
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            steps.forEachIndexed { index, step ->
                StepItem(step = step)

                if (index < steps.size - 1) {
                    Spacer(modifier = Modifier.height(4.dp))
                    VerticalLine(isCompleted = steps[index + 1].isCompleted)
                }
            }
        }
    }
}
