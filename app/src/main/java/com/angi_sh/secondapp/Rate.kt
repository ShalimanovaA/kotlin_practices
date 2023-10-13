package com.angi_sh.secondapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.angi_sh.secondapp.databinding.FragmentRateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rate : Fragment() {

    private lateinit var binding: FragmentRateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRateBinding.inflate(inflater, container,
            false)

        //перехватываем
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        // инициализируем retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.cbr-xml-daily.ru/")
            .addConverterFactory(GsonConverterFactory.create()).client(client) //json converter
            .build()
        val rates = retrofit.create(RateApi::class.java)
//        val db = MainDb.getDB(this)
            binding.update.setOnClickListener{
                CoroutineScope(Dispatchers.IO).launch {
                    val all_rates = rates.getRateById().rates
                    val i = 0
                    System.out.println(all_rates)
//                    for ((s, d) in all_rates){
//                        System.out.println(s)
//                    }
//                        
                    }

                }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}