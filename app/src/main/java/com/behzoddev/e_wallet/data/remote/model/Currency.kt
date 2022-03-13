package com.behzoddev.e_wallet.data.remote.model

data class Currency(
    val code: String,
    val title: String,
    val symbol: String
) {
    override fun toString(): String {
        return "Currency :  {code: $code, title: $title, symbol: $symbol}"
    }
}
