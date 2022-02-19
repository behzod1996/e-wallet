package com.behzoddev.e_wallet.common.extensions

import java.text.NumberFormat
import java.util.*

fun convertToString(amount: Double) : String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("USD")
    return format.format(amount)
}