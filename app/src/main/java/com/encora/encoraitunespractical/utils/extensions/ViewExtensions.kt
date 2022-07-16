package com.encora.encoraitunespractical.utils.extensions


import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.encora.encoraitunespractical.utils.Event
import com.google.android.material.snackbar.Snackbar
import java.io.IOException

fun View.liveSnackBar(
    lifecycleOwner: LifecycleOwner,
    snackbarEvent: LiveData<Event<Any?>>,
    timeLength: Int
) {

    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let {
            when (it) {
                is Int -> showSnackbar(context.getString(it),timeLength)
                is String -> showSnackbar(it,timeLength)
            }

        }
    })
}

fun View.showSnackbar(snackbarText: String, timeLength: Int) {
    Snackbar.make(this, snackbarText, timeLength).show()
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}


class NoInternetException(message: String) : IOException(message)
