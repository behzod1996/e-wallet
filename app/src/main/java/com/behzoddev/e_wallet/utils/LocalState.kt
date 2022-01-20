package com.behzoddev.e_wallet.utils

import com.behzoddev.e_wallet.data.local.Transaction

sealed class LocalState {
    object Loading : LocalState()
    object Empty : LocalState()
    data class Success(val data: List<Transaction>): LocalState()
    data class Error(val message: String) : LocalState()
}
