package com.example.hw13_2

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
//            val taskName = binding.editTextName.text.toString()
//            val taskNumber = binding.editTextTaskNumber.text.toString()
            Toast.makeText(this, vmMain.check(), Toast.LENGTH_SHORT).show()
            if (vmMain.status) {
                val intent = Intent(this, TaskActivity::class.java)
                intent.putExtra(NAME_KEY, vmMain.name.value.toString())
                Log.e(TAG, "onCreate: ${vmMain.name.value}")
                intent.putExtra(TASK_NUM_KEY, vmMain.number.value?.toInt())
                Log.e(TAG, "onCreate: ${vmMain.number.value}")
                startActivity(intent)
                Toast.makeText(this, vmMain.check(), Toast.LENGTH_SHORT).show()
            }
        }


    }
}