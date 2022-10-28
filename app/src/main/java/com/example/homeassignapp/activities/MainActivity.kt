package com.example.homeassignapp.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.homeassignapp.R
import com.example.homeassignapp.viewmodels.SharedViewModel


class MainActivity : AppCompatActivity() {

    private val svm: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        svm.setListFragTitle()
        super.onBackPressed()
    }
}