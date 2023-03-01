package com.example.tictoktoe2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tictoktoe2.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second), IClickListener {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: SecondViewModel by viewModels()

    //    private val viewModel: SecondViewModel by activityViewModels()
    private val viewModelSettings: SettingViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.viewModelXML2 = viewModel

        viewModel.namePlayerOne = viewModelSettings.playerNameOne
        viewModel.namePlayerTwo = viewModelSettings.playerNameTwo
        viewModel.changeRowAndColumn(viewModelSettings.rowAndColumn)
//        viewModel.changeRowAndColumn(viewModelSettings.rowAndColumn)
        //recyclerView
        viewModel.fetchData(viewModel.rowAndColumn)
        val adapter = RecyclerForInRow(viewModel.getListPlace(), this, viewModel.status)
        binding.recycler.layoutManager =
            GridLayoutManager(requireContext(), viewModelSettings.rowAndColumn)
        binding.recycler.adapter = adapter

    }

    override fun setOnClick(number: Int) {
        viewModel.bottomItemClick(number)
    }

}