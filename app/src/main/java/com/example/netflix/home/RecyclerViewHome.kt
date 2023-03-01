package com.example.netflix.home

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.image.ImageDataClass
import com.example.netflix.IonClickItems
import com.example.netflix.R

class RecyclerViewHome(
    val imageListOfMovie: ArrayList<ImageDataClass>,
    val iclickItems: IonClickItems
) :
    RecyclerView.Adapter<RecyclerViewHome.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivHome = itemView.findViewById<ImageView>(R.id.iv_home)
        val ivLike = itemView.findViewById<ImageView>(R.id.iv_like)
        val tvHome = itemView.findViewById<TextView>(R.id.tv_home)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivHome.setImageResource(imageListOfMovie[position].imageMovie)
        holder.tvHome.text = imageListOfMovie[position].movieName
        holder.ivHome.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: ${imageListOfMovie[position]}")
        }
        holder.ivLike.setImageResource(
            when {
                imageListOfMovie[position].isFavorite -> R.drawable.heart
                else -> R.drawable.hearth
            }
        )
        holder.ivLike.setOnClickListener {
            iclickItems.onClick(position)
            if (imageListOfMovie[position].isFavorite) {
                imageListOfMovie[position].isFavorite = true
                holder.ivLike.setImageResource(R.drawable.heart)
            }
            else {
                imageListOfMovie[position].isFavorite = false
                holder.ivLike.setImageResource(R.drawable.hearth)
            }
        }
    }

    override fun getItemCount(): Int {
        return imageListOfMovie.size
    }

}