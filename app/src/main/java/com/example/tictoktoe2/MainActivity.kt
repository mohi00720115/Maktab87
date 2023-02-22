package com.example.tictoktoe2

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.tictoktoe2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnTikTokToe.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FirstFragment>(R.id.container_view)
//                addToBackStack(null)
                lockDeviceRotation(true)
            }

        }

        binding.newGame.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SecondFragment>(R.id.container_view)
                addToBackStack(null)
                lockDeviceRotation(true)
            }

        }

    }

    //قفل کردن صفحه
    fun lockDeviceRotation(value: Boolean) {
        requestedOrientation = if (value) {
            val currentOrientation = resources.configuration.orientation
            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
            } else {
                ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
            }
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                ActivityInfo.SCREEN_ORIENTATION_FULL_USER
            } else {
                ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
            }
        }
    }

}