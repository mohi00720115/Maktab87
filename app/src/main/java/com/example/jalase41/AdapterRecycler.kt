package com.example.jalase41

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class AdapterRecycler(
//    private val listCity : ArrayList<String>,
    private val listCity : ArrayList<CityDataClass>, private val detail : (CityDataClass) -> Unit
) : RecyclerView.Adapter<AdapterRecycler.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listCity[position]
        Log.d(TAG, "onBindViewHolder: $item")
//        with(holder){
            holder.textView.text = item.nameCity
        holder.textView.setOnClickListener {
            detail(item)
        }
//        }
    }

    override fun getItemCount(): Int {
        return listCity.size
    }

/*    class DiffCallBack: DiffUtil.ItemCallback<CityDataClass>() {
        override fun areItemsTheSame(oldItem: CityDataClass, newItem: CityDataClass): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CityDataClass, newItem: CityDataClass): Boolean {
            return oldItem.id == newItem.id
        }

    }*/

}