package com.behzoddev.e_wallet.di

import com.behzoddev.e_wallet.data.local.LocalDataSource
import com.behzoddev.e_wallet.data.local.LocalDataSourceImpl
import com.behzoddev.e_wallet.data.repository.LocalRepository
import com.behzoddev.e_wallet.data.repository.LocalRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@Singleton
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