package com.example.pokedex2.ui.components.icons

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun MenuIcon(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()

    IconButton(
        onClick = {
            scope.launch {
                drawerState.apply {
                    if (isClosed) open() else close()
                }
            }
        },
        modifier = Modifier.fillMaxHeight()
    ) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = "Modal Drawer Icon"
        )
    }
}