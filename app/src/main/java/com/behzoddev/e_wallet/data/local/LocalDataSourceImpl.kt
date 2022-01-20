package com.behzoddev.e_wallet.data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor
    (private val transactionDao: TransactionDao) : LocalDataSource {

    override suspend fun insertTransaction(transaction: Transaction): Long {
        return transactionDao.insertTransaction(transaction)
    }

    override suspend fun updateTransaction(transaction: Transaction): Long {
        return transactionDao.updateTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: Transaction): Long {
        return transactionDao.deleteTransaction(transaction)
    }

    override fun getAllTransactions(): Flow<List<Transaction>> {
       return transactionDao.getAllTransactions()
    }

    override fun getById(transactionId: Int): Flow<Transaction> {
        return transactionDao.getById(transactionId)
    }
}