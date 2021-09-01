package com.vsking.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vsking.myapplication.api.apidata.ListData

/**
 * Created by Vivek kumar on 9/1/2021.
 * E-mail:- vivekpcst.kumar@gmail.com
 */
class DataListAdapter(val listener:ItemClickListener):PagingDataAdapter<ListData,DataListAdapter.DataHolder>(DiffUtilCallback()) {
    class DataHolder(view: View): RecyclerView.ViewHolder(view) {
        val title= view.findViewById<TextView>(R.id.textView)
        val desc= view.findViewById<TextView>(R.id.textView2)
        fun bindData(data: ListData){
            title.text=data.name
            desc.text=data.species
        }

    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        if (getItem(position) != null) {
            holder.bindData(getItem(position)!!)
            holder.itemView.setOnClickListener {
                listener.onItemClick(getItem(position)!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        return DataHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.data_item,
                    parent,
                    false
                )
        )
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<ListData>(){
        override fun areItemsTheSame(oldItem: ListData, newItem: ListData): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ListData, newItem: ListData): Boolean {
            return oldItem.name == newItem.name && oldItem.species == newItem.species
        }

    }
    interface ItemClickListener{
        fun onItemClick(data: ListData)
    }
}