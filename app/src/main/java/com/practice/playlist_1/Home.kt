package com.practice.playlist_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val bottomnav=findViewById<BottomNavigationView>(R.id.bottom_nav_bar)
        loadFragment(HomeFragment())
        bottomnav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.home->loadFragment(HomeFragment())
                R.id.search->loadFragment(SearchFragment())
                R.id.playlist->loadFragment(PlaylistFragment())
                R.id.profile->loadFragment(ProfileFragment())
            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentloader,fragment)
            .commit()
    }
}
