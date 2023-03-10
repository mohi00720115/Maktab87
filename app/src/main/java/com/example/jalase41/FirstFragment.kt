package com.example.jalase41

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jalase41.databinding.FragmentFirstBinding
import java.util.*
import kotlin.collections.ArrayList

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: FirstViewModel by viewModels()
    private lateinit var adapter: AdapterRecycler
    private val navControl by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.viewModelFirst = viewModel
//        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        viewModel.setList(City.listCity)

        viewModel.listCity.observe(viewLifecycleOwner) { t ->
            adapter = AdapterRecycler(t!!, detail = { cityDataClass ->
                navControl.navigate(FirstFragmentDirections.actionFirstFragmentToDescriptionFragment(cityDataClass))
                Toast.makeText(requireContext(), cityDataClass.description, Toast.LENGTH_SHORT).show()
            })
            binding.recyclerView.adapter = adapter
        }

    }
}