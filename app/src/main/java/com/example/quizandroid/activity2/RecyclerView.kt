package com.example.quizandroid.activity2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizandroid.R
import com.example.quizandroid.activity2.task.TaskData

class RecyclerView(
    val dataItems: ArrayList<TaskData>,
) :
    RecyclerView.Adapter<com.example.quizandroid.activity2.RecyclerView.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.textView_name)
        val tvSubject = itemView.findViewById<TextView>(R.id.textView_subject)
        val tvDate = itemView.findViewById<TextView>(R.id.textView_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = dataItems[position].taskName
        holder.tvSubject.text = dataItems[position].taskSubject
        holder.tvDate.text = dataItems[position].taskDate
    }

    override fun getItemCount(): Int {
        return dataItems.size
    }

}