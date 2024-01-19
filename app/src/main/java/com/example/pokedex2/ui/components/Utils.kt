package com.example.pokedex2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex2.model.api.response.ResponsedUrlData
import com.example.pokedex2.ui.components.theme.TypesColor
import java.util.Locale

@Composable
fun CloseIcon(onDismissRequest: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(
            onClick = {
                onDismissRequest()
            },
            modifier = Modifier.size(32.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun MyLabel(
    color: Color,
    message: String
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(30.dp)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = capitalized(message))
    }
}

fun capitalized(s:String):String {
    return s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}

@Composable
fun WaitCircle() {
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun NotFoundDialog(
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(imageVector = Icons.Filled.Warning, contentDescription = "")
        },
        title = {
            Text(text = "ERROR 404 NOT FOUND")
        },
        text = {
            Text(text = "The name is not correct. Please, check it and try again.")
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
                Text("Dismiss")
            }
        }
    )
}

fun getTypeColor(type: ResponsedUrlData): Color {
    var color = Color.Transparent
    for (e in TypesColor) {
        if (e.name == type.name){
            color = e.color
        }
    }
    return color
}