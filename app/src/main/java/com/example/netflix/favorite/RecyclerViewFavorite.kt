package com.example.netflix.favorite

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

class RecyclerViewFavorite(
    private val itemListDC: ArrayList<ImageDataClass>,
) :
    RecyclerView.Adapter<RecyclerViewFavorite.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivHomeFav = itemView.findViewById<ImageView>(R.id.iv_home)
        val ivLikeFav = itemView.findViewById<ImageView>(R.id.iv_like)
        val tvHomeFav = itemView.findViewById<TextView>(R.id.tv_home)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivHomeFav.setImageResource(itemListDC[position].imageMovie)
        holder.tvHomeFav.text = itemListDC[position].movieName
        holder.ivLikeFav.setImageResource(R.drawable.heart)
        holder.ivLikeFav.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: ncdfiomwvhcnierovnx,ierv")
        }

    }

    override fun getItemCount(): Int {
        return itemListDC.size
    }

}
