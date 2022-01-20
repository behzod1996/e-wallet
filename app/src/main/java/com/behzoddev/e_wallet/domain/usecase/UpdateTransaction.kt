package com.behzoddev.e_wallet.domain.usecase

import com.behzoddev.e_wallet.data.local.Transaction
import com.behzoddev.e_wallet.data.repository.LocalRepository
import com.behzoddev.e_wallet.di.BindModule.RepositoryBinds
import javax.inject.Inject

class UpdateTransaction @Inject constructor(
   @RepositoryBinds private val repository: LocalRepository
) {
    suspend fun updateTransaction(transaction: Transaction): Long {
        return repository.updateTransaction(transaction)
    }
}