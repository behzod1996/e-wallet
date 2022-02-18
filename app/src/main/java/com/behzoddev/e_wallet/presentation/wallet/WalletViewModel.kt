package com.behzoddev.e_wallet.presentation.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.interactor.DeleteTransactionInteractor
import com.behzoddev.e_wallet.domain.interactor.FetchAllTransactionsInteractor
import com.behzoddev.e_wallet.utils.LocalState
import com.behzoddev.e_wallet.utils.states.TransactionViewState
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

    private var _dashboardState = MutableStateFlow<TransactionViewState>(TransactionViewState.Loading)
    val dashboardState : StateFlow<TransactionViewState> = _dashboardState

    init {
        viewModelScope.launch {
            getAllTransactions.invoke().collect { result ->
                if (result.isNullOrEmpty()) {
                    _dashboardState.value = TransactionViewState.Empty
                } else {
                    _dashboardState.value = TransactionViewState.Success(result)
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