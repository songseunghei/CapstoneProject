package com.example.nongglenonggle.presentation.di

import com.example.nongglenonggle.data.ImageRepositoryImpl
import com.example.nongglenonggle.domain.repository.AddressRepository
import com.example.nongglenonggle.domain.repository.ImageRepository
import com.example.nongglenonggle.domain.usecase.UpdateAddressUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAddressRepository(): AddressRepository = AddressRepository()

    @Provides
    @Singleton
    fun provideUpdateAddressUseCase(repository: AddressRepository): UpdateAddressUseCase = UpdateAddressUseCase(repository)

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage{
        return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth():FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideImageRepository(
        firebaseStorage: FirebaseStorage,
        firebaseAuth: FirebaseAuth
    ):ImageRepository{
        return ImageRepositoryImpl(firebaseStorage,firebaseAuth)
    }

}
