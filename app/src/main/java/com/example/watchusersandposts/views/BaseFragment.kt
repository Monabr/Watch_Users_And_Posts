package com.example.watchusersandposts.views

import androidx.fragment.app.Fragment
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import com.mlykotom.connectingthedots.di.InjectingSavedStateViewModelFactory
import javax.inject.Inject

abstract class BaseFragment : Fragment(), HasDefaultViewModelProviderFactory {

    @Inject
    lateinit var defaultViewModelFactory: InjectingSavedStateViewModelFactory

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        defaultViewModelFactory.create(this, arguments)
}
