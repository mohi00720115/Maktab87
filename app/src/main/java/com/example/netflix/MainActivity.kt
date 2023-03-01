package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.netflix.comingSoon.ComingSoonFragment
import com.example.netflix.favorite.FavoriteFragment
import com.example.netflix.first.FirstFragment
import com.example.netflix.home.HomeFragment
import com.example.netflix.profile.ProfileFragment
import com.example.netflix.databinding.ActivityMainBinding
import com.example.netflix.profile.ProfileViewModel
import com.example.netflix.profile.RegisterFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModelProfile: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<FirstFragment>(R.id.container_view)
//                addToBackStack(null)
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<HomeFragment>(R.id.container_view)
                    }
                }
                R.id.commingSoonFragment -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<ComingSoonFragment>(R.id.container_view)
                    }
                }
                R.id.favoriteFragment -> {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<FavoriteFragment>(R.id.container_view)
                    }
                }
                R.id.profileFragment -> {
                    if (viewModelProfile.checkEditTexts()) {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<RegisterFragment>(R.id.container_view)
                        }
                    } else {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<ProfileFragment>(R.id.container_view)
                        }
                    }

                }
            }
            true
        }
    }
}