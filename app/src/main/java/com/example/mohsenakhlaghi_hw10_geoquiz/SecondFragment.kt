package com.example.mohsenakhlaghi_hw10_geoquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mohsenakhlaghi_hw10_geoquiz.Cheater.status
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.FragmentFirstBinding
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
//    private lateinit var binding2: FragmentFirstBinding
    private val secondViewModel: SecondViewModel by viewModels()
    private val obj : FirstViewModel by viewModels()
    var cheatStatus = status
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!            //باید بنویسیش
        binding.lifecycleOwner = this                     //باید بنویسیش
        binding.viewModel2 = secondViewModel              //باید بنویسیش

        binding.btnCheatActivity.setOnClickListener {
            val bundle = requireArguments().getBoolean("CurrentAnswer").toString()
            binding.tvCheat.text = bundle
            obj.cheatStatus.status = true
        }

    }

}