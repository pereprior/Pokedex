package com.example.pokedex2.ui.view.submenu.list.objects

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.pokedex2.viewModel.PokedexViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Medicina(vm: PokedexViewModel, drawerState: DrawerState) {
    /*LaunchedEffect(Unit) {
        vm.getItemList()
    }

    val dataList by vm.itemList.observeAsState(initial = PokedexResponse())
    val abilityList = dataList.results

    if (abilityList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(abilityList) {
                Text(text = it.name)
            }
        }
    }*/
}