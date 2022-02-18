package com.behzoddev.e_wallet.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.behzoddev.e_wallet.R
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.databinding.FragmentDashboardBinding


class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var navController: NavController

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeBottomNavigation()
        onNavigateToAdd()
        onNavigateToConverter()
    }


    private fun onNavigateToAdd() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.actionFromDashboardToAdd)
        }
    }

    private fun initializeBottomNavigation() = with(binding) {
        navController = Navigation.findNavController(requireActivity(),R.id.nav_host)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }
    private fun onNavigateToConverter() = with(binding) {
        btnCurrency.setOnClickListener {
            findNavController().navigate(R.id.actionFromDashboardToConverter)
        }
    }
}