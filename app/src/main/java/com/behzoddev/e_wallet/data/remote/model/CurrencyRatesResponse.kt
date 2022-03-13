package com.behzoddev.e_wallet.data.remote.model

data class CurrencyRatesResponse(
    val base: String,
    val date: String,
    val rates: Rates
)
