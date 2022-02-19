package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.common.coroutine.DispatcherProvider
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertTransactionInteractorImpl @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val dispatcherProvider: DispatcherProvider
) : InsertTransactionInteractor {

    override suspend fun invoke(transactionModel: TransactionModel): Long {
        return withContext(dispatcherProvider.io) {
            transactionRepository.insertTransaction(transactionModel)
        }
    }
}