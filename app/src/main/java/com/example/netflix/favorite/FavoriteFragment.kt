package com.example.netflix.favorite

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflix.R
import com.example.netflix.databinding.FragmentFavoriteBinding
import com.example.netflix.home.HomeViewModel
import com.example.netflix.image.ImageDataClass
import java.util.ResourceBundle.getBundle


class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private lateinit var binding : FragmentFavoriteBinding
    private val viewModelFav: FavoriteViewModel by activityViewModels()
    private val viewModelHome: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.favoriteViewModelXML = viewModelFav

        val adapter = RecyclerViewFavorite(viewModelHome.listLikes as ArrayList<ImageDataClass>)
        binding.recyclerFavorite.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerFavorite.adapter = adapter

    }

}