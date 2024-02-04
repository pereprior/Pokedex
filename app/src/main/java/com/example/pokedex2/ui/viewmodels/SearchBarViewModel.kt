package com.example.pokedex2.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Clase para gestionar la busqueda de Pokemon en la lista
 * Debido a que hay como más de 1000 Pokemon, es incomodo tener que buscar con el scroll un pokemon especifico
 */
class SearchBarViewModel: ViewModel() {

    private var _query = MutableLiveData<String>()
    private var _isActive = MutableLiveData<Boolean>()
    private var _filteredList = MutableLiveData<List<String>>()
    private var _openDialog = MutableLiveData<Boolean>()

    val query: LiveData<String> = _query
    val isActive: LiveData<Boolean> = _isActive
    val filteredList: LiveData<List<String>> = _filteredList
    val openDialog: LiveData<Boolean> = _openDialog

    // Actualizar el texto que introduce el usuario en la barra de busqueda
    fun setQuery(value: String) {
        _query.value = value
    }

    // Gestionar la barra de datos para que se active o desactive cuando el usuario requiera
    fun setActive(value: Boolean) {
        _isActive.value = value
    }

    // Filtrar la lista de pokemon de acuerdo al texto que esté introduciendo el usuario
    fun setDataList(values: List<String>, query: String) {
        val data = values.map { it }
        _filteredList.value = data.filter { it.contains(query, true) }
    }

    // Abrir un mensaje de error en caso que el texto introducido no coincida con ningun pokemon existente
    fun setOpenDialog(value: Boolean) {
        _openDialog.value = value
    }

}