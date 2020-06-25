package com.james.midterm.publish

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.james.midterm.R
import com.james.midterm.databinding.FragmentPublishBinding

class PublishFragment : DialogFragment() {


    private lateinit var viewModel: PublishViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentPublishBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_publish, container, false)
        binding.lifecycleOwner = this

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        viewModel = ViewModelProvider(this).get(PublishViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.title.observe(viewLifecycleOwner, Observer {
            it?.let{
                Log.d("JJ", it)
            }

        })

        viewModel.sendSuccess.observe(viewLifecycleOwner, Observer {
            if(it){
                findNavController().navigate(PublishFragmentDirections.actionGlobalHomeFragment())
                viewModel.navigateComplete()
            }
        })


        return binding.root
    }

}
