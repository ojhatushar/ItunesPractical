package com.encora.encoraitunespractical.utils.extensions


import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.encora.encoraitunespractical.data.model.entities.MusicDataBean
import com.encora.encoraitunespractical.data.model.responseModel.Entry
import com.encora.encoraitunespractical.utils.Event
import com.google.android.material.snackbar.Snackbar
import java.io.IOException

fun View.showSnackbar(snackbarText: String, timeLength: Int) {
    Snackbar.make(this, snackbarText, timeLength).show()
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}
class NoInternetException(message: String) : IOException(message)
