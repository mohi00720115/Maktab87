package com.example.recyclerviewandnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //این 2 خط کد، جای کامیت کردن، فرگمنت رو در اکتیویتی اصلی برنامه نمایش میده
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_view) as NavHostFragment
        val navController = navHostFragment.navController

        val btnNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        btnNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.firstFragment -> {
                    navController.navigate(R.id.firstFragment)
                }
                R.id.secondFragment -> {
                    navController.navigate(R.id.secondFragment)
                }
            }
            true
        }


    }
}