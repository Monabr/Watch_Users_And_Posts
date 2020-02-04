package com.example.watchusersandposts.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.watchusersandposts.adapters.UserAdapter
import com.example.watchusersandposts.dagger.DaggerStartComponent
import com.example.watchusersandposts.R
import com.example.watchusersandposts.viewModels.StartViewModel
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : BaseFragment() {

    private val viewModel: StartViewModel by viewModels()

    companion object {
        fun newInstance() = StartFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerStartComponent.create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.users.observe(this)  {
            fragment_start_rv_users_list.adapter = UserAdapter(it)
            fragment_start_rv_users_list.layoutManager = LinearLayoutManager(context)
            fragment_start_pb_load.visibility = View.GONE
        }

    }

}
