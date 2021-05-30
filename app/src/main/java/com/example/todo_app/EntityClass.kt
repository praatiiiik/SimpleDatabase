package com.example.todo_app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_table")
class EntityClass (@ColumnInfo(name = "name") val name:String, @ColumnInfo(name = "desig") val desig:String ) {
    @PrimaryKey(autoGenerate = true) var id = 0;
}