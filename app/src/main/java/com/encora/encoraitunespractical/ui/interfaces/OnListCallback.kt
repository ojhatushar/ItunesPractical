package com.encora.encoraitunespractical.ui.interfaces

import com.encora.encoraitunespractical.data.model.entities.MusicDataBean

/**
 * Created by Tushar Ojha on 17-07-2022.
 */
interface OnListCallback {
    fun onClick(musicData: MusicDataBean)
}