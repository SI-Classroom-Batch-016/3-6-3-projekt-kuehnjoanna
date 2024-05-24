package com.example.wauwau.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wauwau.data.Datasource
import com.example.wauwau.data.Message
import com.example.wauwau.data.Pet

class WauWauViewModel: ViewModel() {

    val allPets: List<Pet> = Datasource.data
    var allMessages: MutableList<Message> = Datasource.messages.toMutableList()
    val allFavProfiles: MutableList<Pet> = Datasource.favorites.toMutableList()

    private val _pets = MutableLiveData<List<Pet>>(allPets)
    private val _messages = MutableLiveData<List<Message>>(allMessages)
    private val _favorites = MutableLiveData<List<Pet>>(allFavProfiles)
    val pets: LiveData<List<Pet>>
        get() = _pets
    val messages: LiveData<List<Message>>
        get() = _messages

    val favorites: LiveData<List<Pet>>
        get() = _favorites
    val selectedPetItem = MutableLiveData<Pet>()
    val selectedMessageItem = MutableLiveData<Message>()



    fun selectedPetItem(it: Pet){
        selectedPetItem.value = it
    }
    fun selectedMessageItem(it: Message){
        selectedMessageItem.value = it
    }
    fun addPetToFav(){
        allFavProfiles.add(selectedPetItem.value!!)
    }
    fun removePetFromFav(){
        allFavProfiles.remove(selectedPetItem.value!!)
    }
    fun addMessageToInbox(message: Message){
        allMessages.add(message)
        Log.d("messages", "$allMessages")
    }

    fun filterPets(gender: String){
       val newList = allPets.filter {
            it.gender.equals(gender)
        }
         _pets.value = newList
    }
    fun filterPetsAge(number: Int){
      val newerList = allPets.filter {
                it.age.equals(number)

            }
            _pets.value = newerList

    }
    fun resetFilter(){
        _pets.value = allPets
    }
}
//filter age range
//editable text
