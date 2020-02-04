package com.example.watchusersandposts.dagger.Modules

import com.example.watchusersandposts.network.PlaceholderRepository
import com.example.watchusersandposts.network.PlaceholderRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PlaceholderRepositoryImplModule {

    @Binds
    abstract fun bindsPlaceholderRepositoryImpl(placeholderRepositoryImpl: PlaceholderRepositoryImpl): PlaceholderRepository
}