package com.behzoddev.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.e_wallet.data.local.Transaction
import com.behzoddev.e_wallet.domain.usecase.DeleteTransactionUseCase
import com.behzoddev.e_wallet.domain.usecase.GetAllTransactionsUseCase
import com.behzoddev.e_wallet.utils.LocalState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor (
    private val getAllTransactions: GetAllTransactionsUseCase,
    private val deleteTransaction: DeleteTransactionUseCase
        ) : ViewModel() {

    private var _dashboardState = MutableStateFlow<LocalState>(LocalState.Loading)
    val dashboardState : StateFlow<LocalState> = _dashboardState

    init {
        viewModelScope.launch {
            getAllTransactions.getAllTransactions().collect { result ->
                if (result.isNullOrEmpty()) {
                    _dashboardState.value = LocalState.Empty
                } else {
                    _dashboardState.value = LocalState.Success(result)
                }

            }
        }
    }

    fun deleteTransaction(transaction: Transaction) : Job {
        return viewModelScope.launch {
            deleteTransaction.deleteTransaction(transaction)
        }
    }
}