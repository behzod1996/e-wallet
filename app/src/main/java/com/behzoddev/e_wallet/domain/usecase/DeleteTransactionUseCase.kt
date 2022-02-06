package com.behzoddev.e_wallet.domain.usecase

import com.behzoddev.e_wallet.data.local.Transaction
import com.behzoddev.e_wallet.data.repository.LocalRepository
import com.behzoddev.e_wallet.di.BindModule.RepositoryBinds
import javax.inject.Inject

class DeleteTransactionUseCase @Inject constructor(
    @RepositoryBinds private val repository: LocalRepository
) {
    suspend fun deleteTransaction(transaction: Transaction): Int {
        return repository.deleteTransaction(transaction)
    }
}