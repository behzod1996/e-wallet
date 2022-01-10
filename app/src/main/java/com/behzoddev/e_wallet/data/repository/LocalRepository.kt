package com.behzoddev.e_wallet.data.repository

import com.behzoddev.e_wallet.data.local.Transaction
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun insertTransaction(transaction: Transaction): Long
    suspend fun updateTransaction(transaction: Transaction): Long
    suspend fun deleteTransaction(transaction: Transaction): Long
    fun getAllTransactions(): Flow<List<Transaction>>
    fun getById(transactionId: Int): Flow<Transaction>
}