package com.behzoddev.e_wallet.data.repository

import com.behzoddev.e_wallet.data.datasource.TransactionDataSource
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDataSource: TransactionDataSource
) : TransactionRepository {
    override suspend fun insertTransaction(transactionModel: TransactionModel): Long {
        return transactionDataSource.insertTransaction(transactionModel)
    }

    override suspend fun updateTransaction(transactionModel: TransactionModel): Int {
        return transactionDataSource.updateTransaction(transactionModel)
    }

    override suspend fun deleteTransaction(transactionModel: TransactionModel): Int {
        return transactionDataSource.deleteTransaction(transactionModel)
    }

    override fun getAllTransactions(): Flow<List<TransactionModel>> {
        return transactionDataSource.getAllTransactions()
    }

    override fun getById(transactionId: Int): Flow<TransactionModel> {
        return transactionDataSource.getById(transactionId)
    }
}