package com.example.hc.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hc.R
import com.example.hc.viewmodel.AllUsersViewModel


class MainActivity : AppCompatActivity() {

    private var allUsersViewModel: AllUsersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        allUsersViewModel =
            ViewModelProviders.of(this).get(AllUsersViewModel::class.java)
        getAllUsers()

    }

    private fun getAllUsers() {
        allUsersViewModel?.getAllUsers()?.observe(this, Observer {

            Log.d("User list size ", "" + it.size)

        })

    }
}
