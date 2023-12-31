package com.example.pokedex2.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.pokedex2.model.api.response.ResponsedUrlData
import com.example.pokedex2.ui.theme.TypesColor
import kotlinx.coroutines.delay
import java.util.Locale

fun capitalized(s:String):String {
    return s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}

@Composable
fun WaitCircle(route: String, navController: NavHostController) {
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var error by remember { mutableStateOf(false) }
        CircularProgressIndicator()

        LaunchedEffect(Unit) {
            delay(10000)
            error = true
        }

        if (error) {
            NotFoundDialog(onDismissRequest = { navController.navigate(route) })
        }
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