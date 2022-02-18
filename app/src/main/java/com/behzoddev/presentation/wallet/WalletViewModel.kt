package com.behzoddev.presentation.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.interactor.DeleteTransactionInteractor
import com.behzoddev.e_wallet.domain.interactor.FetchAllTransactionsInteractor
import com.behzoddev.e_wallet.utils.LocalState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor (
    private val getAllTransactions: FetchAllTransactionsInteractor,
    private val deleteTransaction: DeleteTransactionInteractor
        ) : ViewModel() {

    private var _dashboardState = MutableStateFlow<LocalState>(LocalState.Loading)
    val dashboardState : StateFlow<LocalState> = _dashboardState

    init {
        viewModelScope.launch {
            getAllTransactions.invoke().collect { result ->
                if (result.isNullOrEmpty()) {
                    _dashboardState.value = LocalState.Empty
                } else {
                    _dashboardState.value = LocalState.Success(result)
                }
            }
        }
    }

    fun deleteTransaction(transactionModel: TransactionModel) : Job {
        return viewModelScope.launch {
            deleteTransaction.invoke(transactionModel)
        }
    }
}