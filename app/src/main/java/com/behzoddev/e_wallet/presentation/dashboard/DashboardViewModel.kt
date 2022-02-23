package com.behzoddev.e_wallet.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behzoddev.e_wallet.domain.interactor.FetchAllTransactionsInteractor
import com.behzoddev.e_wallet.utils.states.TransactionViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val fetchAllTransactionsInteractor: FetchAllTransactionsInteractor
) : ViewModel() {

    private var _dashboardState =
        MutableStateFlow<TransactionViewState>(TransactionViewState.Loading)
    val dashboardState: StateFlow<TransactionViewState> = _dashboardState

    init {
        viewModelScope.launch {
            fetchAllTransactionsInteractor.invoke().collect {
                if (it.isNullOrEmpty()) {
                    _dashboardState.value = TransactionViewState.Empty
                } else {
                    _dashboardState.value = TransactionViewState.Success(it)
                }
            }
        }
    }
}