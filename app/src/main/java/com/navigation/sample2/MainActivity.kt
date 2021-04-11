package com.navigation.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navigationController = navHostFragment.findNavController()
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.menu.findItem(R.id.item_home).isChecked = true

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            if (navigationController.currentDestination?.id != R.id.home_fragment) navigationController.navigateUp()
            if (item.itemId == R.id.item_home) navigationController.navigate(R.id.action_global_home_fragment)
            if (item.itemId == R.id.item_notifications) navigationController.navigate(R.id.action_global_notification_fragment)
            if (item.itemId == R.id.item_search) navigationController.navigate(R.id.action_global_search_fragment)
            true
        }

        navigationController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.home_fragment) bottomNavigation.menu.findItem(R.id.item_home).isChecked = true
            if (destination.id == R.id.notification_fragment) bottomNavigation.menu.findItem(R.id.item_notifications).isChecked = true
            if (destination.id == R.id.search_fragment) bottomNavigation.menu.findItem(R.id.item_search).isChecked = true
        }
    }
}