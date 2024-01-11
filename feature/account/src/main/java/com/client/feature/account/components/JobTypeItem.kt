package com.client.feature.account.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.client.employ.feature.account.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun JobTypeItem(
    modifier: Modifier = Modifier,
    isFindJobSelected: Boolean = false,
    @StringRes title: Int,
    @StringRes description: Int,
    @DrawableRes image: Int,
    onCardClick: () -> Unit
) {
    // var selectedIndex by remember { mutableIntStateOf(-1) }
    /* TODO: Handle only one item selected at a time */

    val colors = if (!isFindJobSelected) {
        CardDefaults.cardColors(
            containerColor = Color.White
        )
    } else {
        CardDefaults.cardColors(
            containerColor = getColorResource(R.color.feature_account_selected_card_background),
            contentColor = Color.White
        )
    }

    Card(
        onClick = onCardClick,
        modifier = modifier.size(width = 170.dp, height = 250.dp),
        shape = RoundedCornerShape(50.dp),
        colors = colors,
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(R.color.feature_account_border_color)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(image),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(title),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(10.dp),
                text = stringResource(description),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun JobTypeItemPreview() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        JobTypeItem(
            onCardClick = { /*TODO*/ },
            title = R.string.feature_account_choose_job_type_find_job,
            description = R.string.feature_account_choose_job_type_find_job_description,
            image = R.drawable.job_searching
        )
    }
}

@Composable
private fun getColorResource(id: Int): Color {
    val context = LocalContext.current
    return Color(ContextCompat.getColor(context, id))
}
/* TODO: move this somewhere else */
