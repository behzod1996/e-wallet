package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.data.local.TransactionModel
import kotlinx.coroutines.flow.Flow

interface FetchAllTransactionsInteractor {
    operator fun invoke(): Flow<List<TransactionModel>>
}