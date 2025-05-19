package com.farukcesur.todoapp.repository

import androidx.lifecycle.LiveData
import com.farukcesur.todoapp.data.TodoDao
import com.farukcesur.todoapp.data.TodoEntity
import javax.inject.Inject

/*
| Kod Parçası                          | Açıklama                                                           |
| ------------------------------------ | ------------------------------------------------------------------ |
| `@Inject constructor(...)`           | Hilt'in bu sınıfı otomatik olarak oluşturabilmesi için gereklidir. |
| `insertTodo(...)`, `deleteTodo(...)` | DAO fonksiyonlarına erişimi sağlar.                                |
| `getAllTodos()`                      | Live olarak veriyi takip etmemizi sağlar.                          |
*/

class TodoRepository @Inject constructor(
    private val todoDao: TodoDao
) {

    suspend fun insertTodo(todo: TodoEntity) {
        todoDao.insertTodo(todo)
    }

    suspend fun updateTodo(todo: TodoEntity) {
        todoDao.updateTodo(todo)
    }

    suspend fun deleteTodo(todo: TodoEntity) {
        todoDao.deleteTodo(todo)
    }

    fun getAllTodos(): LiveData<List<TodoEntity>> {
        return todoDao.getAllTodos()
    }
}
