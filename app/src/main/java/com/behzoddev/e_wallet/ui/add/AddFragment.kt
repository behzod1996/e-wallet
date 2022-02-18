package com.behzoddev.e_wallet.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.behzoddev.e_wallet.R
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.common.extensions.setDatePicker
import com.behzoddev.e_wallet.databinding.FragmentAddBinding
import com.behzoddev.e_wallet.utils.constants.TransactionTags
import com.behzoddev.e_wallet.utils.constants.TransactionType
import java.util.*

class AddFragment : BaseFragment<FragmentAddBinding>() {

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddBinding {
        return FragmentAddBinding.inflate(inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeTag()
        initializeType()
        initializeDatePicker()
    }


    private fun initializeTag() = with(binding) {
        val transactionTag = ArrayAdapter(
            requireContext(),
            R.layout.layout_autocomplete,
            TransactionTags.tags
        )
        layoutAdd.actTag.setAdapter(transactionTag)
    }

    private fun initializeType() = with(binding) {
        val transactionType = ArrayAdapter(
            requireContext(),
            R.layout.layout_autocomplete,
            TransactionType.types
        )
        layoutAdd.actType.setAdapter(transactionType)
    }

    private fun initializeDatePicker() = with(binding) {
        layoutAdd.tieDate.setDatePicker(
            requireContext(),
            "dd/MM/E",
            Date()
        )
    }
}