package com.behzoddev.e_wallet.presentation.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.e_wallet.common.extensions.debug
import com.behzoddev.e_wallet.data.local.TransactionModel
import com.behzoddev.e_wallet.domain.interactor.InsertTransactionInteractor
import com.behzoddev.e_wallet.domain.interactor.UpdateTransactionInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val insertTransaction: InsertTransactionInteractor,
    private val updateTransaction: UpdateTransactionInteractor
)  : ViewModel() {

    fun insertTransaction(transactionModel: TransactionModel) = viewModelScope.launch {
        insertTransaction.invoke(transactionModel)
        debug { "insertTransaction() method is created" }
    }
    fun updateTransaction(transactionModel: TransactionModel) = viewModelScope.launch {
        updateTransaction.invoke(transactionModel)
    }
}