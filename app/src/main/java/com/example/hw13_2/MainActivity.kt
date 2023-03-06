package com.example.hw13_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.hw13_2.databinding.ActivityMainBinding
import com.example.hw13_2.taskActivity.TaskActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val NAME_KEY = "KEY_NAME"
        const val TASK_NUM_KEY = "KEY_TASK_NUMBER"
    }

    private lateinit var binding: ActivityMainBinding
    private val vmMain: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = vmMain

        binding.btnLogin.setOnClickListener {
            if (binding.editTextTaskNumber.text.toString().toInt() > 40) {
                Toast.makeText(this, "تعداد کار ها باید کمتر از 40 باشد", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                Toast.makeText(this, vmMain.check(), Toast.LENGTH_SHORT).show()
            }
            if (vmMain.status) {
                val intent = Intent(this, TaskActivity::class.java)
                intent.putExtra(NAME_KEY, vmMain.name.value.toString())
                intent.putExtra(TASK_NUM_KEY, vmMain.numberOfTask.value?.toInt())
                startActivity(intent)
                Toast.makeText(this, vmMain.check(), Toast.LENGTH_SHORT).show()
            }
        }


    }
}