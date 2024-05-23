package com.example.wauwau.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wauwau.data.Datasource
import com.example.wauwau.data.Message
import com.example.wauwau.data.Pet

class WauWauViewModel: ViewModel() {

    val allPets: List<Pet> = Datasource.data
    val allMessages: List<Message> = Datasource.messages

    private val _pets = MutableLiveData<List<Pet>>(allPets)
    private val _messages = MutableLiveData<List<Message>>(allMessages)
    val pets: LiveData<List<Pet>>
        get() = _pets
    val messages: LiveData<List<Message>>
        get() = _messages

    val selectedPetItem = MutableLiveData<Pet>()
    val selectedMessageItem = MutableLiveData<Message>()


    fun selectedPetItem(it: Pet){
        selectedPetItem.value = it
    }
    fun selectedMessageItem(it: Message){
        selectedMessageItem.value = it
    }
}