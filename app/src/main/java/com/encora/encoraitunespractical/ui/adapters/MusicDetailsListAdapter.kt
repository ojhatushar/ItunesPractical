package com.encora.encoraitunespractical.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.encora.encoraitunespractical.data.model.obj.xmlobj.Entry
import com.encora.encoraitunespractical.data.model.obj.xmlobj.Feed
import com.encora.encoraitunespractical.databinding.ItemSongBinding


class MusicDetailsListAdapter :
    RecyclerView.Adapter<MusicDetailsListAdapter.MyViewHolder>() {


    var musicDetailsList = ArrayList<Entry>()

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

        //Glide for showing images
        /* Glide.with(itemBinding.root.context)
             .load(subCategoryDetailsList[position].detailImage)
             .placeholder(R.mipmap.ic_launcher) // Uri of the picture
             .into(itemBinding.ivImageRestaurant)*/

        itemBinding.executePendingBindings()
    }

    override fun getItemCount() = musicDetailsList.size

    fun setMusicDataToView(musicDetailsData: List<Entry>?) {

        this.musicDetailsList.apply {
            clear()
            if (musicDetailsData != null) {
                addAll(musicDetailsData)
            }
        }
    }


    inner class MyViewHolder(val itemSongBinding: ItemSongBinding) :
        RecyclerView.ViewHolder(itemSongBinding.root)
}