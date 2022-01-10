package com.behzoddev.e_wallet.domain

import com.behzoddev.e_wallet.data.local.Transaction
import com.behzoddev.e_wallet.data.repository.LocalRepository
import com.behzoddev.e_wallet.di.BindModule
import javax.inject.Inject

class InsertTransactionUseCase @Inject constructor
    (@BindModule.RepositoryBinds private val repository: LocalRepository)
{
        suspend fun insertTransaction(transaction: Transaction): Long {
            return repository.insertTransaction(transaction)
        }
}