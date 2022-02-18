package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import javax.inject.Inject

class DeleteTransactionInteractorImpl @Inject constructor(
    private val transactionRepository: TransactionRepository
) : DeleteTransactionInteractor {
    override suspend fun invoke(transactionModel: TransactionModel): Int {
        return transactionRepository.deleteTransaction(transactionModel)
    }
}