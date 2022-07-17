package com.encora.encoraitunespractical.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.encora.encoraitunespractical.R
import com.encora.encoraitunespractical.data.model.entities.MusicDataBean
import com.encora.encoraitunespractical.databinding.FragmentMusicListBinding
import com.encora.encoraitunespractical.ui.adapters.MusicDetailsListAdapter
import com.encora.encoraitunespractical.ui.interfaces.OnListCallback
import com.encora.encoraitunespractical.utils.Constants.MUSIC_DATA
import com.encora.encoraitunespractical.utils.extensions.makeGone
import com.encora.encoraitunespractical.utils.extensions.makeVisible
import com.encora.encoraitunespractical.utils.statusUtils.Status
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [MusicListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class MusicListFragment : Fragment(),OnListCallback {
    private lateinit var binding: FragmentMusicListBinding
    private val viewModel by activityViewModels<MusicListViewModel>()
    private lateinit var musicDetailsListAdapter: MusicDetailsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMusicListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        showDataOnUi()
        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        musicDetailsListAdapter = MusicDetailsListAdapter(this)
        binding.rvMusicList.adapter = musicDetailsListAdapter

    }


    private fun showDataOnUi() {
        viewModel.getMusicDetails().observe(requireActivity()) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.makeGone()

                        resource.data?.let { musicDetailsList ->

                            if (musicDetailsList.isNotEmpty()) {
                                setMusicData(musicDetailsList)
                            }

                        }
                    }
                    Status.ERROR -> {
                        binding.progressBar.makeGone()
                        Toast.makeText(activity, resource.message, Toast.LENGTH_LONG).show()
                        Log.d("error", "" + resource.message)

                    }
                    Status.LOADING -> {
                        binding.progressBar.makeVisible()
                    }
                }
            }
        }
    }

    private fun setMusicData(musicDetailsList: List<MusicDataBean>) {
        musicDetailsListAdapter.apply {
            setMusicDataToView(musicDetailsList)
        }
    }

    override fun onClick(musicData: MusicDataBean) {
        var bundle = Bundle()
        bundle.putParcelable(MUSIC_DATA,musicData)
        findNavController().navigate(
            R.id.action_FirstFragment_to_SecondFragment,
            bundle
        )
    }

}