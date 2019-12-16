package com.pkoncity.projektx.ui.infoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoAppViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Vytvořil jsem to já!!"
    }
    val text: LiveData<String> = _text
}