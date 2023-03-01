package com.example.netflix.home

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflix.IonClickItems
import com.example.netflix.R
import com.example.netflix.databinding.FragmentHomeBinding
import com.example.netflix.favorite.FavoriteFragment
import com.example.netflix.profile.ProfileViewModel

class HomeFragment : Fragment(R.layout.fragment_home), IonClickItems {
    private lateinit var binding: FragmentHomeBinding
    private val viewModelHome: HomeViewModel by activityViewModels()
    private val viewModelProfile: ProfileViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.homeViewModelXML = viewModelHome

        //recyclerView
        val adapter = RecyclerViewHome(viewModelHome.imageListOfMovie, this)
        binding.recyclerHome.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerHome.adapter = adapter

    }

    override fun onClick(position: Int) {
        if (viewModelProfile.checkEditTexts()){
        viewModelHome.likeOrDislike(position)
        } else Toast.makeText(requireContext(), "اول باید ثبت نام کنی عمو", Toast.LENGTH_SHORT).show()
    }
}