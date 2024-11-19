package com.example.bookmark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bookmark.database.FavoriteFragment
import com.example.bookmark.database.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set up the navigation for the BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_list -> {
                    openFragment(ListFragment())
                    true
                }
                R.id.nav_favorite -> {
                    openFragment(FavoriteFragment())
                    true
                }
                else -> false
            }
        }

        // Open ListFragment by default
        if (savedInstanceState == null) {
            openFragment(ListFragment())
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
