package com.behzoddev.e_wallet.di

import com.behzoddev.e_wallet.domain.interactor.*
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

    @Binds
    @Singleton
    internal abstract fun providesUpdateTransactionInteractor(
        updateInteractor: UpdateTransactionInteractorImpl
    ) : UpdateTransactionInteractor

    @Binds
    @Singleton
    internal abstract fun providesDeleteTransactionInteractor(
        deleteTransactionInteractorImpl: DeleteTransactionInteractorImpl
    ) : DeleteTransactionInteractor
}