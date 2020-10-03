package com.deedeveloper.recyview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class PhotosViewModel(private val repository: PhotosRepository) : ViewModel() {

    private lateinit var job: Job

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>>
        get() = _photos

     fun getPhotos() {
        job =Coroutines.ioThenMain(
                {repository.getPhotos()},
                { _photos.value = it}
        )
    }
    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}