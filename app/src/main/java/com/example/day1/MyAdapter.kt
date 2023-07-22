package com.example.day1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val data: List<Day>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // pagination & paging
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val row =
            LayoutInflater.from(parent.context).inflate(R.layout.single_row, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.imageView.setImageResource(data[position].image)
        holder.textViewDay.text = data[position].day
        holder.textViewDescription.text = data[position].description
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        var imageView = row.findViewById<ImageView>(R.id.imageView)
        var textViewDay: TextView = row.findViewById(R.id.textViewDay)
        var textViewDescription: TextView = row.findViewById(R.id.textViewDescription)
    }
}
