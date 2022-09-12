package com.example.myapplication.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.favorite.FavoriteFragment

class LoadingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.loading_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mainViewModel.liveData.observe(viewLifecycleOwner) {
            when {
                !it.isLoading -> parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.bottom_navigation_container, HomeFragment())
                    .commit()
            }
        }
    }

}