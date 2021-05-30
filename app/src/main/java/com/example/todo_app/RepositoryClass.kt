package com.example.todo_app

import androidx.lifecycle.LiveData

class RepositoryClass(private val dao: UserDAO) {

    val allData: LiveData<List<EntityClass>> = dao.getAllData()

    suspend fun insert(data : EntityClass){
        dao.insert(data)
    }
    suspend fun delete(data: EntityClass){
        dao.delete(data)
    }
}
