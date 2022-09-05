package com.example.myapplication.presentation.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {
    lateinit var customRecyclerAdapter :CustomRecyclerAdapter
    lateinit var recyclerView : RecyclerView

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val buttonNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        buttonNavigationView.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.page_2 -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        recyclerView = view?.findViewById(R.id.main_rv)!!
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//        customRecyclerAdapter = CustomRecyclerAdapter(viewModel.getExampleMovie())
//        recyclerView.adapter = customRecyclerAdapter
    }

}