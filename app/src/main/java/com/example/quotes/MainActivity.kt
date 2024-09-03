package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quotes.screen.HomeScreen
import com.example.quotes.screen.QuoteScreen
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
                DataManager.SwitchPages(it)
            }
        }
        else {
            DataManager.currentquote?.let { quotes ->
                QuoteScreen(quoteData = quotes)
            }
        }
    }

    else{

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {

            Text(text = "Loading Data",
                style = MaterialTheme.typography.displayMedium)
        }

    }
}