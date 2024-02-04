package com.client.feature.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.employ.feature.account.R
import com.client.feature.account.components.JobTypeItem
import com.client.ui.AccountBaseScreen

@Composable
fun ChooseJobTypeRoute(
    onContinueClick: (String) -> Unit
) {
    ChooseJobTypeScreen(
        onContinueClick = onContinueClick
    )
}

@Composable
internal fun ChooseJobTypeScreen(
    modifier: Modifier = Modifier,
    onContinueClick: (String) -> Unit
) {
    val isFindJobSelected = remember { mutableStateOf(false) }
    val jobType = remember { mutableStateOf("") }

    AccountBaseScreen(
        pageTitle = R.string.feature_account_choose_job_type_title,
        description = R.string.feature_account_choose_job_type_description,
        onContinueClick = {
            if (jobType.value.isNotEmpty()) {
                onContinueClick(jobType.value)
            }
        }
    ) {
        LazyHorizontalGrid(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(max = 250.dp),
            rows = GridCells.Fixed(1),
            horizontalArrangement = Arrangement.Center,
            userScrollEnabled = false
        ) {
            item {
                JobTypeItem(
                    isFindJobSelected = isFindJobSelected.value,
                    title = R.string.feature_account_choose_job_type_find_job,
                    description = R.string.feature_account_choose_job_type_find_job_description,
                    image = R.drawable.job_searching,
                    onCardClick = {
                        isFindJobSelected.value = true
                        jobType.value = "Employee"
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.width(16.dp))
            }

            item {
                JobTypeItem(
                    isFindJobSelected = isFindJobSelected.value,
                    title = R.string.feature_account_choose_job_type_find_employee,
                    description = R.string.feature_account_choose_job_type_find_employee_description,
                    image = R.drawable.recruiter_searching,
                    onCardClick = {
                        isFindJobSelected.value = true
                        jobType.value = "Employer"
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChooseJobTypeScreenPreview() {
    ChooseJobTypeScreen(
        onContinueClick = { }
    )
}
