package com.example.netflix.comingSoon

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.IShareMovie
import com.example.netflix.image.ImageDataClass
import com.example.netflix.R

class RecyclerViewComingSoon(
    private val itemListDC: ArrayList<ImageDataClass>,
    val shareMovie : IShareMovie
) :
    RecyclerView.Adapter<RecyclerViewComingSoon.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivHomeComing = itemView.findViewById<ImageView>(R.id.iv_home)
        val ivLikeComing = itemView.findViewById<ImageView>(R.id.iv_like)
        val tvHomeComing = itemView.findViewById<TextView>(R.id.tv_home)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivHomeComing.setImageResource(itemListDC[position].imageMovie)
        holder.tvHomeComing.text = itemListDC[position].movieName
        holder.ivLikeComing.setImageResource(R.drawable.share)
        holder.ivLikeComing.setOnClickListener {
            shareMovie.onClickComingSoon(position)
            Log.d(TAG, "onBindViewHolder: ncdfiomwvhcnierovnx,ierv")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemListDC.size
    }

}
