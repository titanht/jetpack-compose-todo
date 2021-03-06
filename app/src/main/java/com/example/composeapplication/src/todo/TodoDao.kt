package com.example.composeapplication.src.todo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * from todo_items ORDER BY id ASC")
    fun getItems(): LiveData<List<TodoItem>>

    @Insert
    suspend fun insertTodoItem(todoItem: TodoItem)

    @Query("SELECT * FROM todo_items WHERE id = :id")
    suspend fun getItem(id: Int): TodoItem?

    @Delete
    suspend fun deleteItem(todoItem: TodoItem)

    @Update
    suspend fun updateItem(todoItem: TodoItem)
}