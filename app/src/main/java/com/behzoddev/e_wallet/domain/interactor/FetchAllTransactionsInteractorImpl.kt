package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAllTransactionsInteractorImpl @Inject constructor(
    private val transactionRepository: TransactionRepository
) : FetchAllTransactionsInteractor {
    override fun invoke(): Flow<List<TransactionModel>> {
        return transactionRepository.getAllTransactions()
    }
}