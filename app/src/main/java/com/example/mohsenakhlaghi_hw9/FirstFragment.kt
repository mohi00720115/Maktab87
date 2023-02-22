package com.example.mohsenakhlaghi_hw9

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.example.mohsenakhlaghi_hw9.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding
    val firstFragmentViewModel: FirstFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!          //باید بنویسیش
        binding.lifecycleOwner = this                   //باید بنویسیش
        binding.viewModel1 = firstFragmentViewModel     //باید بنویسیش


        //آرگیومنت همین requireArguments هست که اگه نال بود بهم ارور بده
        if (arguments?.getString("KEY_NAME2") != null &&
            arguments?.getString("KEY_PASS2") != null
        ) {
            firstFragmentViewModel.name.value = requireArguments().getString("KEY_NAME2").toString()
            firstFragmentViewModel.pass.value = requireArguments().getString("KEY_PASS2").toString()
        }

        binding.btnLogin.setOnClickListener {
            if (binding.editTextUserName.text == null || binding.editTextPassword.text == null) {
                Toast.makeText(requireContext(), "کادر خالیه", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.editTextUserName.text.toString() == arguments?.getString("KEY_NAME2") &&
                    binding.editTextPassword.text.toString() == arguments?.getString("KEY_PASS2")
                ) {
                    Toast.makeText(requireContext(), "برابره", Toast.LENGTH_SHORT).show()
                } else Toast.makeText(requireContext(), "نا برابره", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSingUp.setOnClickListener {
            val userName = binding.editTextUserName.text.toString()
            val passWord = binding.editTextPassword.text.toString()
            val bundle = bundleOf("KEY_NAME" to userName, "KEY_PASS" to passWord)

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add<SecondFragment>(R.id.container_view, args = bundle)
                addToBackStack(null)

            }
        }


    }

}