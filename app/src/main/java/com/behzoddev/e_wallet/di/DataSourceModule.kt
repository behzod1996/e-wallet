package com.behzoddev.e_wallet.di

import com.behzoddev.e_wallet.data.datasource.TransactionDataSource
import com.behzoddev.e_wallet.data.datasource.TransactionDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    internal abstract fun provideTransactionDataSourceInstance(
        transactionDataSource: TransactionDataSourceImpl
    ) : TransactionDataSource
}