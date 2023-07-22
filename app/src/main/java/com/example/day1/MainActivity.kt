package com.example.day1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    lateinit var emailAddress: EditText

    var bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin: Button = findViewById(R.id.btn_login)
        emailAddress = findViewById(R.id.editTextTextEmailAddress)
        btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("EMAIL_ADDRESS", emailAddress.text.toString())
            intent.putExtra("Phone_ADDRESS", emailAddress.text.toString())
            startActivity(intent)
        }

        val btnClick: Button = findViewById(R.id.btnClick)
        btnClick.setOnClickListener {
            /*val uri = Uri.parse("https://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)*/

            /*val uri = Uri.parse("tel:01098701988")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)*/

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, emailAddress.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT, "How are you?")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        Log.d(TAG, "onCreate: ")

        if (savedInstanceState != null) {
            Log.d(TAG, "onCreate: ${savedInstanceState.getString("phone")}")
        }

        val sum: (Int, Double) -> Double = { x, y ->
            x + y
        }

        val mul: (Int, Double) -> Double = { x, y ->
            x * y
        }

        Log.d(TAG, "sum = ${sum(5, 8.0)} ........... mul = ${mul(2, 4.0)}")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("phone", "01063208399")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}
