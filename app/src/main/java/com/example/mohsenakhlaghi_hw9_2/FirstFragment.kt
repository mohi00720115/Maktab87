package com.example.mohsenakhlaghi_hw9_2

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mohsenakhlaghi_hw9_2.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding
    private val firstViewModel: FirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!          //باید بنویسیش
        binding.lifecycleOwner = this                   //باید بنویسیش
        binding.viewModel = firstViewModel              //باید بنویسیش

        binding.btnRegister.setOnClickListener {
            firstViewModel.fullName = binding.etFullName.text.toString()
            firstViewModel.userName = binding.etUserName.text.toString()
            firstViewModel.email = binding.etEmail.text.toString()
            firstViewModel.password = binding.etPassword.text.toString()
            firstViewModel.rePassword = binding.etRePassword.text.toString()
            firstViewModel.radioMale = binding.radioMale.isChecked
            firstViewModel.radioFeMale = binding.radioFemale.isChecked
            Toast.makeText(requireActivity(), firstViewModel.check(), Toast.LENGTH_SHORT).show()
        }

        binding.btnShowInfo.setOnClickListener {
            val bundleRegister = bundleOf(
                "FULLNAME" to firstViewModel.fullName,
                "USERNAME" to firstViewModel.userName,
                "EMAIL" to firstViewModel.email,
                "PASSWORD" to firstViewModel.password,
                "RE_PASSWORD" to firstViewModel.rePassword
            )
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add<SecondFragment>(R.id.container_view, args = bundleRegister)
                addToBackStack(null)
            }
        }

        binding.btnHideInfo.setOnClickListener {

        }


    }
}