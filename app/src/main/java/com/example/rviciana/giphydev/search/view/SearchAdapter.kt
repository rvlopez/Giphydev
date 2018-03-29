package com.example.rviciana.giphydev.search.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.rviciana.giphydev.R
import com.example.rviciana.giphydev.search.model.entities.Gif
import kotlinx.android.synthetic.main.activity_search_item.view.*

class SearchAdapter(private val dataList: MutableList<Gif>,
                    private val gifListener: GifListener): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_search_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(dataList[position], gifListener)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Gif, gifListener: GifListener) {
            val context = itemView.context
            val imageUrl = item.images.fixedHeight.url

            Glide.with(context).asGif().load(imageUrl).into(itemView.gif)
            itemView.setOnClickListener { gifListener.onGifClicked(item) }
        }
    }
}