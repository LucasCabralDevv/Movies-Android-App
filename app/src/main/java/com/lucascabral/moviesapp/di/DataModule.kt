package com.lucascabral.moviesapp.di

import com.lucascabral.moviesapp.data.api.DiscoverApi
import com.lucascabral.moviesapp.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun providesDiscoverApi(
        serviceProvider: ServiceProvider
    ) : DiscoverApi {
        return serviceProvider.createService(DiscoverApi::class.java)
    }
}