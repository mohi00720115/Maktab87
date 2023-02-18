package com.example.mohsenakhlaghi_hw9_2

import android.graphics.Insets.add
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import com.example.mohsenakhlaghi_hw9_2.databinding.FragmentFirstBinding
import com.example.mohsenakhlaghi_hw9_2.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    private val secondViewModel: SecondViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!            //باید بنویسیش
        binding.lifecycleOwner = this                     //باید بنویسیش
        binding.viewModel2 = secondViewModel              //باید بنویسیش

        secondViewModel.fullName = requireArguments().getString("FULLNAME").toString()
        secondViewModel.userName = requireArguments().getString("USERNAME").toString()
        secondViewModel.email = requireArguments().getString("EMAIL").toString()
        secondViewModel.password = requireArguments().getString("PASSWORD").toString()
        secondViewModel.rePassword = requireArguments().getString("RE_PASSWORD").toString()

        binding.btnHideInfo.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FirstFragment>(R.id.container_view)
                addToBackStack(null)
            }
        }

    }
}
