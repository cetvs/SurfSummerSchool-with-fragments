package com.example.myapplication.presentation.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.common.SpacesItemDecoration
import com.example.myapplication.presentation.home.search.SearchFragment

class HomeFragment : Fragment() {
    lateinit var homeRecyclerAdapter: HomeRecyclerAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var mainViewModel: MainViewModel
    lateinit var thisContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        thisContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.home_rv)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val token = mainViewModel.getLocalProfileInfo()?.token

        homeRecyclerAdapter = HomeRecyclerAdapter(listOf(), mainViewModel)
        mainViewModel.liveData.observe(viewLifecycleOwner) {
            when {
                it.isLoading -> parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.bottom_navigation_container, LoadingFragment())
                    .commit()
                else -> {
                    Log.v("live", it.value.toString())
                    homeRecyclerAdapter.setData(it.value)
                }
            }
        }
        mainViewModel.getPictureInfo(token!!)
        recyclerView?.adapter = homeRecyclerAdapter
        recyclerView?.layoutManager = GridLayoutManager(thisContext, 2)
        recyclerView.addItemDecoration(SpacesItemDecoration(10))

        val searchImageView = view.findViewById<ImageView>(R.id.search_iv)
        searchImageView.setOnClickListener(this.onCreateSearchViewListener())

        val swipeContainer = view.findViewById<SwipeRefreshLayout>(R.id.swipe_container)
        swipeContainer.setOnRefreshListener {
            mainViewModel.getPictureInfo(token)
            swipeContainer.isRefreshing = false
        }
    }

    private fun onCreateSearchViewListener(): View.OnClickListener = View.OnClickListener {
        parentFragmentManager
            .beginTransaction()
            .addToBackStack("home_fragment")
            .replace(R.id.bottom_navigation_container, SearchFragment())
            .commit()
    }
}