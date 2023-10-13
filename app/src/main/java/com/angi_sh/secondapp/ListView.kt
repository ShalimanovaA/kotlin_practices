package com.angi_sh.secondapp

import android.hardware.Camera
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angi_sh.secondapp.databinding.FragmentListViewBinding
import com.angi_sh.secondapp.databinding.FragmentUseCameraBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader


class ListView : Fragment() {

    private lateinit var binding: FragmentListViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListViewBinding.inflate(inflater, container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.recyclerView
        val data = getData()//listOf("Item 1", "Item 2", "Item 3") // Список данных
            val d = getData()
        System.out.println(d)
            //listOf("Item 1", "Item 2", "Item 3") // Список данных
        val adapter = MyAdapter(data)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getData():List<String>{ //List<String>
        val data = mutableListOf<String>()
        val photosDirectory = File(requireContext().externalMediaDirs.first(), "photos")
        val dateFile = File(photosDirectory, "date.txt")

        try {
            //read lines
            val inputStream = FileInputStream(dateFile)
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            // Чтение данных построчно
            var line: String
            while (bufferedReader.readLine().also { line = it } != null) {
                data.add(line)
            }
            // Закрытие потоков
            bufferedReader.close()
            inputStream.close()
        }
        catch (e: Exception){
            e.printStackTrace()
        }
        data.removeAt(0)
        return data
    }

}