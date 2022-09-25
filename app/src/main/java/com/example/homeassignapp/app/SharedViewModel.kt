package com.example.homeassignapp.app

import android.util.Log
import androidx.lifecycle.*
import com.example.homeassignapp.retrofit.PhotoItem
import com.example.homeassignapp.retrofit.PhotoData
import com.example.homeassignapp.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

private const val TAG = "svm"

class SharedViewModel : ViewModel() {

    private val _photoData = MutableLiveData<PhotoData?>(null)

    val photoList: LiveData<List<PhotoItem>?> = Transformations.map(_photoData) { data ->
        data?.photos?.photo
    }

    private val _photoItem = MutableLiveData<PhotoItem>()
    val photoItem: LiveData<PhotoItem> get() = _photoItem

    init {
        initPhotoData()
    }

    fun setPhotoItem(photo: PhotoItem) {
        _photoItem.value = photo
    }

    private fun initPhotoData() {
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
                _photoData.value = response.body()
            }
        }
    }
}