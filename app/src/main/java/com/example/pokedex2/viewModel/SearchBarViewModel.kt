package com.example.pokedex2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex2.model.api.response.ResponsedUrlData

class SearchBarViewModel: ViewModel() {

    private var _query = MutableLiveData<String>()
    private var _isActive = MutableLiveData<Boolean>()
    private var _filteredList = MutableLiveData<List<String>>()
    private var _openDialog = MutableLiveData<Boolean>()

    val query: LiveData<String> = _query
    val isActive: LiveData<Boolean> = _isActive
    val filteredList: LiveData<List<String>> = _filteredList
    val openDialog: LiveData<Boolean> = _openDialog

    fun setQuery(value: String) {
        _query.value = value
    }

    fun setActive(value: Boolean) {
        _isActive.value = value
    }

    fun setDataList(values: List<ResponsedUrlData>, query: String) {
        val data = values.map { it.name }
        _filteredList.value = data.filter { it.contains(query, true) }
    }

    fun setOpenDialog(value: Boolean) {
        _openDialog.value = value
    }

}