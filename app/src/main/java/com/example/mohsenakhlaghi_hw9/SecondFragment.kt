package com.example.mohsenakhlaghi_hw9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import com.example.mohsenakhlaghi_hw9.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    val secondFragmentViewModel: SecondFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!          //باید بنویسیش
        binding.lifecycleOwner = this                   //باید بنویسیش
        binding.viewModel2 = secondFragmentViewModel     //باید بنویسیش

        secondFragmentViewModel.name2.value = requireArguments().getString("KEY_NAME").toString()
        secondFragmentViewModel.pass2.value = requireArguments().getString("KEY_PASS").toString()

        binding.btnSingUp2.setOnClickListener {
            val userName2 = binding.editTextUserName2.text.toString()
            val passWord2 = binding.editTextPassword2.text.toString()
            val bundle2 = bundleOf("KEY_NAME2" to userName2, "KEY_PASS2" to passWord2)
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FirstFragment>(R.id.container_view, args = bundle2)

            }
        }

    }
}