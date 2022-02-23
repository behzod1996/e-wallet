package com.behzoddev.e_wallet.utils.states

sealed class CurrencyViewState {
    object Loading : CurrencyViewState()
    object Empty : CurrencyViewState()
    data class Success(val data : String) : CurrencyViewState()
    data class Error(val message: String) : CurrencyViewState()
}
