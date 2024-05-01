package com.client.account.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.client.employ.feature.account.ui.R

@Composable
internal fun SearchTextField(
    modifier: Modifier = Modifier,
    searchQuery: MutableState<String>
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
            focusedContainerColor = colorResource(R.color.feature_account_border_color),
            unfocusedContainerColor = colorResource(R.color.feature_account_border_color),
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
        placeholder = {
            Text(
                text = stringResource(R.string.feature_account_search),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
        }
    )
}
