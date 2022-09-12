package com.example.myapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.domain.common.BAD_REQUEST
import com.example.domain.common.HAVE_NOT_INTERNET
import com.example.domain.model.ProfileRequestBody
import com.example.myapplication.R
import com.example.myapplication.SurfApp
import com.example.myapplication.presentation.main.BottomNavigationFragment
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

        val profileRequestBody = ProfileRequestBody("+79876543219", "qwerty")
        val profileInfo = mainViewModel.getProfileInfo(profileRequestBody)

        when (profileInfo.message) {
            null -> {
                Log.v("my_data", profileInfo.data.toString())
                mainViewModel.insertProfileInfo(profileInfo.data!!)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, BottomNavigationFragment.newInstance())
                    .commitNow()
            }
            BAD_REQUEST -> {
//                errorMessage.value = "Логин или пароль введен неправильно"
            }
            HAVE_NOT_INTERNET -> {
//                errorMessage.value = "Отсутствует соединение с интернетом"
            }
        }

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.main_container, BottomNavigationFragment.newInstance())
//                .commitNow()
//        }
    }
}
