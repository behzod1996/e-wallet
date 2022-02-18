package com.behzoddev.e_wallet.data.datasource

import com.behzoddev.e_wallet.data.local.TransactionModel
import kotlinx.coroutines.flow.Flow

interface TransactionDataSource {
    suspend fun insertTransaction(transactionModel: TransactionModel): Long
    suspend fun updateTransaction(transactionModel: TransactionModel): Int
    suspend fun deleteTransaction(transactionModel: TransactionModel): Int
    fun getAllTransactions(): Flow<List<TransactionModel>>
    fun getById(transactionId: Int): Flow<TransactionModel>
}