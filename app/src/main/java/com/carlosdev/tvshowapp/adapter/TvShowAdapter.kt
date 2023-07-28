package com.carlosdev.tvshowapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.carlosdev.tvshowapp.databinding.TvShowLayoutAdapterBinding
import com.carlosdev.tvshowapp.model.TvShowItem

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: TvShowLayoutAdapterBinding):
        RecyclerView.ViewHolder(binding.root) {

    }

    private val diffcalback = object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
          return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
           return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffcalback)
    var tvShowList: List<TvShowItem>
    get() = differ.currentList
    set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(TvShowLayoutAdapterBinding.inflate(
           LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShowList[position]

        holder.binding.apply {
                    textView.text = currentTvShow.name
            imageView.load(currentTvShow.image.original) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = tvShowList.size

}
