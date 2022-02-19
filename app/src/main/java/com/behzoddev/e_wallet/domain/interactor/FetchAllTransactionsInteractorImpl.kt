package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.common.coroutine.DispatcherProvider
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchAllTransactionsInteractorImpl @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val dispatcher: DispatcherProvider
) : FetchAllTransactionsInteractor {

    override fun invoke(): Flow<List<TransactionModel>> {
        return transactionRepository.getAllTransactions().flowOn(dispatcher.io)
    }
}