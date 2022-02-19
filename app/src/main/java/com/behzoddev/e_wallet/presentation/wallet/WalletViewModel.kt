package com.behzoddev.e_wallet.presentation.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.interactor.DeleteTransactionInteractor
import com.behzoddev.e_wallet.domain.interactor.FetchAllTransactionsInteractor
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

    private var _walletState = MutableStateFlow<TransactionViewState>(TransactionViewState.Loading)
    val walletState : StateFlow<TransactionViewState> = _walletState

    init {
        viewModelScope.launch {
            getAllTransactions.invoke().collect { result ->
                if (result.isNullOrEmpty()) {
                    _walletState.value = TransactionViewState.Empty
                } else {
                    _walletState.value = TransactionViewState.Success(result)
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