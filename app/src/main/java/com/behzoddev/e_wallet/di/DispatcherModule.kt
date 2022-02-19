package com.behzoddev.e_wallet.di

import com.behzoddev.e_wallet.common.coroutine.DispatcherProvider
import com.behzoddev.e_wallet.common.coroutine.DispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @Singleton
    fun providesDispatchers(): DispatcherProvider {
        return DispatcherProviderImpl()
    }
}