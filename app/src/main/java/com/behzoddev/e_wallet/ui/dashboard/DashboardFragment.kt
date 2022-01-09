package com.behzoddev.e_wallet.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.behzoddev.e_wallet.R
import com.behzoddev.e_wallet.common.BaseFragment
import com.behzoddev.e_wallet.databinding.FragmentDashboardBinding


class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToAdd()
        navigateToConverter()
    }

    private fun navigateToAdd() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.actionFromDashboardToAdd)
        }
    }
    private fun navigateToConverter() = with(binding) {
        btnCurrency.setOnClickListener {
            findNavController().navigate(R.id.actionFromDashboardToConverter)
        }
    }
}