package com.deedeveloper.recyview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.photos_fragment.*

class PhotosFragment : Fragment() {

    private lateinit var factory: PhotosViewModelFactory
    private lateinit var viewModel: PhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = PhotosApi()
        val repository = PhotosRepository(api)
        factory = PhotosViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(PhotosViewModel::class.java)
        viewModel.getPhotos()
        viewModel.photos.observe(viewLifecycleOwner, Observer {photos ->
            recycler_view_photos.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = PhotosAdapter(photos)
            }
        })
    }
}