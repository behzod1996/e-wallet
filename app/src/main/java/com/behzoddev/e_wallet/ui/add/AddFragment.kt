package com.behzoddev.e_wallet.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.databinding.FragmentAddBinding

class AddFragment : BaseFragment<FragmentAddBinding>() {

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddBinding {
        return FragmentAddBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}