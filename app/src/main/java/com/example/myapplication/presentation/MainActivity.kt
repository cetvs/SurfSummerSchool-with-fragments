package com.example.myapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.SurfApp
import com.example.myapplication.presentation.main.MainFragment
import javax.inject.Inject

class MainActivity() : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        (applicationContext as SurfApp).appComponent.inject(this)
        mainViewModel = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)
//        val textView = findViewById<TextView>(R.id.text_view)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
