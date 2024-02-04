package com.example.pokedex2.ui.components.utils.dialog

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.pokedex2.constants.messages.ERROR_DISMISS_TEXT
import com.example.pokedex2.ui.components.utils.text.color.RedAlertText

@Composable
fun NotFoundDialog(
    onDismissRequest: () -> Unit,
    title: String,
    description: String,
) {
    AlertDialog(
        icon = {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = "Warning Icon",
                tint = Color.Red
            )
        },
        title = {
            RedAlertText(text = title)
        },
        text = {
            Text(text = description)
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