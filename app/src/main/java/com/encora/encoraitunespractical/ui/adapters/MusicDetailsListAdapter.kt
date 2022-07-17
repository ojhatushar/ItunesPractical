package com.encora.encoraitunespractical.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.encora.encoraitunespractical.data.model.entities.MusicDataBean
import com.encora.encoraitunespractical.databinding.ItemSongBinding
import com.encora.encoraitunespractical.ui.interfaces.OnListCallback


class MusicDetailsListAdapter(var onListClickCallback:OnListCallback) :
    RecyclerView.Adapter<MusicDetailsListAdapter.MyViewHolder>() {


    var musicDetailsList = ArrayList<MusicDataBean>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MusicDetailsListAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSongBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MusicDetailsListAdapter.MyViewHolder,
        position: Int,
    ) {
        val itemBinding = holder.itemSongBinding

        //passing data using databinding for showing data through xml
        itemBinding.musicData = musicDetailsList[position]

        itemBinding.root.setOnClickListener {
            onListClickCallback.onClick(musicDetailsList[position])
        }

        itemBinding.executePendingBindings()
    }

    override fun getItemCount() = musicDetailsList.size

    fun setMusicDataToView(musicDetailsData: List<MusicDataBean>?) {

        this.musicDetailsList.apply {
            clear()
            if (musicDetailsData != null) {
                addAll(musicDetailsData)
                notifyDataSetChanged()
            }
        }
    }


    inner class MyViewHolder(val itemSongBinding: ItemSongBinding) :
        RecyclerView.ViewHolder(itemSongBinding.root)
}