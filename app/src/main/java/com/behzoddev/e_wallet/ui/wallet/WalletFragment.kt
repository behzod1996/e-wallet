package com.behzoddev.e_wallet.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.behzoddev.e_wallet.R
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.common.extensions.toastShort
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.databinding.FragmentWalletBinding
import com.behzoddev.e_wallet.presentation.wallet.WalletViewModel
import com.behzoddev.e_wallet.utils.states.TransactionViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class WalletFragment : BaseFragment<FragmentWalletBinding>() {

    private lateinit var walletAdapter: WalletAdapter
    private val walletViewModel: WalletViewModel by viewModels()

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWalletBinding {
        return FragmentWalletBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        observerWallet()
        onNavigateBack()
    }

    private fun initializeRecyclerView() = with(binding) {
        walletAdapter = WalletAdapter()
        val recyclerView = transactionRecyclerView
        recyclerView.adapter = walletAdapter
    }

    private fun observerWallet() = lifecycleScope.launchWhenCreated {
        walletViewModel.walletState.collect {
            when(it) {
                is TransactionViewState.Loading -> {}
                is TransactionViewState.Success -> {
                    getAllTransactions(it.data)
                }
                is TransactionViewState.Error -> {
                    toastShort("Cannot load data")
                }
                is TransactionViewState.Empty -> {

                }
            }
        }
    }

    private fun onNavigateBack() = with(binding) {
        toolbarWallet.btnBack.isClickable = true
        toolbarWallet.btnBack.setOnClickListener {
            findNavController().navigate(R.id.actionWalletFragmentToDashboardFragment)
        }
    }
    private fun getAllTransactions(list: List<TransactionModel>) = walletAdapter.differ.submitList(list)
}