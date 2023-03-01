package com.example.netflix.comingSoon

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflix.IShareMovie
import com.example.netflix.R
import com.example.netflix.databinding.FragmentCommingSoonBinding
import com.example.netflix.profile.ProfileViewModel


class ComingSoonFragment : Fragment(R.layout.fragment_comming_soon), IShareMovie {
    private lateinit var binding: FragmentCommingSoonBinding
    private val viewModelComingSoon: ComingSoonViewModel by viewModels()
    private val viewModelProfile: ProfileViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.comingSoonViewModelXML = viewModelComingSoon

        val adapter = RecyclerViewComingSoon(viewModelComingSoon.imageListOfMovie,this)
        binding.recyclerComingSoon.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerComingSoon.adapter = adapter

    }

    override fun onClickComingSoon(position:Int) {
        if (viewModelProfile.checkEditTexts()) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT,viewModelComingSoon.imageListOfMovie[position].movieName)
        intent.type = "text/plain"
        startActivity(intent)
        } else Toast.makeText(requireContext(), "اول باید ثبت نام کنی عمو", Toast.LENGTH_SHORT).show()
    }
}