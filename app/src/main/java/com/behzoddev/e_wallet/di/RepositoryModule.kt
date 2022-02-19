package com.behzoddev.e_wallet.di

import com.behzoddev.e_wallet.data.repository.TransactionRepositoryImpl
import com.behzoddev.e_wallet.domain.repository.TransactionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providesRepositoryInstance(
        transactionRepositoryImpl: TransactionRepositoryImpl
    ): TransactionRepository
}