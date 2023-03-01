package com.example.tictoktoe2

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.tictoktoe2.databinding.FragmentSecondBinding
import com.example.tictoktoe2.databinding.FragmentSettingBinding


class SettingFragment : Fragment(R.layout.fragment_setting) {
    private lateinit var binding: FragmentSettingBinding
    private val viewModelSetting: SettingViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.btnSettingSubmit.setOnClickListener {
            viewModelSetting.playerNameOne = binding.editTextNumberOne.text.toString()
            viewModelSetting.playerNameTwo = binding.editTextNumberTwo.text.toString()
            viewModelSetting.rowAndColumn = binding.editTextTextNumberOfRow.text.toString().toInt()
        }


    }
}