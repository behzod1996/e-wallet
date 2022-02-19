package com.behzoddev.e_wallet.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.behzoddev.e_wallet.R
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.common.extensions.setDatePicker
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.databinding.FragmentAddBinding
import com.behzoddev.e_wallet.presentation.add.AddViewModel
import com.behzoddev.e_wallet.utils.constants.TransactionTags
import com.behzoddev.e_wallet.utils.constants.TransactionType
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding>() {

    private val addViewModel: AddViewModel by activityViewModels()

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
        insertTransaction()
    }

    private fun insertTransaction() {
        with(binding) {
            btnSave.setOnClickListener{
                addViewModel.insertTransaction(fetchTransactions()).run {
                    findNavController().navigate(R.id.actionAddFragmentToDashboardFragment)
                }
            }
        }
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

    private fun fetchTransactions(): TransactionModel = binding.layoutAdd.let {
        val transactionTitle = it.tieTitle.text.toString()
        val transactionAmount = it.tieAmount.text.toString()
        val transactionType = it.actType.text.toString()
        val transactionTag= it.actTag.text.toString()
        val transactionDate = it.tieDate.text.toString()
        val transactionDesc = it.tieDesc.text.toString()

        return@fetchTransactions TransactionModel(transactionTitle,transactionAmount.toDouble(),transactionType,transactionTag,transactionDate,transactionDesc)
    }
}