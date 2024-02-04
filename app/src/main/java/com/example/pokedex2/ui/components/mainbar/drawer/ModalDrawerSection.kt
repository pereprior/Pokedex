package com.example.pokedex2.ui.components.mainbar.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex2.constants.values.HIGH_PADDING_VALUE
import kotlinx.coroutines.launch

@Composable
fun ModalDrawerSection(
    navController: NavHostController,
    route: String,
    iconResource: Int,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(HIGH_PADDING_VALUE.dp)
            .clickable {
                // Nos lleva a la opcion del menu que seleccionemos
                navController.navigate(route)

                // Maneja el menu para que se pueda abrir y cerrar mediante una corrutina
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }
    ) {
        // Icono de cada opcion de la ruta
        SectionIcon(iconResource)

        Spacer(modifier = Modifier.width(HIGH_PADDING_VALUE.dp))
        // Nombre de la ruta a la que dirige cada opcion
        Text(text = route)
    }
}

@Composable
private fun SectionIcon(imageResource: Int) {
    val iconSize = 24

    Icon(
        painter = painterResource(id = imageResource),
        contentDescription = "Menu Option",
        modifier = Modifier.size(iconSize.dp)
    )
}