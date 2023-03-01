package com.example.mohsenakhlaghi_hw10_geoquiz

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.FragmentGameBinding

class GameFragment : Fragment(R.layout.fragment_game) {
    companion object {
        const val KEY_ANSWER = "CurrentAnswer"
    }
    private lateinit var binding: FragmentGameBinding
    private val gameViewModel: GameViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!          //باید بنویسیش
        binding.lifecycleOwner = this                   //باید بنویسیش
        binding.viewModel1 = gameViewModel              //باید بنویسیش


        binding.btnCheat.setOnClickListener {
            val bundleRegister = bundleOf(KEY_ANSWER to gameViewModel.currentAnswer)
            Navigation.findNavController(view)
                .navigate(R.id.action_gameFragment_to_cheatFragment, bundleRegister)
        }

        binding.btnFalse.setOnClickListener {
            gameViewModel.userAnswerList[gameViewModel.questionNumber] = false.toString()
            if (gameViewModel.cheatStatus.status) {
                Toast.makeText(requireContext(), "تقلب کردی",Toast.LENGTH_SHORT).show()
            } else {
                if (gameViewModel.checkAnswer(false)) {
                    Toast.makeText(requireContext(), gameViewModel.scoreShowTrue(),Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), gameViewModel.scoreShowFalse(),Toast.LENGTH_SHORT).show()
                }
            }
            lock()
        }

        binding.btnTrue.setOnClickListener {
            gameViewModel.userAnswerList[gameViewModel.questionNumber] = true.toString()
            if (gameViewModel.cheatStatus.status) {
                Toast.makeText(requireContext(), "تقلب کردی",Toast.LENGTH_SHORT).show()
            } else {
                if (gameViewModel.checkAnswer(true)) {
                    Toast.makeText(requireContext(), gameViewModel.scoreShowTrue(),Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), gameViewModel.scoreShowFalse(),Toast.LENGTH_SHORT).show()
                }
            }
            lock()
        }

        binding.btnPrev.setOnClickListener {
            gameViewModel.prevQuestion()
            lock()
        }

        binding.btnNext.setOnClickListener {
            gameViewModel.nextQuestion()
            lock()
        }


    }

    fun lock() {
        binding.btnCheat.isEnabled =
            gameViewModel.userAnswerList[gameViewModel.questionNumber].isEmpty()
        binding.btnFalse.isEnabled =
            gameViewModel.userAnswerList[gameViewModel.questionNumber].isEmpty()
        binding.btnTrue.isEnabled =
            gameViewModel.userAnswerList[gameViewModel.questionNumber].isEmpty()
    }
}