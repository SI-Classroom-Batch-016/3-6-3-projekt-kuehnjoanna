package com.example.wauwau.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wauwau.data.Datasource
import com.example.wauwau.data.Pet

class WauWauViewModel: ViewModel() {

    val allPets: List<Pet> = Datasource.data

    private val _pets = MutableLiveData<List<Pet>>(allPets)
    val pets: LiveData<List<Pet>>
        get() = _pets

    val selectedItem = MutableLiveData<Pet>()

    fun selectedItem(it: Pet){
        selectedItem.value = it
    }
}