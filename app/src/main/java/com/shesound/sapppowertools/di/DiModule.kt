package com.shesound.sapppowertools.di


import com.shesound.sapppowertools.data.repository.ServiceRepositoryImpl
import com.shesound.sapppowertools.data.repository.SoundRepositoryImpl
import com.shesound.sapppowertools.domain.repository.ServiceRepository
import com.shesound.sapppowertools.domain.repository.SoundRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {

    @Binds
    @Singleton
    abstract fun bindSoundRepository(repository: SoundRepositoryImpl): SoundRepository

    @Binds
    @Singleton
    abstract fun bindService(service: ServiceRepositoryImpl): ServiceRepository

}