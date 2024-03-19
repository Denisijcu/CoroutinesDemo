package com.denisijcu.coroutinesdemo.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel:ViewModel() {
    // Coroutine scope for ViewModel
   var ctn: MutableState<Int> = mutableStateOf(0)
   var task: MutableState<String> = mutableStateOf("")
    fun performAsyncTask() {

        viewModelScope.launch {
            // Asynchronous task, e.g., network request or database operation
            delay(6000)
            println("Task completed!")
            ctn.value += 1
            task.value = "Task Completed! ${ctn.value}"
        }
    }

}
