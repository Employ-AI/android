package com.client.employ.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.client.employ.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AppTopBar(
    modifier: Modifier = Modifier,
    name: String,
    notificationCount: Int,
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    AsyncImage(
                        modifier = Modifier.clip(CircleShape),
                        model = "https://images.ctfassets.net/h6goo9gw1hh6/2sNZtFAWOdP1lmQ33VwRN3/24e953b920a9cd0ff2e1d587742a2472/1-intro-photo-final.jpg?w=1200&h=992&fl=progressive&q=70&fm=jpg",
                        placeholder = painterResource(R.drawable.baseline_person_24),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        stringResource(R.string.good_morning),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        "Mohsen Rzna",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        },
        actions = {
            IconButton(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .border(1.dp, Color.LightGray, CircleShape),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
    )
}

@Preview
@Composable
private fun AppTopBarPreview() {
    AppTopBar(
        name = "Mohsen Rzna",
        notificationCount = 0,
        navController = NavHostController(LocalContext.current),
        currentDestination = null
    )
}
