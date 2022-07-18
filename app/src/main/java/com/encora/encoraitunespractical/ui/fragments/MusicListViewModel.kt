package com.encora.encoraitunespractical.ui.fragments

import androidx.lifecycle.ViewModel
import com.encora.encoraitunespractical.data.repositories.MusicDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//ViewModel for business logic
@HiltViewModel
class MusicListViewModel @Inject constructor(
    private val musicDetailsRepository: MusicDetailsRepository,
) : ViewModel() {

    /**
     * Here, we only need to return the LiveData<Resource<T>>, as logic required for this practical
     * is inbuilt in performGetOperation method, that uses Single Source of Truth(Database).
     * As this application will grow, more business logic can be placed here.
     * And as this is a GET method, no other logic required here for now.
     */
    fun getMusicDetails() = musicDetailsRepository.getMusicDetails()
}