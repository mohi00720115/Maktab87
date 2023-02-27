package com.example.tictoktoe2

import android.nfc.Tag
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tictoktoe2.databinding.FragmentFirstBinding
import com.example.tictoktoe2.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second), IClickListener {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: SecondViewModel by viewModels()
//    private val viewModel: SecondViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.viewModelXML2 = viewModel

        val listItems = arrayListOf<Int>()
        for (i in 0..24) {
            listItems.add(i)
        }

        //recyclerView
        var adapter = RecyclerForInRow(viewModel.getListPlace(), this, viewModel.status)
        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 5)
        binding.recycler.adapter = adapter

    }

    override fun setOnClickListener(number: Int) {
        viewModel.choosePlace(number)
    }

}