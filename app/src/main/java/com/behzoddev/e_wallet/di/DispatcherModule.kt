package com.behzoddev.e_wallet.di

import com.behzoddev.e_wallet.common.coroutine.DispatcherProvider
import com.behzoddev.e_wallet.common.coroutine.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    internal abstract fun providesDispatchers(
        dispatcherProviderImpl: DispatcherProviderImpl
    ): DispatcherProvider
}