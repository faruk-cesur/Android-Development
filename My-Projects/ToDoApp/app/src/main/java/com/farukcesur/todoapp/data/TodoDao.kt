package com.farukcesur.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

/*
Room, veritabanı işlemlerini doğrudan kodla yazmanı istemez. Bunun yerine DAO (Data Access Object)
dediğimiz arayüzlerle tüm işlemleri tanımlarsın. Room da bu arayüzden gerçek kodu kendi üretir.

 | Fonksiyon       | Görev                                                           |
| --------------- | --------------------------------------------------------------- |
| `insertTodo()`  | Yeni bir görev ekler. Aynı ID'li görev varsa üzerine yazar.     |
| `updateTodo()`  | Var olan görevi günceller.                                      |
| `deleteTodo()`  | Verilen görevi siler.                                           |
| `getAllTodos()` | Tüm görevleri id'ye göre sıralayıp getirir. `LiveData` döner.   |
| `searchTodos()` | Başlığa göre filtreleme yapar. `%kelime%` şeklinde çağıracağız. |
*/

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

    @Update
    suspend fun updateTodo(todo: TodoEntity)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

    @Query("SELECT * FROM todo_table ORDER BY id DESC")
    fun getAllTodos(): LiveData<List<TodoEntity>>

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery")
    fun searchTodos(searchQuery: String): LiveData<List<TodoEntity>>
}
