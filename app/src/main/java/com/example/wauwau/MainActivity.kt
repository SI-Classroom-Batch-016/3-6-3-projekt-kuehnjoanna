package com.example.wauwau

import android.app.Fragment
import android.content.Context
import android.graphics.Insets.add
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.wauwau.databinding.ActivityMainBinding
import com.example.wauwau.databinding.FragmentHomeBinding
import com.example.wauwau.ui.FavoritesFragment
import com.example.wauwau.ui.HomeFragment
import com.example.wauwau.ui.MessageFragment
import com.example.wauwau.ui.PetSearchFragment
import com.example.wauwau.ui.ProfilFragment
import com.example.wauwau.ui.WauWauViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
        binding.bottomNavigationView.setOnClickListener {
            replaceFragment(MessageFragment())
        }
      binding.bottomAppBar.setNavigationOnClickListener{
            when(it.id){
                R.id.bottomHome -> replaceFragment(HomeFragment())
                R.id.bottomProfile -> replaceFragment(ProfilFragment())
                R.id.favorites -> replaceFragment(FavoritesFragment())
                R.id.inbox -> replaceFragment(MessageFragment())
                else -> "oops"
            }
        }



    }


    fun replaceFragment(fragment: androidx.fragment.app.Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.homeFragment, fragment)
            .commit()
    }


}