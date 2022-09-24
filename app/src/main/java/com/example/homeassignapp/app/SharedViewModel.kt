package com.example.homeassignapp.app

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homeassignapp.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

private const val TAG = "svm"

class SharedViewModel : ViewModel() {

    init {
        getPhotoData()
    }

    private fun getPhotoData() {
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.photoData.getData()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, internet connection may not be available.", e)
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response.", e)
                return@launch
            }

            if (response.isSuccessful) response.body()?.let {
                Log.d(TAG, response.body().toString())
            }
        }
    }

    fun initSvm() {}
}