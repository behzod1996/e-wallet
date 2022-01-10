package com.behzoddev.e_wallet.data.repository

import com.behzoddev.e_wallet.data.local.LocalDataSource
import com.behzoddev.e_wallet.data.local.Transaction
import com.behzoddev.e_wallet.di.BindModule
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor
    (@BindModule.DataSourceBinds private val localDataSource: LocalDataSource): LocalRepository {
    override suspend fun insertTransaction(transaction: Transaction): Long {
        return localDataSource.insertTransaction(transaction)
    }

    override suspend fun updateTransaction(transaction: Transaction): Long {
        return localDataSource.updateTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: Transaction): Long {
        return localDataSource.deleteTransaction(transaction)
    }

    override fun getAllTransactions(): Flow<List<Transaction>> {
        return localDataSource.getAllTransactions()
    }

    override fun getById(transactionId: Int): Flow<Transaction> {
        return localDataSource.getById(transactionId)
    }
}