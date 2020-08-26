package com.example.testapp.ui.fragment.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * View model for [ListFragment]. Contains logic which allows to remove items.
 */
class ListViewModel : ViewModel() {

    private val list = mutableListOf("Test", "App", "First")
    private val selectedItems = mutableListOf<String>()

    val listLiveData = MutableLiveData<List<String>>(list)

    fun selectItem(value: String) {
        selectedItems.add(value)
    }

    fun deselectItem(value: String) {
        selectedItems.remove(value)
    }

    fun removeSelectedItems() {
        list.removeAll(selectedItems)
        listLiveData.value = list
    }
}