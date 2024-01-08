package com.client.feature.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.feature.dashboard.R

@Composable
internal fun DashboardHeader(
    modifier: Modifier = Modifier,
) {
    val searchQuery = remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .clip(CircleShape),
            value = searchQuery.value,
            onValueChange = {
                searchQuery.value = it
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorResource(R.color.feature_dashboard_text_field_search_background),
                unfocusedContainerColor = colorResource(R.color.feature_dashboard_text_field_search_background),
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
                    tint = Color.LightGray
                )
            },
            trailingIcon = {
                Icon(
                    modifier = modifier.padding(end = 10.dp),
                    imageVector = Icons.Outlined.FilterList,
                    contentDescription = null,
                    tint = Color.LightGray
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

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .size(170.dp),
            shape = RoundedCornerShape(32.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp
            )
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "See how you can \nfind a job quickly!",
                    style = MaterialTheme.typography.bodyLarge
                )
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
