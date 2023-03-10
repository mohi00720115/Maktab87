package com.example.jalase41

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.jalase41.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment(R.layout.fragment_description) {
    private lateinit var binding: FragmentDescriptionBinding
    val viewModelDescription: DescriptionViewModel by viewModels()
    private val detailArgs : DescriptionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.tv1.text = detailArgs.data.id.toString()
        binding.tv2.text = detailArgs.data.nameCity
        binding.tv3.text = detailArgs.data.description

    }
}