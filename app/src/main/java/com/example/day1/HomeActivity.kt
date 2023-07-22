package com.example.day1

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        listView = findViewById(R.id.list_view)

        val values: ArrayList<String> = arrayListOf(
            "Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday"
        )

        val description: ArrayList<String> = arrayListOf(
            "Saturday description",
            "Sunday description",
            "Monday description",
            "Tuesday description",
            "Wednesday description",
            "Thursday description",
            "Friday description"
        )

        val images = arrayListOf(
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven
        )

        /*val myAdapter: ArrayAdapter<String> =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, values)*/
        /*val myAdapter: ArrayAdapter<String> =
            ArrayAdapter(applicationContext, R.layout.single_row, R.id.textView, values)*/

        val myAdapter: ArrayAdapter<String> =
            SimpleArrayAdapter(applicationContext, values, description, images)
        listView.adapter = myAdapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, id ->
                Toast.makeText(
                    applicationContext,
                    "You clicked ${adapterView.getItemAtPosition(position)}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}
