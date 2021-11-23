package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton

class AboutCreatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_creator)
        Log.i("lifecycle", "onCreate - AboutCreator")

        val backButton = findViewById<ImageButton>(R.id.btBack)

        backButton.setOnClickListener {
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "onStart - AboutCreator")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle", "onResume - AboutCreator")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle", "onPause - AboutCreator")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle", "onStop - AboutCreator")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("lifecycle", "onDestroy - AboutCreator")
    }

}