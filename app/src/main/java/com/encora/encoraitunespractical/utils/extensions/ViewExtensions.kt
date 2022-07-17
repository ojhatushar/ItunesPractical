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

fun Entry.convertToSongsBean() = MusicDataBean(
    title = this.title,
    name = this.name,
    price = this.price,
    artist = this.artist,
    duration = this.link?.duration?.toInt(),
    imageUrl = this.image,
    audioUrl = this.link?.href,
    releaseDate = this.releaseDate?.rdate,
    rights = this.rights,
    collectionName = this.collection?.collectionName
)
class NoInternetException(message: String) : IOException(message)
