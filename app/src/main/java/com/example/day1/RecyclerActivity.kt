package com.example.day1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class RecyclerActivity : AppCompatActivity() {

    val data: List<Day> = arrayListOf(
        Day("Saturday", "Saturday description", R.drawable.one),
        Day("Sunday", "Sunday description", R.drawable.two),
        Day("Monday", "Monday description", R.drawable.three),
        Day("Tuesday", "Tuesday description", R.drawable.four),
        Day("Wednesday", "Wednesday description", R.drawable.five),
        Day("Thursday", "Thursday description", R.drawable.six),
        Day("Friday", "Friday description", R.drawable.seven),
    )

    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        rv = findViewById(R.id.rv)
        rv.adapter = MyAdapter(data)
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}
