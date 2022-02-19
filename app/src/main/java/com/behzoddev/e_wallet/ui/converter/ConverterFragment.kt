package com.behzoddev.e_wallet.ui.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.databinding.FragmentConverterBinding

class ConverterFragment : BaseFragment<FragmentConverterBinding>() {

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentConverterBinding {
        return FragmentConverterBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}