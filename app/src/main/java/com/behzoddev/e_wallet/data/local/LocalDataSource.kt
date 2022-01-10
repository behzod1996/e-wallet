package com.behzoddev.e_wallet.data.local

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertTransaction(transaction: Transaction): Long
    suspend fun updateTransaction(transaction: Transaction): Long
    suspend fun deleteTransaction(transaction: Transaction): Long
    fun getAllTransactions(): Flow<List<Transaction>>
    fun getById(transactionId: Int): Flow<Transaction>
}