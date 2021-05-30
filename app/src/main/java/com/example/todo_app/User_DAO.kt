package com.example.todo_app

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : EntityClass)

    @Delete
    suspend fun delete(note:EntityClass)

    @Query("Select * from data_table order by id ASC")
    fun getAllData() : LiveData<List<EntityClass>>
}