package com.example.mohsenakhlaghi_hw10_geoquiz

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.FragmentCheatBinding

class CheatFragment : Fragment(R.layout.fragment_cheat) {
    private lateinit var binding: FragmentCheatBinding

    //    private lateinit var binding2: FragmentFirstBinding
//    private val secondViewModel: SecondViewModel by viewModels()
    private val obj: GameViewModel by viewModels()
    var cheatStatus = Cheater.status

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!            //باید بنویسیش
        binding.lifecycleOwner = this                     //باید بنویسیش
//        binding.viewModel2 = secondViewModel              //باید بنویسیش

        binding.btnCheatActivity.setOnClickListener {
            val bundle = requireArguments().getBoolean("CurrentAnswer").toString()
            binding.tvCheat.text = bundle
            obj.cheatStatus.status = true
        }

    }

}