package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.calculadoraimc.DataGatheringActivity.Companion.KEY_INTENT_DATA_BMI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("lifecycle", "onCreate - Main")

        val dataBMI = intent.getParcelableExtra<DataBMI>(KEY_INTENT_DATA_BMI)

        val textViewBMI = findViewById<TextView>(R.id.tvYourBMI)
        val textViewClassification = findViewById<TextView>(R.id.tvBMIClassification)
        val textViewAboutCreator = findViewById<TextView>(R.id.tvAboutCreator)
        val recalculateButton = findViewById<Button>(R.id.btRecalculate)

        when {
            dataBMI?.bmiClassification?.equals(getString(R.string.underweight))!! -> {
                textViewClassification.setTextColor(resources.getColor(R.color.blue))
            }
            dataBMI?.bmiClassification?.equals(getString(R.string.normal_weight))!! -> {
                textViewClassification.setTextColor(resources.getColor(R.color.green))
            }
            dataBMI?.bmiClassification?.equals(getString(R.string.overweight))!! -> {
                textViewClassification.setTextColor(resources.getColor(R.color.orange))
            }
            else -> {
                textViewClassification.setTextColor(resources.getColor(R.color.red))
            }
        }

        val textYourBMI = getString(R.string.your_bmi, dataBMI.bmi.format(1))
        textViewBMI.text = textYourBMI
        textViewClassification.text = dataBMI?.bmiClassification

        textViewAboutCreator.setOnClickListener{
            val intent = Intent(
                this@MainActivity,
                AboutCreatorActivity::class.java
            )
            startActivity(intent)
        }

        recalculateButton.setOnClickListener{
            super.onBackPressed()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "onStart - Main")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle", "onResume - Main")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle", "onPause - Main")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle", "onStop - Main")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifecycle", "onDestroy - Main")
    }

    fun Double.format(digits: Int) = "%.${digits}f".format(this)

}