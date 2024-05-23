package com.example.wauwau

import android.app.Fragment
import android.content.Context
import android.graphics.Insets.add
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.wauwau.databinding.ActivityMainBinding
import com.example.wauwau.databinding.FragmentHomeBinding
import com.example.wauwau.ui.FavoritesFragment
import com.example.wauwau.ui.HomeFragment
import com.example.wauwau.ui.HomeFragmentDirections
import com.example.wauwau.ui.LocationFragment
import com.example.wauwau.ui.MessageFragment
import com.example.wauwau.ui.PetSearchFragment
import com.example.wauwau.ui.ProfilFragment
import com.example.wauwau.ui.WauWauViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var fragmentManager: FragmentManager

    companion object {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)


        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false


        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->

            //Rufe die Funktion auf die standardmäßig für die bottom navigation zuständig ist.
            NavigationUI.onNavDestinationSelected(menuItem, navController)
            navController.popBackStack(menuItem.itemId, false)

            true
        }
        binding.fab.setOnClickListener {
            navController.navigate(R.id.petSearchFragment)
         //  goToFragment(LocationFragment())
        }



    }
    private fun goToFragment(fragment: androidx.fragment.app.Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.navHostFragment, fragment).commit()


    }


}