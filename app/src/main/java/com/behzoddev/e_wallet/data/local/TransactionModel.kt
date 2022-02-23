package com.behzoddev.e_wallet.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = RoomContract.Transaction.TRANSACTION_TABLE_NAME)
data class TransactionModel(
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_TITLE)
    var transactionTitle: String,
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_AMOUNT)
    var transactionAmount: Double,
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_TYPE)
    var transactionType: String,
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_TAG)
    var transactionTag: String,
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_DATE)
    var transactionDate: String,
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_DESC)
    var transactionDesc: String,
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_PAYMENT_METHOD)
    var transactionPaymentMethod: String,
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_CREATE_DATE)
    var transactionCreateDate: Long = System.currentTimeMillis(),
    @ColumnInfo(name = RoomContract.Transaction.TRANSACTION_ID)
    @PrimaryKey(autoGenerate = true)
    var transactionId: Int = 0
)
