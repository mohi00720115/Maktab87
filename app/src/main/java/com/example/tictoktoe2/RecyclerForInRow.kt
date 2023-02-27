package com.example.tictoktoe2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class RecyclerForInRow(
    val itemList: ArrayList<String>,
    val OnClickInterface: IClickListener,
    val status: ArrayList<Boolean>
) :
    RecyclerView.Adapter<RecyclerForInRow.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnRecycler = itemView.findViewById<Button>(R.id.btn_recycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btnRecycler.text = itemList[position]
        holder.btnRecycler.setOnClickListener {
            OnClickInterface.setOnClickListener(position)
            notifyDataSetChanged()      //ریسایکلرو از اول میسازه
        }
        if (status[0]) {
            holder.btnRecycler.isEnabled = false
        }
    }

}