package com.behzoddev.e_wallet.utils

import com.behzoddev.e_wallet.data.local.TransactionModel

sealed class LocalState {
    object Loading : LocalState()
    object Empty : LocalState()
    data class Success(val data: List<TransactionModel>): LocalState()
    data class Error(val message: String) : LocalState()
}
