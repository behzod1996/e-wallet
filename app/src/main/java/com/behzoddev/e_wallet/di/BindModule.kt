package com.behzoddev.e_wallet.di

import com.behzoddev.e_wallet.data.datasource.LocalDataSource
import com.behzoddev.e_wallet.data.datasource.LocalDataSourceImpl
import com.behzoddev.e_wallet.data.repository.LocalRepository
import com.behzoddev.e_wallet.data.repository.LocalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Binds
    @DataSourceBinds
    @Singleton
    abstract fun provideDatasource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    @RepositoryBinds
    @Singleton
    abstract fun provideRepository(localRepositoryImpl: LocalRepositoryImpl): LocalRepository

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DataSourceBinds

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RepositoryBinds
}