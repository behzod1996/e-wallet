package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.common.coroutine.DispatcherProvider
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateTransactionInteractorImpl @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val dispatcherProvider: DispatcherProvider
) : UpdateTransactionInteractor {

    override suspend fun invoke(transactionModel: TransactionModel): Int {
        return withContext(dispatcherProvider.io) {
            transactionRepository.updateTransaction(transactionModel)
        }
    }
}