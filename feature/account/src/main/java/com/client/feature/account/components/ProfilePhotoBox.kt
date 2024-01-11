package com.client.feature.account.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.client.employ.feature.account.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun ProfilePhotoBox() {
    Box(
        modifier = Modifier.size(150.dp),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.user),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        ElevatedCard(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(38.dp),
            onClick = { /*TODO*/ },
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Filled.Edit,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}
