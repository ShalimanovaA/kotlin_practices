package com.angi_sh.secondapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*

import androidx.navigation.fragment.findNavController
import com.angi_sh.secondapp.databinding.FragmentEnterActivityBinding




class EnterActivity : Fragment() {
    private lateinit var binding: FragmentEnterActivityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Создание экземпляра класса FragmentEnterActivityBinding и
        //связывание его с разметкой фрагмента
        binding = FragmentEnterActivityBinding.inflate(inflater, container,
            false)
        binding.next.setOnClickListener {
            // Навигация к другому фрагменту с помощью NavController и указанием ID действия
            findNavController().navigate(R.id.action_enterActivity_to_userDataActivity)
        }
        binding.b.setOnClickListener{
            findNavController().navigate(R.id.action_enterActivity_to_rate)
        }
//        binding.next.setOnClickListener {
//            // Навигация к другому фрагменту с помощью NavController и указанием ID действия
//            //Ручное управление транзакциями
//            (activity as FragmentActivity).supportFragmentManager.commit {
//                replace<UserDataActivity>(R.id.nav_host_fragment)
//                setReorderingAllowed(true)
//                addToBackStack(null)
//
//            }
//        }
        // Возвращение корневого View разметки фрагмента
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.next.setOnClickListener{
//            binding.textView.text="++++++++++++"
//            //Ручное управление транзакциями
//
//            (activity as FragmentActivity).supportFragmentManager.commit {
//                replace<UserDataActivity>(R.id.action_enterActivity_to_userDataActivity)
//                setReorderingAllowed(true)
//                addToBackStack(null)
//
//            }
//        }
    }
}

