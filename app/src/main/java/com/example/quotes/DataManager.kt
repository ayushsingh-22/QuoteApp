package com.example.quotes

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import java.io.IOException


object DataManager {

    var Data = emptyArray<Quotes>()
    var isDataLoaded = mutableStateOf(false)
    var currentquote : Quotes? = null
    var initial = mutableStateOf(Page.List)

    fun loadAllData(context: Context) {

        try {
            val input = context.assets.open("quotes.json")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            val json = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            Data = gson.fromJson(json, Array<Quotes>::class.java)
            isDataLoaded.value = true
        }

        catch (e: IOException) {
            Toast.makeText(context, "Error Occurred $e", Toast.LENGTH_LONG).show()
        }
    }

    enum class Page {
                    List, Detail }

    fun switchpages() {
        if (initial.value == Page.List) {
            initial.value = Page.Detail
        }
        else {
            initial.value = Page.List
        }
    }
}