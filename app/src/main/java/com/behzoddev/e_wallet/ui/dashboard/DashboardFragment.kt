package com.behzoddev.e_wallet.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }
}