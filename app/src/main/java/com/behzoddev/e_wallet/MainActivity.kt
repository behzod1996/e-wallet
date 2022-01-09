package com.behzoddev.e_wallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeNavigation()
    }

    private fun initializeNavigation() {
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host) as NavHostFragment?
            ?: return
    }
}