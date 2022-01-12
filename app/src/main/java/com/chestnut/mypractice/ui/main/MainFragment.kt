package com.chestnut.mypractice.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.chestnut.mypractice.databinding.MainFragmentBinding
import com.chestnut.mypractice.util.getViewModelFactory

class MainFragment : Fragment() {

    companion object {
        val TAG = MainFragment::class.java.name + ".TAG"
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel> { getViewModelFactory() }
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: ArticleListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        setupView()
        setupLiveData()
        viewModel.fetchNews()
        return binding.root
    }

    private fun setupView() {
        adapter = ArticleListAdapter()
        binding.mainFragmentRecycler.adapter = adapter
    }

    private fun setupLiveData() {
        viewModel.newsLivedata.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}