package com.example.lesson3_5_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson3_5_kotlin.databinding.FragmentOneBinding

class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var isInc = true
        binding.btnScore.setOnClickListener(){

            if(isInc == true){
                var score = binding.tvScore.text.toString().toInt().inc()
                binding.tvScore.text = score.toString()
                }
            else {
                var score = binding.tvScore.text.toString().toInt().dec()
                binding.tvScore.text = score.toString()
            }


            if(binding.tvScore.text.toString().toInt() == 10  ){
                isInc = false

            }else if (binding.tvScore.text.toString().toInt() == 0 && !isInc){
                var bundle = Bundle()
                bundle.putString("score", binding.tvScore.text.toString())
                val fragmentTwo = FragmentTwo()
                fragmentTwo.arguments = bundle
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container_one, fragmentTwo).commit()
            }
        }



    }



    companion object {

        @JvmStatic
        fun newInstance() = FragmentOne() }

}