package com.example.wauwau

import android.app.Fragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wauwau.ui.FavoritesFragment
import com.example.wauwau.ui.HomeFragment
import com.example.wauwau.ui.MessageFragment
import com.example.wauwau.ui.ProfilFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1, "Home", R.drawable.home)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2, "Favorites", R.drawable.favorites)
        )
        bottomNavigation.add(
                CurvedBottomNavigation.Model(3, "Inbox", R.drawable.inbox)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(4, "Profile", R.drawable.person)
        )

        bottomNavigation.setOnClickListener{
            when(it.id){
                1 -> {
                    replaceFragment(HomeFragment())
                }
                2 -> {
                    replaceFragment(FavoritesFragment())
                }
                3 -> {
                    replaceFragment(MessageFragment())
                }
                4 -> {
                    replaceFragment(ProfilFragment())
                }
            }
        }
        //default bottom tab selected
        replaceFragment(HomeFragment())
        bottomNavigation.show(1)
    }

    fun replaceFragment(fragment: androidx.fragment.app.Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}