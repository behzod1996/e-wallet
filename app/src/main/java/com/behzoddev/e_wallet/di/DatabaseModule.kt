package com.behzoddev.e_wallet.di

import android.app.Application
import com.behzoddev.e_wallet.data.local.TransactionDao
import com.behzoddev.e_wallet.data.local.TransactionDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): TransactionDatabase {
        return TransactionDatabase.invoke(application.applicationContext)
    }

    @Provides
    @Singleton
    fun provideDaoInstance(transactionDatabase: TransactionDatabase): TransactionDao {
        return transactionDatabase.getDao()
    }

}