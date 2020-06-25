package com.james.midterm.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.james.midterm.R
import com.james.midterm.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentHomeBinding = DataBindingUtil
            .inflate(inflater,
                R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel

        val adapter = HomeAdapter()
        binding.mainRecycler.adapter = adapter

        viewModel.navigateToPublish.observe(viewLifecycleOwner, Observer{
            if(it){
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPublishFragment())
                viewModel.navigateComplete()
            }
        })

        viewModel.posts.observe(viewLifecycleOwner, Observer {
            if(it == null){
                Log.d("JJ", "this is null")
            }else if(it.isEmpty()){
                Log.d("JJ", "empty list $it")
            }else{
                Log.d("JJ", "list $it")
            }
        })

        return binding.root
    }

}
