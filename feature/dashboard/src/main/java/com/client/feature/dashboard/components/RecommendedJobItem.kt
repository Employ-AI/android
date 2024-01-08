package com.client.feature.dashboard.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.client.employ.feature.dashboard.R

@Composable
internal fun RecommendedJobItem(
    positionTitle: String = "UI/UX Designer",
    companyName: String = "Google LLC",
    companyLogoUrl: String = "https://www.techjunkie.com/wp-content/uploads/2020/11/How-to-Change-the-Google-Logo.jpg",
    location: String = "California, United States",
    salary: String = "$100,000 - $120,000",
    tags: List<String> = listOf("Full Time", "Remote")
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 350.dp, height = 215.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(
                width = 1.dp,
                color = colorResource(R.color.feature_dashboard_border_color)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TopSection(companyLogoUrl, positionTitle, companyName)

                Divider(
                    modifier = Modifier.padding(10.dp),
                    color = Color.LightGray,
                    thickness = 0.5.dp
                )

                BelowSection(
                    location = location,
                    salary = salary,
                    tags = tags
                )
            }
        }
    }
}

@Composable
private fun BelowSection(
    modifier: Modifier = Modifier,
    location: String,
    salary: String,
    tags: List<String>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 80.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = location,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = salary,
            style = MaterialTheme.typography.bodyMedium
        )

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(tags.size) { chipItem ->
                SuggestionChip(
                    modifier = Modifier.padding(end = 5.dp),
                    label = {
                        Text(
                            text = tags[chipItem],
                            style = MaterialTheme.typography.labelSmall
                        )
                    },
                    onClick = {},
                    border = SuggestionChipDefaults.suggestionChipBorder(
                        borderColor = colorResource(R.color.feature_dashboard_text_field_search_background)
                    )
                )
            }
        }
    }
}

@Composable
private fun TopSection(
    companyLogoUrl: String,
    positionTitle: String,
    companyName: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Row {
            OutlinedCard(
                modifier = Modifier
                    .padding(8.dp)
                    .size(55.dp),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color(0xFFE0E0E0)
                )
            ) {
                AsyncImage(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(CircleShape)
                        .size(50.dp),
                    model = companyLogoUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Inside
                )
            }

            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = positionTitle,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = companyName,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Filled.Bookmark,
                contentDescription = null,
                tint = Color.LightGray
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun RecommendedJobItemPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        RecommendedJobItem()
    }
}
