package com.behzoddev.e_wallet.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transactionModel: TransactionModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTransaction(transactionModel: TransactionModel): Int

    @Delete
    suspend fun deleteTransaction(transactionModel: TransactionModel): Int

    @Query("SELECT * FROM transaction_table ORDER BY transaction_create_date")
    fun getAllTransactions(): Flow<List<TransactionModel>>

    @Query("SELECT * FROM transaction_table WHERE transaction_id = :transactionId")
    fun getById(transactionId: Int): Flow<TransactionModel>
}