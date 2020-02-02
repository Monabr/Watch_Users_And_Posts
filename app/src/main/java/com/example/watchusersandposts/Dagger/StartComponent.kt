package com.example.watchusersandposts.Dagger

import com.example.watchusersandposts.Dagger.Modules.PlaceholderApiModule
import com.example.watchusersandposts.Dagger.Modules.ViewModelsModule
import com.example.watchusersandposts.Dagger.Modules.MapViewModelsModule
import com.example.watchusersandposts.Views.StartFragment
import com.example.watchusersandposts.Views.UserPostsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [ViewModelsModule::class, MapViewModelsModule::class, PlaceholderApiModule::class])
interface StartComponent {

   fun inject(startFragment: StartFragment)

   fun inject(userPostsFragment: UserPostsFragment)
}