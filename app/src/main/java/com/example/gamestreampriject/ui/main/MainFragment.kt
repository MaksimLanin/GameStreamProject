package com.example.gamestreampriject.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.gamestreampriject.R
import com.example.gamestreampriject.databinding.FragmentMainBinding
import com.example.gamestreampriject.ui.base.viewBinding
import com.example.gamestreampriject.viewmodel.main.MainScreenViewModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding { FragmentMainBinding.bind(it) }
    private val viewModel by viewModels<MainScreenViewModel>()

    private val adapter = MainScreenAdapter()


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.adapter = adapter

            viewModel.data.observe(viewLifecycleOwner, Observer {
                adapter.items = it
            })
        }
    }
}