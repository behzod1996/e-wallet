package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import javax.inject.Inject

class UpdateTransactionInteractorImpl @Inject constructor(
    private val transactionRepository: TransactionRepository
) : UpdateTransactionInteractor {
    override suspend fun invoke(transactionModel: TransactionModel): Int {
        return transactionRepository.updateTransaction(transactionModel)
    }
}