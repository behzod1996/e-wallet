package com.behzoddev.e_wallet.di

import com.behzoddev.e_wallet.domain.interactor.FetchAllTransactionsInteractor
import com.behzoddev.e_wallet.domain.interactor.FetchAllTransactionsInteractorImpl
import com.behzoddev.e_wallet.domain.interactor.InsertTransactionInteractor
import com.behzoddev.e_wallet.domain.interactor.InsertTransactionInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {

    @Binds
    @Singleton
    internal abstract fun providesInsertInteractor(
        insertTransactionInteractorImpl: InsertTransactionInteractorImpl
    ): InsertTransactionInteractor

    @Binds
    @Singleton
    internal abstract fun providesFetchAllTransactionInteractor(
        fetchAllTransactionsInteractorImpl: FetchAllTransactionsInteractorImpl
    ) : FetchAllTransactionsInteractor
}