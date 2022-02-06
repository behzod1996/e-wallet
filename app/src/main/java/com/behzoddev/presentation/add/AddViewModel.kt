package com.behzoddev.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.e_wallet.data.local.Transaction
import com.behzoddev.e_wallet.domain.usecase.InsertTransactionUseCase
import com.behzoddev.e_wallet.domain.usecase.UpdateTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val insertTransaction: InsertTransactionUseCase,
    private val updateTransaction: UpdateTransactionUseCase
)  : ViewModel() {

    fun insertTransaction(transaction: Transaction) = viewModelScope.launch {
        insertTransaction.insertTransaction(transaction)
    }
    fun updateTransaction(transaction: Transaction) = viewModelScope.launch {
        updateTransaction.updateTransaction(transaction)
    }
}