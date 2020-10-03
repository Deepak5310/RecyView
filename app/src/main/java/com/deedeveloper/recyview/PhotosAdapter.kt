package com.deedeveloper.recyview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.deedeveloper.recyview.databinding.RecyclerviewPhotosBinding

class PhotosAdapter(
    private val photos: List<Photo>
) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    override fun getItemCount() = photos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder =
        PhotosViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_photos, parent, false
            )
        )

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.recyclerviewPhotosBinding.photo = photos[position]
    }

    inner class PhotosViewHolder(
        val recyclerviewPhotosBinding: RecyclerviewPhotosBinding
    ) : RecyclerView.ViewHolder(recyclerviewPhotosBinding.root)
}