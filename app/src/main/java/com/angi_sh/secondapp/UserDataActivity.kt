package com.angi_sh.secondapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.angi_sh.secondapp.databinding.FragmentEnterActivityBinding
import com.angi_sh.secondapp.databinding.FragmentUserDataActivityBinding

class UserDataActivity : Fragment() {

    private lateinit var binding: FragmentUserDataActivityBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Создание экземпляра класса FragmentEnterActivityBinding и
        //связывание его с разметкой фрагмента
        binding = FragmentUserDataActivityBinding.inflate(inflater, container, false)
//        binding.back.setOnClickListener {
//            // Навигация к другому фрагменту с помощью NavController и указанием ID действия
//            //Ручное управление транзакциями
//            (activity as FragmentActivity).supportFragmentManager.commit {
//                replace<EnterActivity>(R.id.nav_host_fragment)
//                setReorderingAllowed(true)
//                addToBackStack(null)
//
//            }
//        }

        binding.back.setOnClickListener {
            // Навигация к другому фрагменту с помощью NavController и указанием ID действия
            findNavController().navigate(R.id.action_userDataActivity_to_enterActivity)
        }
//        binding.toCamera.setOnClickListener {
//            // Навигация к другому фрагменту с помощью NavController и указанием ID действия
//            findNavController().navigate(R.id.action_userDataActivity_to_useCamera)
//        }
        binding.toCamera.setOnClickListener {
            // Навигация к другому фрагменту с помощью NavController и указанием ID действия
            findNavController().navigate(R.id.action_userDataActivity_to_useCamera)
        }
        return binding.root
    }
}