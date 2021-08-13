package com.example.dynamiccontent.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val textFieldState = MutableLiveData("")

    fun onTextChanged(newText: String) {
        textFieldState.value = newText
    }
}