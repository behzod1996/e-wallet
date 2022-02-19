package com.behzoddev.e_wallet.ui

import com.behzoddev.e_wallet.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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