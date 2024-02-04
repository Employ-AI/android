package com.client.ui

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.client.employ.core.ui.R

@Composable
fun JobItem(
    modifier: Modifier = Modifier,
    positionTitle: String,
    companyName: String,
    companyLogoUrl: String,
    location: String,
    salary: String,
    tags: List<String>
) {
    val isBookmarked = rememberSaveable { mutableStateOf(false) }
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .size(width = 370.dp, height = 220.dp),
        shape = RoundedCornerShape(32.dp),
        border = BorderStroke(
            width = 0.5.dp,
            color = colorResource(R.color.core_ui_border_color)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .wrapContentSize(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    OutlinedCard(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(55.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(
                            width = 0.5.dp,
                            color = colorResource(R.color.core_ui_border_color)
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

                    Column(
                        modifier = Modifier
                            .padding(top = 8.dp, start = 5.dp, end = 15.dp)
                            .wrapContentSize(),
                    ) {
                        Text(
                            text = positionTitle,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                            textAlign = TextAlign.Start
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = companyName,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = {
                            isBookmarked.value = !isBookmarked.value
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Outlined.Bookmark,
                            contentDescription = null,
                            tint = if (isBookmarked.value) {
                                Color.Yellow
                            } else {
                                Color.LightGray
                            }
                        )
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 10.dp),
                thickness = 0.5.dp,
                color = Color.LightGray
            )

            BelowSection(
                location = location,
                salary = salary,
                tags = tags
            )
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
            .padding(start = 75.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = location,
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = salary,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ) {
            items(
                count = tags.take(3).size,
            ) { chipItem ->
                SuggestionChip(
                    modifier = Modifier.padding(end = 5.dp),
                    label = {
                        Text(
                            text = tags[chipItem],
                            style = MaterialTheme.typography.labelSmall
                        )
                    },
                    onClick = {},
                    border = BorderStroke(
                        width = 0.5.dp,
                        color = colorResource(R.color.core_ui_border_color)
                    ),
                    enabled = false
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun JobItemPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        JobItem(
            positionTitle = "Senior Full Stack Engineer Remote",
            companyName = "Google",
            companyLogoUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png",
            location = "San Francisco, CA",
            salary = "$120k - $150k",
            tags = listOf("Java", "Kotlin", "Android", "iOS", "Swift", "Objective-C")
        )
    }
}
