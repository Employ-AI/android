package com.client.feature.dashboard.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.feature.dashboard.R
import com.client.ui.PagerIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun DashboardHeader(
    modifier: Modifier = Modifier,
) {
    val searchQuery = remember { mutableStateOf("") }

    Column {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(CircleShape),
            value = searchQuery.value,
            onValueChange = {
                searchQuery.value = it
            },
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(
                    modifier = modifier.padding(start = 10.dp),
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                Icon(
                    modifier = modifier.padding(end = 10.dp),
                    imageVector = Icons.Outlined.FilterList,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.feature_dashboard_search_for_a_job_or_company),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.LightGray
                )
            }
        )

        /* View pager with dots */
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(15.dp))

            val pagerState1 = rememberPagerState(
                initialPage = 0,
                initialPageOffsetFraction = 0f
            ) { 4 }
            val coroutineScope = rememberCoroutineScope()

            HorizontalPager(
                state = pagerState1,
                pageSpacing = 5.dp,
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .size(170.dp),
                    shape = RoundedCornerShape(32.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 12.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "See how you can find a job quickly!",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            PagerIndicator(
                pagerState = pagerState1,
                indicatorSize = 10.dp,
                activeColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                coroutineScope.launch {
                    pagerState1.scrollToPage(it)
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun DashboardHeaderPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DashboardHeader()
    }
}
