package com.example.lesson3_5_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson3_5_kotlin.databinding.FragmentOneBinding
import com.example.lesson3_5_kotlin.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {

    private lateinit var binding: FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = arguments?.getString("score")
        binding.tvResult.text = "Результат " + text + ". Но думаю еще надо подумать "
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentTwo()
    }
}