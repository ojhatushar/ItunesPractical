package com.encora.encoraitunespractical.ui.fragments

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.encora.encoraitunespractical.R
import com.encora.encoraitunespractical.data.model.entities.MusicDataBean
import com.encora.encoraitunespractical.databinding.FragmentMusicDetailsBinding
import com.encora.encoraitunespractical.utils.Constants
import com.encora.encoraitunespractical.utils.ProgressUtils.drawableFromUrl
import com.encora.encoraitunespractical.utils.extensions.showSnackbar
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class MusicDetailsFragment : Fragment(), Player.Listener {

    private lateinit var binding: FragmentMusicDetailsBinding
    private lateinit var singleMusicData: MusicDataBean
    private lateinit var simpleExoplayer: SimpleExoPlayer
    private var playbackPosition: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMusicDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        singleMusicData = arguments?.getParcelable(Constants.MUSIC_DATA)!!
        binding.musicData = singleMusicData

        return binding.root
    }

    private val dataSourceFactory: DataSource.Factory by lazy {
        DefaultDataSourceFactory(requireActivity(), "exoplayer-sample")
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }

    private fun initializePlayer() {
        simpleExoplayer = SimpleExoPlayer.Builder(requireActivity()).build()
        singleMusicData.audioUrl?.let { preparePlayer(it) }

        binding.exoplayerView.player = simpleExoplayer
        simpleExoplayer.seekTo(playbackPosition)
        simpleExoplayer.playWhenReady = true
        simpleExoplayer.addListener(this)


    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        return ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
    }

    private fun preparePlayer(videoUrl: String) {
        val uri = Uri.parse(videoUrl)
        val mediaSource = buildMediaSource(uri)
        simpleExoplayer.prepare(mediaSource)
    }

    private fun releasePlayer() {
        playbackPosition = simpleExoplayer.currentPosition
        simpleExoplayer.release()
    }

    override fun onPlayerError(error: ExoPlaybackException) {
        binding.root.showSnackbar(error.localizedMessage, Snackbar.LENGTH_SHORT)
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {

        if (playbackState == Player.STATE_BUFFERING)
            binding.progressBar.visibility = View.VISIBLE
        else if (playbackState == Player.STATE_READY || playbackState == Player.STATE_ENDED)
            binding.progressBar.visibility = View.INVISIBLE
    }


}