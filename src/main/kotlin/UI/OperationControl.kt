package UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable

fun AddAlert()
{
    val shouldShowDialog = remember { mutableStateOf(true) }
    if(shouldShowDialog.value)
    {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false

            },
            title = {
                Text(text = "Alert")
            },
            text = {

                Text(text = "This is an example AlertDialog.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        shouldShowDialog.value = false
                        // Handle the positive button action here
                    }
                ) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        shouldShowDialog.value = false
                        // Handle the positive button action here
                    }
                ) {
                    Text(text = "cancel")
                }

            }

        )
    }
}

