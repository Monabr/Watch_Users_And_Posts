package com.example.watchusersandposts.Dagger.Modules

import androidx.lifecycle.ViewModel
import com.example.watchusersandposts.Factory.AssistedSavedStateViewModelFactory
import dagger.Module
import dagger.multibindings.Multibinds

@Module
abstract class MapViewModelsModule {
    @Multibinds
    abstract fun viewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>

    @Multibinds
    abstract fun assistedViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards AssistedSavedStateViewModelFactory<out ViewModel>>
}