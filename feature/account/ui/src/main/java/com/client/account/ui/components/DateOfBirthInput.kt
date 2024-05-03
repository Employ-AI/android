package com.client.account.ui.components

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.client.designSystem.theme.EmployM3Theme
import com.client.employ.feature.account.ui.R
import com.client.reusablecomponents.previews.AppComponent
import com.client.reusablecomponents.previews.MultiThemePreviews
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
internal fun DateTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    val containerColor = colorResource(R.color.feature_account_text_field_search_background)
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var date by remember {
        mutableStateOf(
            if (value.isNotBlank()) {
                LocalDate.parse(
                    value,
                    formatter
                )
            } else {
                LocalDate.now()
            }
        )
    }
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (showDialog) {
        val datePickerDialog = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                date = selectedDate
                onValueChange(selectedDate.format(formatter))
                showDialog = false
            },
            date.year,
            date.monthValue - 1,
            date.dayOfMonth
        )
        datePickerDialog.setOnDismissListener { showDialog = false }
        datePickerDialog.show()
    }

    TextField(
        modifier = Modifier
            .clickable { showDialog = true }
            .fillMaxWidth(),
        label = { Text(text = stringResource(id = R.string.feature_account_date_of_birth)) },
        value = value,
        onValueChange = { },
        enabled = false,
        readOnly = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledTextColor = MaterialTheme.colorScheme.onSurface,
            disabledLabelColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(25.dp),
        keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),
        keyboardActions = KeyboardActions.Default
    )
}

@MultiThemePreviews
@Composable
private fun DateOfBirthInputPreview() {
    AppComponent {
        EmployM3Theme(dark = false) {
            DateTextField(
                value = "01/01/2000",
                onValueChange = {}
            )
        }
    }
}
