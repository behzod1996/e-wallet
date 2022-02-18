package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.data.local.TransactionModel

interface InsertTransactionInteractor {
    suspend operator fun invoke(transactionModel: TransactionModel): Long
}