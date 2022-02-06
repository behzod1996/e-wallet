package com.behzoddev.e_wallet.domain.usecase

import com.behzoddev.e_wallet.data.local.Transaction
import com.behzoddev.e_wallet.data.repository.LocalRepository
import com.behzoddev.e_wallet.di.BindModule.RepositoryBinds
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetByIdUseCase @Inject constructor(
    @RepositoryBinds private val repository: LocalRepository
) {
    fun getById(transactionId: Int): Flow<Transaction> {
        return repository.getById(transactionId)
    }
}