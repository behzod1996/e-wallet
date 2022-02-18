package com.behzoddev.e_wallet.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.databinding.FragmentWalletBinding

class WalletFragment : BaseFragment<FragmentWalletBinding>() {

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWalletBinding {
        return FragmentWalletBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}