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
    suspend fun deleteTransaction(transaction: Transaction): Long

    @Query("SELECT * FROM ${RoomContract.Database.DATABASE_TABLE_NAME} " +
            "ORDER BY ${RoomContract.Transaction.TRANSACTION_CREATE_DATE}")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM ${RoomContract.Database.DATABASE_TABLE_NAME} WHERE ${RoomContract.Transaction.TRANSACTION_ID} =:productId")
    fun getById(productId: Int): Flow<Transaction>
}