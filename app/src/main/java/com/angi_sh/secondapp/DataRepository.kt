package com.angi_sh.secondapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataRepository {
    private val data = MutableLiveData<String>()
    fun getData(): LiveData<String> {
        // загрузка данных из источника данных
        data.value = "Hello from rep"
        return data
    }
}
