package com.example.hw13_2.taskActivity

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.app.NotificationCompat.getColor
import androidx.core.view.ViewCompat.setBackgroundTintList
import androidx.recyclerview.widget.RecyclerView
import com.example.hw13_2.R

class RecyclerTask(val listItem: ArrayList<TaskData>) :
    RecyclerView.Adapter<RecyclerTask.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.cardView)
        val tvName = itemView.findViewById<TextView>(R.id.tv_name)
        val tvNubmer = itemView.findViewById<TextView>(R.id.tv_number)
        val btnAdd = itemView.findViewById<Button>(R.id.btnAdd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {
            if (position % 2 == 0) {
                cardView.setBackgroundResource(R.color.teal_200)
            } else if (position % 2 == 1) {
                cardView.setBackgroundResource(R.color.purple_200)
            }
            tvName.text = listItem[position].name
            tvNubmer.text = listItem[position].task.toString()
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

}