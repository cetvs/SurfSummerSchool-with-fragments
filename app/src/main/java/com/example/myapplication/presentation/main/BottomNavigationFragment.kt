package com.example.myapplication.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.favorite.FavoriteFragment
import com.example.myapplication.presentation.home.HomeFragment
import com.example.myapplication.presentation.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationFragment : Fragment() {

    companion object {
        fun newInstance() = BottomNavigationFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.bottom_navigation_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val buttonNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.page_home -> {
                    childFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.bottom_navigation_container, HomeFragment())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_favorite -> {
                    childFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.bottom_navigation_container, FavoriteFragment())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.page_profile-> {
                    childFragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.bottom_navigation_container, ProfileFragment())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
        buttonNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        super.onViewCreated(view, savedInstanceState)
    }

}