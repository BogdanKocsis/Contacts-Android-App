package com.example.contacts.di

import com.example.contacts.navigation.NavigationManager
import com.example.contacts.repository.ContactsRepository
import com.example.contacts.repository.remoteDataSource.ContactRemoteDataSource
import com.example.contacts.repository.remoteDataSource.ContactsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesNavigationManager(): NavigationManager = NavigationManager()

    @Provides
    @Singleton
    fun providesContactsApi(): ContactsApi {
        return Retrofit.Builder()
            .baseUrl(ContactsApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    fun providesContactsRemoteDataSource(api: ContactsApi): ContactRemoteDataSource =
        ContactRemoteDataSource(api)

    @Provides
    @Singleton
    fun providesContactsRepository(contactRemoteDataSource: ContactRemoteDataSource): ContactsRepository =
        ContactsRepository(contactRemoteDataSource)
}