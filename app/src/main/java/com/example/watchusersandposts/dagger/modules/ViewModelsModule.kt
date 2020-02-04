package com.example.watchusersandposts.dagger.modules

import androidx.lifecycle.ViewModel
import com.example.watchusersandposts.factory.AssistedSavedStateViewModelFactory
import com.example.watchusersandposts.dagger.ViewModelKey
import com.example.watchusersandposts.viewModels.StartViewModel
import com.example.watchusersandposts.viewModels.UserPostsViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@AssistedModule
@Module(includes = [AssistedInject_ViewModelsModule::class])
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    abstract fun bindsMainViewModel(vm: StartViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserPostsViewModel::class)
    abstract fun bindVMFactory(factory: UserPostsViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}