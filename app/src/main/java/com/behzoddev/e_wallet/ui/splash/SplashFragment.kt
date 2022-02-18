package com.behzoddev.e_wallet.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.behzoddev.e_wallet.R
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToDashboard()
    }

    private fun navigateToDashboard() = with(binding) {
        btnStart.setOnClickListener {
            findNavController().navigate(R.id.actionFromSplashToDashboard)
        }
    }
}