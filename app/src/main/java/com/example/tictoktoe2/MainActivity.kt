package com.example.tictoktoe2

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.tictoktoe2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.container_view) as NavHostFragment
//        val navController = navHostFragment.navController
//        binding.bottomNavigation.setupWithNavController(navController)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<EmptyFragment>(R.id.container_view)
//                addToBackStack(null)
//            lockDeviceRotation(true)
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.firstFragment -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<FirstFragment>(R.id.container_view)
//                addToBackStack(null)
//                        lockDeviceRotation(true)
                    }
//                    navController.navigate(R.id.firstFragment)
                }
                R.id.secondFragment -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<SecondFragment>(R.id.container_view)
//                addToBackStack(null)
//                        lockDeviceRotation(true)
                    }
//                    navController.navigate(R.id.secondFragment)
                }
            }
            true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settingFragment) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<SettingFragment>(R.id.container_view)
            }
//            val intent = Intent(this, LoginSignupActivity::class.java)
//            intent.putExtra(LoginSignupActivity.RESET, LoginSignupActivity.SIGN_OUT)
//            startActivity(intent)
//            finish()
        }
        return super.onOptionsItemSelected(item)

    }

    //قفل کردن صفحه
//    fun lockDeviceRotation(value: Boolean) {
//        requestedOrientation = if (value) {
//            val currentOrientation = resources.configuration.orientation
//            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
//                ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
//            } else {
//                ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
//            }
//        } else {
//            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
//                ActivityInfo.SCREEN_ORIENTATION_FULL_USER
//            } else {
//                ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
//            }
//        }
//    }

}