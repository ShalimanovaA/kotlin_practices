package com.angi_sh.secondapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val dataRepository = DataRepository()
    val data: LiveData<String> = dataRepository.getData()
}
