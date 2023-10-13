package com.angi_sh.secondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.angi_sh.secondapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Объявление переменной для привязки к разметке
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Создание объектов разметки с использованием класса
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Получение корневого представления разметки
        val view = binding.root
        // Установка корневого представления разметки в качестве контента активности
        setContentView(view)

//        //Ручное управление транзакциями
//        val fragmentManager = supportFragmentManager
//        // Затем создаем новую транзакцию
//        val transaction = fragmentManager.beginTransaction()
//        //указываем контейнер , в котором будет размещен новый фрагмент, и новый фрагмент
//        //, который будет отображен вместо текущего фрагмента.
//        transaction.replace(R.id.nav_host_fragment, EnterActivity())
//        transaction.addToBackStack(null) // Добавление транзакции в стек возврата
//        transaction.commit( )//метод commit() для применения транзакции и применения изменений.

    }
}