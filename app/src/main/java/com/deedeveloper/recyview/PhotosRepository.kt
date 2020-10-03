package com.deedeveloper.recyview

class PhotosRepository(
    private val api: PhotosApi
) : SafeApiRequest() {
    suspend fun getPhotos() = apiRequest { api.getPhotos() }
}