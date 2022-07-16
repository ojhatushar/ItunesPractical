package com.encora.encoraitunespractical.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.encora.encoraitunespractical.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Tushar Ojha on 16-07-2022.
 */
@AndroidEntryPoint
class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}