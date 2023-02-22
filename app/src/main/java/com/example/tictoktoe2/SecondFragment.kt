package com.example.tictoktoe2

import android.nfc.Tag
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.tictoktoe2.databinding.FragmentFirstBinding
import com.example.tictoktoe2.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: SecondViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.viewModelXML2 = viewModel

        val tagList = arrayListOf(
            binding.row0Btn0,binding.row0Btn1,binding.row0Btn2,binding.row0Btn3,binding.row0Btn4,
            binding.row1Btn0,binding.row1Btn1,binding.row1Btn2,binding.row1Btn3,binding.row1Btn4,
            binding.row2Btn0,binding.row2Btn1,binding.row2Btn2,binding.row2Btn3,binding.row2Btn4,
            binding.row3Btn0,binding.row3Btn1,binding.row3Btn2,binding.row3Btn3,binding.row3Btn4,
            binding.row4Btn0,binding.row4Btn1,binding.row4Btn2,binding.row4Btn3,binding.row4Btn4
        )

        //برای تمام دکمه ها آنکلیک می نویسه و با فانکشنی که صدا زدیم می فرسته اونور
        for (i in tagList){
            i.setOnClickListener {
                viewModel.chooseColumn(i.tag.toString().toInt())
            }
        }


    }
}