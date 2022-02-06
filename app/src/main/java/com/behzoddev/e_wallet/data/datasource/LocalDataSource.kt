package com.behzoddev.e_wallet.data.datasource

import com.behzoddev.e_wallet.data.local.Transaction
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertTransaction(transaction: Transaction): Long
    suspend fun updateTransaction(transaction: Transaction): Long
    suspend fun deleteTransaction(transaction: Transaction): Int
    fun getAllTransactions(): Flow<List<Transaction>>
    fun getById(transactionId: Int): Flow<Transaction>
}