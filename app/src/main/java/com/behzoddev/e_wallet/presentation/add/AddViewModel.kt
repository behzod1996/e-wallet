package com.behzoddev.e_wallet.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.e_wallet.data.local.TransactionModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val insertTransaction: InsertTransactionUseCase,
    private val updateTransaction: UpdateTransactionUseCase
)  : ViewModel() {

    fun insertTransaction(transactionModel: TransactionModel) = viewModelScope.launch {
        insertTransaction.insertTransaction(transactionModel)
    }
    fun updateTransaction(transactionModel: TransactionModel) = viewModelScope.launch {
        updateTransaction.updateTransaction(transactionModel)
    }
}