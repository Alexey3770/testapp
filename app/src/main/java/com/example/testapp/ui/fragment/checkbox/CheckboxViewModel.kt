package com.example.testapp.ui.fragment.checkbox

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheckboxViewModel : ViewModel() {

    private val list = mutableListOf<String>()

    val listLiveData = MutableLiveData<List<String>>()

    fun addItem(item: String) {
        list.add(item)
        listLiveData.value = list
    }

    fun removeItem(item: String) {
        list.remove(item)
        listLiveData.value = list
    }
}