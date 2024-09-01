package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quotes.screen.HomeScreen
import com.example.quotes.theme.QuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        DataManager.loadAllData(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),) { innerPadding ->
                    app()
                }
            }
        }
    }
}

@Composable
fun app() {

    if(DataManager.isDataLoaded.value) {

        if(DataManager.initialState.value == DataManager.Page.List){
            HomeScreen(data = DataManager.Data,) {
            }
        }
    }

    else{

    }
}