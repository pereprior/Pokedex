package com.example.pokedex2.ui.components.error.dialog

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.pokedex2.constants.error.ERROR_404_DESCRIPTION
import com.example.pokedex2.constants.error.ERROR_404_TITLE
import com.example.pokedex2.constants.error.ERROR_DISMISS_TEXT

@Composable
fun NotFoundDialog(
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = "Warning Icon"
            )
        },
        title = {
            Text(text = ERROR_404_TITLE)
        },
        text = {
            Text(text = ERROR_404_DESCRIPTION)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {},
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(ERROR_DISMISS_TEXT)
            }
        }
    )
}