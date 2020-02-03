package com.example.watchusersandposts.Dagger.Modules

import com.example.watchusersandposts.Network.PlaceholderRepository
import com.example.watchusersandposts.Network.PlaceholderRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PlaceholderRepositoryImplModule {

    @Binds
    abstract fun bindsPlaceholderRepositoryImpl(placeholderRepositoryImpl: PlaceholderRepositoryImpl): PlaceholderRepository
}