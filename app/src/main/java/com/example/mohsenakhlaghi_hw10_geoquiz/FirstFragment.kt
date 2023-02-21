package com.example.mohsenakhlaghi_hw10_geoquiz

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding
    private val firstViewModel: FirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!          //باید بنویسیش
        binding.lifecycleOwner = this                   //باید بنویسیش
        binding.viewModel1 = firstViewModel              //باید بنویسیش

/*
        val clickList = booleanArrayOf(
            false,      //btnTrue
            false,      //btnFalse
            false,      //btnCheat
            true,       //btnPrev
            false       //btnNext
        )        //چرخش دکمه های صفحه برای تغییر وضعیت
*/


        binding.btnCheat.setOnClickListener {
            val bundleRegister = bundleOf("CurrentAnswer" to firstViewModel.currentAnswer)
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SecondFragment>(R.id.container_view, args = bundleRegister)
                addToBackStack(null)
            }
        }

        binding.btnFalse.setOnClickListener {
            firstViewModel.list[firstViewModel.questionNumber] = false.toString()
            if (firstViewModel.cheatStatus.status) {
                Toast.makeText(requireContext(), "تقلب کردی",
                    Toast.LENGTH_SHORT).show()
            } else{
            if (firstViewModel.checkAnswer(false)) {
                Toast.makeText(requireContext(), firstViewModel.scoreShowTrue(),
                    Toast.LENGTH_SHORT).show()
//                binding.btnFalse.isClickable = false
            } else {
                Toast.makeText(requireContext(),firstViewModel.scoreShowFalse(),
                    Toast.LENGTH_SHORT).show()
            }
            }
            lock()
        }

        binding.btnTrue.setOnClickListener {
            firstViewModel.list[firstViewModel.questionNumber] = true.toString()
            if (firstViewModel.cheatStatus.status) {
                Toast.makeText(requireContext(), "تقلب کردی و خنگی :)",
                    Toast.LENGTH_SHORT).show()
            } else {
                if (firstViewModel.checkAnswer(true)) {
                    Toast.makeText(requireContext(),firstViewModel.scoreShowTrue(),
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(),firstViewModel.scoreShowFalse(),
                        Toast.LENGTH_SHORT).show()
                }
            }
            lock()
        }

        binding.btnPrev.setOnClickListener {
            firstViewModel.prevQuestion()
            lock()
        }

        binding.btnNext.setOnClickListener {
            firstViewModel.nextQuestion()
            lock()
        }


    }

    fun lock () {
        binding.btnCheat.isEnabled = firstViewModel.list[firstViewModel.questionNumber].isEmpty()
        binding.btnFalse.isEnabled = firstViewModel.list[firstViewModel.questionNumber].isEmpty()
        binding.btnTrue.isEnabled = firstViewModel.list[firstViewModel.questionNumber].isEmpty()
        }

}