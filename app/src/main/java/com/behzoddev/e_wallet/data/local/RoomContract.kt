package com.behzoddev.e_wallet.data.local

object RoomContract {
    object Database {
        const val DATABASE_TABLE_NAME = "transaction_database"
    }
    object Transaction {
        const val TRANSACTION_TABLE_NAME = "transaction_table"
        const val TRANSACTION_TITLE = "transaction_title"
        const val TRANSACTION_AMOUNT = "transaction_amount"
        const val TRANSACTION_TYPE = "transaction_type"
        const val TRANSACTION_TAG = "transaction_tag"
        const val TRANSACTION_DATE = "transaction_date"
        const val TRANSACTION_DESC = "transaction_desc"
        const val TRANSACTION_CREATE_DATE = "transaction_create_date"
        const val TRANSACTION_ID = "transaction_id"
    }
}