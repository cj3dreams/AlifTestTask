package com.cj3dreams.aliftesttask.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.cj3dreams.aliftesttask.R
import com.cj3dreams.aliftesttask.presentation.main.home.HomeFragment
import com.cj3dreams.aliftesttask.presentation.main.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frgView, HomeFragment())
            .commit()

    }
}