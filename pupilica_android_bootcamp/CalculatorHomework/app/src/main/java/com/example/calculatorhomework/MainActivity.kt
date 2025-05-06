package com.example.calculatorhomework

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tvResult: TextView
    private var currentInput = ""
    private var totalSum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        tvResult = binding.resultText

        val numberButtons = listOf(
            R.id.zeroButton, R.id.oneButton, R.id.twoButton, R.id.threeButton, R.id.fourButton,
            R.id.fiveButton, R.id.sixButton, R.id.sevenButton, R.id.eightButton, R.id.nineButton
        )

        // Rakam butonları
        for (id in numberButtons) {
            findViewById<Button>(id).setOnClickListener {
                val number = (it as Button).text.toString()
                currentInput += number
                tvResult.text = currentInput
            }
        }

        // + Butonu
        findViewById<Button>(R.id.additionButton).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                totalSum += currentInput.toInt()
                currentInput = ""
                tvResult.text = "0"
            }
        }

        // = Butonu
        findViewById<Button>(R.id.equalButton).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                totalSum += currentInput.toInt()
                currentInput = ""
            }
            tvResult.text = totalSum.toString()
        }

        // C (Clear) Butonu
        findViewById<Button>(R.id.resetButton).setOnClickListener {
            currentInput = ""
            totalSum = 0
            tvResult.text = "0"
        }
    }
}