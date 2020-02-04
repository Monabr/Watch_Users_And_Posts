package com.example.watchusersandposts.dagger

import com.example.watchusersandposts.dagger.Modules.MapViewModelsModule
import com.example.watchusersandposts.dagger.Modules.PlaceholderApiModule
import com.example.watchusersandposts.dagger.Modules.PlaceholderRepositoryImplModule
import com.example.watchusersandposts.dagger.Modules.ViewModelsModule
import com.example.watchusersandposts.views.StartFragment
import com.example.watchusersandposts.views.UserPostsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelsModule::class, MapViewModelsModule::class, PlaceholderApiModule::class, PlaceholderRepositoryImplModule::class])
interface StartComponent {

    fun inject(startFragment: StartFragment)

    fun inject(userPostsFragment: UserPostsFragment)
}