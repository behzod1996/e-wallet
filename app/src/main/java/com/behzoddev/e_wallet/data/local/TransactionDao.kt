package com.behzoddev.e_wallet.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTransaction(transaction: Transaction): Long

    @Delete
    suspend fun deleteTransaction(transaction: Transaction): Int

    @Query("SELECT * FROM transaction_table ORDER BY transaction_create_date")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM transaction_table WHERE transaction_id =:productId")
    fun getById(productId: Int): Flow<Transaction>
}