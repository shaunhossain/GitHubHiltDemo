package com.shaunhossain.githubhiltdemo.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.shaunhossain.githubhiltdemo.R
import com.shaunhossain.githubhiltdemo.model.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {


    private  val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repositoryList = viewModel.getRepositoryList()

        repositoryList.observe(viewLifecycleOwner, Observer { repositoryList ->
            when(repositoryList){
                is Resource.Loading-> {}
                is Resource.Success-> {}
                is Resource.Error-> {}
                is Resource.Exception-> {}
            }

        })
    }

}