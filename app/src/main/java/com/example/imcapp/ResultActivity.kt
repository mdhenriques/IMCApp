package com.example.imcapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.math.pow
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imcapp.ui.theme.IMCAppTheme

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val weight = intent.getDoubleExtra("WEIGHT", 0.0)
        val height = intent.getDoubleExtra("HEIGHT", 0.0)
        val imc = calculateIMC(weight, height)

        val imcTextView = findViewById<TextView>(R.id.imcTextView)
        val classificationTextView = findViewById<TextView>(R.id.classificationTextView)

        imcTextView.text = String.format("IMC: %.2f", imc)
        classificationTextView.text = classifyIMC(imc)
    }

    private fun calculateIMC(weight: Double, height: Double): Double {
        return weight / height.pow(2)
    }

    private fun classifyIMC(imc: Double): String {
        return when {
            imc < 18.5 -> "Abaixo do peso ideal"
            imc in 18.5..24.9 -> "Peso ideal"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidade"
        }
    }
}

