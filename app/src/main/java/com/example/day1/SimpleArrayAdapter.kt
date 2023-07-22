package com.example.day1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class SimpleArrayAdapter(
    context: Context,
    val values: ArrayList<String>,
    val description: ArrayList<String>,
    val images: ArrayList<Int>
) : ArrayAdapter<String>(context, R.layout.single_row, R.id.textViewDay, values) {

    var counter = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflating the layout
        var row = convertView
        val viewHolder: ViewHolder

        if (row == null) {
            // inflation
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            row = inflater.inflate(R.layout.single_row, parent, false)

            viewHolder = ViewHolder(row)
            row.tag = viewHolder
            Log.d("asd -> ", "counter = ${counter++}")
        } else {
            viewHolder = row.tag as ViewHolder
        }

        // providing element of an array by specifying its position
        viewHolder.getImageView().setImageResource(images[position])
        viewHolder.getDay().text = values[position]
        viewHolder.getDescription().text = description[position]

        return row!!
    }

    class ViewHolder(val row: View) {
        private var imageView: ImageView? = null
        private var textViewDay: TextView? = null
        private var textViewDescription: TextView? = null

        fun getImageView(): ImageView {
            return imageView ?: row.findViewById(R.id.imageView)
        }

        fun getDay(): TextView {
            return textViewDay ?: row.findViewById(R.id.textViewDay)
        }

        fun getDescription(): TextView {
            return textViewDescription ?: row.findViewById(R.id.textViewDescription)
        }
    }
}
