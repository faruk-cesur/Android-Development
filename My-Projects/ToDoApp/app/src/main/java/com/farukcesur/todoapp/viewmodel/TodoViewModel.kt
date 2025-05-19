package com.farukcesur.todoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farukcesur.todoapp.data.TodoEntity
import com.farukcesur.todoapp.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
    @HiltViewModel ➜ Bu sınıfın ViewModel olduğunu ve Hilt tarafından yönetileceğini belirtir.

    constructor(...): ViewModel() ➜ Hilt sayesinde Repository doğrudan enjekte edilir.

    viewModelScope.launch { ... } ➜ Coroutine başlatır, bu sayede işlemler arka planda yapılır.

    val allTodos: LiveData<...> ➜ Listeyi UI katmanına ileteceğimiz yer burasıdır.
 */

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    val allTodos: LiveData<List<TodoEntity>> = repository.getAllTodos()

    fun insertTodo(todo: TodoEntity) {
        viewModelScope.launch {
            repository.insertTodo(todo)
        }
    }

    fun deleteTodo(todo: TodoEntity) {
        viewModelScope.launch {
            repository.deleteTodo(todo)
        }
    }

    fun updateTodo(todo: TodoEntity) {
        viewModelScope.launch {
            repository.updateTodo(todo)
        }
    }
}