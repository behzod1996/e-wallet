package com.behzoddev.e_wallet.domain.usecase

import com.behzoddev.e_wallet.data.local.Transaction
import com.behzoddev.e_wallet.data.repository.LocalRepository
import com.behzoddev.e_wallet.di.BindModule.RepositoryBinds
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTransactionsUseCase @Inject constructor(
    @RepositoryBinds private val repository: LocalRepository
) {
    fun getAllTransactions(): Flow<List<Transaction>> {
        return repository.getAllTransactions()
    }
}