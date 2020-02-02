package com.example.watchusersandposts.Dagger.Modules

import androidx.lifecycle.ViewModel
import com.example.watchusersandposts.Factory.AssistedSavedStateViewModelFactory
import com.example.watchusersandposts.Dagger.ViewModelKey
import com.example.watchusersandposts.ViewModels.StartViewModel
import com.example.watchusersandposts.ViewModels.UserPostsViewModel
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