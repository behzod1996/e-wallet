package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.data.local.TransactionModel

interface DeleteTransactionInteractor {
    suspend operator fun invoke(transactionModel: TransactionModel) : Int
}