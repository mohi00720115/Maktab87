package com.example.tictoktoe2

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tictoktoe2.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: FirstViewModel by viewModels()

    private lateinit var tv: TextView
    private lateinit var scoreList: MutableList<Int>
    private lateinit var btnList: List<Button>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.viewModelXML1 = viewModel

        btnList = listOf<Button>(
            binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6,
            binding.btn7, binding.btn8, binding.btn9
        )

//        val tvPlayers = viewModel.turnCounter
//        viewModel.turnCounter = tvPlayers!!
//        tv.text = "Player$tvPlayers's turn"

        fun disables() {
            for (i in btnList) i.isClickable = false
        }

        //RE-START
        fun disablesTrue() {
            for (i in btnList) i.isClickable = true
        }

        fun emptyString() {
            for (i in btnList) i.text = ""
        }

        fun playGame(selects: Int, btns: Button) {
            viewModel.select = selects
            if (viewModel.turnCounter % 2 == 1) btns.text = "X"
            if (viewModel.turnCounter % 2 == 0) btns.text = "O"
            viewModel.nextTurn(viewModel.select)
            viewModel.statusA = viewModel.checkWin(viewModel.player1)
            viewModel.statusB = viewModel.checkWin(viewModel.player2)
            btns.isClickable = false
            if (viewModel.statusA) {
                binding.textView.text = Players.PLAYER2WIN.toString()
                disables()
            }
            if (viewModel.statusB) {
                binding.textView.text = Players.PLAYER1WIN.toString()
                disables()
            }
            if (!viewModel.status && !viewModel.statusA && !viewModel.statusB) {
                binding.textView.text = WinOrLose.DRAW.toString()
                disables()
            }

        }

        for (i in btnList) {
            i.setOnClickListener {
                playGame(btnList.indexOf(i) + 1, i)
            }
        }

        binding.btnReset.setOnClickListener {
            viewModel.reset()
            disablesTrue()
            emptyString()
//            tv.text = "Player$tvPlayers's turn"
        }


    }
}