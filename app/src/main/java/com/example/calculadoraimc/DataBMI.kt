package com.example.calculadoraimc

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataBMI(
    val bmi: Double,
    val bmiClassification: String
) :Parcelable
