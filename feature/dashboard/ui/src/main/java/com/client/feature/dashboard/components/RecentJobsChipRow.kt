package com.client.feature.dashboard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.core.ui.R

@Composable
internal fun RecentJobsChipRow(
    modifier: Modifier = Modifier,
    tags: List<String> = listOf(
        "AI",
        "Android",
        "iOS",
        "React",
        "Kotlin",
        "Java",
        "Swift",
        "Python",
        "C++",
        "C#"
    )
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) {
            SuggestionChip(
                label = {
                    Text(
                        text = tags[it],
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                onClick = {},
                border = BorderStroke(
                    width = 0.5.dp,
                    color = colorResource(R.color.core_ui_border_color)
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun RecentJobsChipRowPreview() {
    RecentJobsChipRow()
}
