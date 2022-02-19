package com.behzoddev.e_wallet.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.behzoddev.e_wallet.R
import com.behzoddev.e_wallet.common.base.BaseFragment
import com.behzoddev.e_wallet.common.extensions.convertToString
import com.behzoddev.e_wallet.common.extensions.debug
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.databinding.FragmentDashboardBinding
import com.behzoddev.e_wallet.presentation.DashboardViewModel
import com.behzoddev.e_wallet.ui.wallet.WalletAdapter
import com.behzoddev.e_wallet.utils.states.TransactionViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var navController: NavController
    private lateinit var dashboardAdapter: WalletAdapter
    private val dashboardViewModel: DashboardViewModel by viewModels()


    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        debug { "onViewCreated() is created" }
        initializeRecyclerView()
        observerDashboard()
        initializeBottomNavigation()
        onNavigateToAdd()
        onNavigateToConverter()
    }

    private fun initializeRecyclerView() = with(binding) {
        dashboardAdapter = WalletAdapter()
        dashboardRecyclerView.adapter = dashboardAdapter
    }

    private fun observerDashboard() = lifecycleScope.launchWhenCreated {
        dashboardViewModel.dashboardState.collect { result ->
            when (result) {
                is TransactionViewState.Loading -> {}
                is TransactionViewState.Success -> {
                    fetchAllTransactions(result.data)
                    fetchTotalTransactions(result.data)
                }
                is TransactionViewState.Error -> {

                }
                is TransactionViewState.Empty -> {

                }
            }
        }
    }

    private fun onNavigateToAdd() = with(binding) {
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.actionFromDashboardToAdd)
            debug { "onNavigateAdd() method is navigated to AddFragment" }
        }
    }

    private fun initializeBottomNavigation() = with(binding) {
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        debug { "Bottom Navigation is initialized" }
    }

    private fun onNavigateToConverter() = with(binding) {
        btnCurrency.setOnClickListener {
            findNavController().navigate(R.id.actionFromDashboardToConverter)
            debug { "onNavigateConverter() method is navigated to ConverterFragment" }
        }
    }

    private fun fetchTotalTransactions(list: List<TransactionModel>) = with(binding) {
        val (totalIncome, totalExpense) = list.partition { it.transactionType == "Income" }
        val income = totalIncome.sumOf { it.transactionAmount }
        val expense = totalExpense.sumOf { it.transactionAmount }
        layoutTotal.tvIncomeValue.text = "+".plus(convertToString(income))
        layoutTotal.tvExpenseValue.text = "-".plus(convertToString(expense))
        layoutTotal.tvTotalValue.text = convertToString(income - expense)
    }

    private fun fetchAllTransactions(list: List<TransactionModel>) =
        dashboardAdapter.differ.submitList(list)
}