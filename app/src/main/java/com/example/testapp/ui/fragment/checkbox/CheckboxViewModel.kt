package com.example.testapp.ui.fragment.checkbox

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * View model for [CheckboxFragment]. Contains logic for adding and removing items from list.
 */
class CheckboxViewModel : ViewModel() {

    private val list = mutableListOf<String>()

    /**
     * Live data with list of strings.
     */
    val listLiveData = MutableLiveData<List<String>>()

    /**
     * Add item to list.
     *
     * @param item - item which should be added.
     */
    fun addItem(item: String) {
        list.add(item)
        listLiveData.value = list
    }

    /**
     * Remove item from list.
     *
     * @param item - item which should be removed.
     */
    fun removeItem(item: String) {
        list.remove(item)
        listLiveData.value = list
    }
}