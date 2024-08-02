package com.example.messenger

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TodoViewModel : ViewModel() {

    val todoDao = MainApplication.todoDatabase.getTodoDao()


    val todoList : LiveData<List<Todo>> = todoDao.getAllTodo()

    private val _imageURIs = MutableLiveData<List<Uri>>(emptyList())
    val imageURIs: LiveData<List<Uri>> get() = _imageURIs

    fun addTodo(title : String){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.addTodo(Todo(title = title, createdAt = Date.from(Instant.now())))
        }
    }

    fun deleteTodo(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
    }
    fun addImageUri(uri: Uri) {
        _imageURIs.value = _imageURIs.value?.plus(uri)
    }



}