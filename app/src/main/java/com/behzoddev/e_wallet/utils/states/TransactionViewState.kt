package com.behzoddev.e_wallet.utils.states

import com.behzoddev.e_wallet.data.local.TransactionModel

sealed class TransactionViewState {
    object Loading : TransactionViewState()
    object Empty : TransactionViewState()
    data class Success(val data: List<TransactionModel>) : TransactionViewState()
    data class Error(val message: String) : TransactionViewState()
}
