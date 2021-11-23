package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculadoraimc.databinding.ActivityDataGatheringBinding

class DataGatheringActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataGatheringBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataGatheringBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("lifecycle", "onCreate - DataGathering")

        with(binding) {
            btCalculate.setOnClickListener {
                val weight = tieInsertWeight.text.toString()
                val height = tieInsertHeight.text.toString()

                if(weight.isBlank()) {
                    tilInsertWeight.error = getString(R.string.field_empty_invalid)
                } else {
                    tilInsertWeight.isErrorEnabled = false
                }

                if(height.isBlank()) {
                    tilInsertHeight.error = getString(R.string.field_empty_invalid)
                } else {
                    tilInsertHeight.isErrorEnabled = false
                }

                if (weight.isNotBlank() && height.isNotBlank()) {

                    val bmi = weight.toDouble() / (height.toDouble() * height.toDouble())

                    var bmiClassification: String = when {
                        bmi < 18.5 -> {
                            getString(R.string.underweight)
                        }
                        bmi < 24.9 -> {
                            getString(R.string.normal_weight)
                        }
                        bmi < 29.9 -> {
                            getString(R.string.overweight)
                        }
                        else -> {
                            getString(R.string.obesity)
                        }
                    }

                    val intent = Intent(
                        this@DataGatheringActivity,
                        MainActivity::class.java
                    )

                    val dataBMI = DataBMI(
                        bmi = bmi,
                        bmiClassification = bmiClassification
                    )

                    intent.putExtra(KEY_INTENT_DATA_BMI, dataBMI)

                    startActivity(intent)

                }

            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "onStart - DataGathering")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle", "onResume - DataGathering")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle", "onPause - DataGathering")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle", "onStop - DataGathering")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifecycle", "onDestroy - DataGathering")
    }

    companion object {
        const val KEY_INTENT_DATA_BMI = "dataBMI"
    }

}