package com.angi_sh.secondapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
            .baseUrl("https://www.cbr-xml-daily.ru/").client(client)
            .addConverterFactory(GsonConverterFactory.create()) //json converter
            .build()
        val rates = retrofit.create(RateApi::class.java)
        // создание объекта базы данных
        val db = MainDb.getDB(this)


        binding.update.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                val all_rates = rates.getRateById().rates
                for ((s, d) in all_rates){
                    val item = RateEntity(s,d)
                    db.getDao().insertItem(item)
                }
            }
        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = MainDb.getDB(this)

        //представление данных
        val recyclerView: RecyclerView = binding.list
        val data = mutableListOf<String>()

        //получение списка из бд
        db.getDao().getAllItems().asLiveData().observe(this){ list->
            var i=1
            list.forEach{
                val t = "${i}) ${it.id} Rate: ${1/(it.rate)}\n"
                i+=1
                data.add(t)
            }
            //отразить изменения на экране
            val adapter = MyAdapter(data)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
//        //отразить изменения на экране
//        val adapter = MyAdapter(data)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

}