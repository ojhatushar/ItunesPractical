package com.encora.encoraitunespractical.ui.fragments

import androidx.lifecycle.ViewModel
import com.encora.encoraitunespractical.data.repositories.MusicDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//ViewModel for business logic
@HiltViewModel
class MusicListViewModel @Inject constructor(
    private val musicDetailsRepository: MusicDetailsRepository
) : ViewModel() {

    //get Music Details from api
    fun getMusicDetails() =
        musicDetailsRepository.getMusicDetails()


}