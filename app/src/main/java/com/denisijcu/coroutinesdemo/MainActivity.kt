  package com.denisijcu.coroutinesdemo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp


import com.denisijcu.coroutinesdemo.ui.theme.CoroutinesDemoTheme
import com.denisijcu.coroutinesdemo.viewModel.MyViewModel



  class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesDemoTheme {
                // A surface container using the 'background' color from the theme

               val viewModel = MyViewModel()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   MyComposable(viewModel)



                }
            }
        }
    }


  }

@Composable
fun MyComposable(viewModel: MyViewModel){
    // Launch coroutine for UI-related asynchronous tasks
    var task:String by remember {
        mutableStateOf("Task running...")
    }

    var ct:Int by remember {
        mutableIntStateOf(0)
    }


    //val viewModelScope = viewModel.viewModelScope
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = task)
        Text(text = ct.toString())
    }

    LaunchedEffect(true) {

        viewModel.performAsyncTask()
    }
    task = viewModel.task.value

    ct = viewModel.ctn.value

    
    Spacer(modifier = Modifier.height(100.dp))



}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutinesDemoTheme {
      //  Greeting("Android")
    }
}



