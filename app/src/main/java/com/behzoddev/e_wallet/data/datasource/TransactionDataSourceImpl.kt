package com.behzoddev.e_wallet.data.datasource

import com.behzoddev.e_wallet.data.local.TransactionDao
import com.behzoddev.e_wallet.data.local.TransactionModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionDataSourceImpl @Inject constructor(
    private val transactionDao: TransactionDao
) : TransactionDataSource {
    override suspend fun insertTransaction(transactionModel: TransactionModel): Long {
        return transactionDao.insertTransaction(transactionModel)
    }

    override suspend fun updateTransaction(transactionModel: TransactionModel): Int {
        return transactionDao.updateTransaction(transactionModel)
    }

    override suspend fun deleteTransaction(transactionModel: TransactionModel): Int {
        return transactionDao.deleteTransaction(transactionModel)
    }

    override fun getAllTransactions(): Flow<List<TransactionModel>> {
        return transactionDao.getAllTransactions()
    }

    override fun getById(transactionId: Int): Flow<TransactionModel> {
        return transactionDao.getById(transactionId)
    }
}