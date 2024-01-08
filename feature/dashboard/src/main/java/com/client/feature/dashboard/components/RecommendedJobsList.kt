package com.client.feature.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun RecommendedJobsList(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        modifier = modifier.fillMaxWidth(),
        rows = GridCells.Fixed(1)
    ) {
        items(10) {
            RecommendedJobItem()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun RecommendedJobsPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        RecommendedJobsList()
    }
}
