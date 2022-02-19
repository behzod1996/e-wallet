package com.behzoddev.e_wallet.domain.interactor

import com.behzoddev.e_wallet.common.coroutine.DispatcherProvider
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchByIdInteractorImpl @Inject constructor(
    private val transactionRepository: TransactionRepository,
    private val dispatcher: DispatcherProvider
) : FetchByIdInteractor {
    override fun invoke(transactionId: Int): Flow<TransactionModel> {
        return transactionRepository.getById(transactionId).flowOn(dispatcher.io)
    }
}