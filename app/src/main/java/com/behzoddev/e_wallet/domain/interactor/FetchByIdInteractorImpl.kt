package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchByIdInteractorImpl @Inject constructor(
    private val transactionRepository: TransactionRepository
) : FetchByIdInteractor {
    override fun invoke(transactionId: Int): Flow<TransactionModel> {
        return transactionRepository.getById(transactionId)
    }
}