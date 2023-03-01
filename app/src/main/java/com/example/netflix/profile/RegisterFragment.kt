package com.example.netflix.profile

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.netflix.R
import com.example.netflix.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding
    private val viewModelProfile: ProfileViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        binding.textView.text = viewModelProfile.name.value
        binding.textView2.text = viewModelProfile.pass.value
        binding.textView3.text = viewModelProfile.number.value
        binding.imageViewPerson.setImageURI(viewModelProfile.uri.value)


    }
}