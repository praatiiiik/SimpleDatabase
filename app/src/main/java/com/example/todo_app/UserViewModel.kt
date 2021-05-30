package com.example.todo_app

import android.app.Application
import androidx.annotation.InspectableProperty
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<EntityClass>>
    private val repositiory : RepositoryClass

    init {
        val dao = UserDatabase.getDatabase(application).getUserDao()
        repositiory = RepositoryClass(dao)
        allNotes = repositiory.allData
    }

    fun deleteNote(note : EntityClass) = viewModelScope.launch(Dispatchers.IO) {

        repositiory.delete(note)
    }

    fun insertNote(note : EntityClass) = viewModelScope.launch(Dispatchers.IO) {

        repositiory.insert(note)
    }
}