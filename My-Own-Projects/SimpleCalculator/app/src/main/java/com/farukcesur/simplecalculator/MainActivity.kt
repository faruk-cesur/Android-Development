package com.farukcesur.simplecalculator

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.farukcesur.simplecalculator.databinding.ActivityMainBinding
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val errorMessage = "Enter Numbers and Try Again!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdgeIfNeeded()

        adjustInsetsIfNeeded(binding.root)
        setupClickListeners()
    }

    private fun enableEdgeToEdgeIfNeeded() {
        enableEdgeToEdge()
    }

    private fun adjustInsetsIfNeeded(view: View) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupClickListeners() {
        binding.plusButton.setOnClickListener { addition(it) }
        binding.minusButton.setOnClickListener { subtraction(it) }
        binding.multiplyButton.setOnClickListener { multiplication(it) }
        binding.divideButton.setOnClickListener { division(it) }
    }

    private fun formatNumber(number: Double): String {
        val decimalFormat = DecimalFormat("#,###.##", DecimalFormatSymbols(Locale.GERMANY))
        return decimalFormat.format(number)
    }

    private fun addition(view: View) {
        val firstNumberText = binding.enterFirstNumberEditText.text.toString()
        val secondNumberText = binding.enterSecondNumberEditText.text.toString()

        if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            binding.resultTextView.text = errorMessage
            return
        }

        val firstNumber = firstNumberText.toDoubleOrNull()
        val secondNumber = secondNumberText.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = firstNumber + secondNumber
            val formattedResult = formatNumber(result)
            binding.resultTextView.text = formattedResult
        } else {
            binding.resultTextView.text = errorMessage
        }
    }

    private fun subtraction(view: View) {
        val firstNumberText = binding.enterFirstNumberEditText.text.toString()
        val secondNumberText = binding.enterSecondNumberEditText.text.toString()

        if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            binding.resultTextView.text = errorMessage
            return
        }

        val firstNumber = firstNumberText.toDoubleOrNull()
        val secondNumber = secondNumberText.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = (firstNumber - secondNumber)
            val formattedResult = formatNumber(result)
            binding.resultTextView.text = formattedResult
        } else {
            binding.resultTextView.text = errorMessage
        }
    }

    private fun multiplication(view: View) {
        val firstNumberText = binding.enterFirstNumberEditText.text.toString()
        val secondNumberText = binding.enterSecondNumberEditText.text.toString()

        if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            binding.resultTextView.text = errorMessage
            return
        }

        val firstNumber = firstNumberText.toDoubleOrNull()
        val secondNumber = secondNumberText.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = (firstNumber * secondNumber)
            val formattedResult = formatNumber(result)
            binding.resultTextView.text = formattedResult
        } else {
            binding.resultTextView.text = errorMessage
        }
    }

    private fun division(view: View) {
        val firstNumberText = binding.enterFirstNumberEditText.text.toString()
        val secondNumberText = binding.enterSecondNumberEditText.text.toString()

        if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
            binding.resultTextView.text = errorMessage
            return
        }

        val firstNumber = firstNumberText.toDoubleOrNull()
        val secondNumber = secondNumberText.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = (firstNumber / secondNumber)
            val formattedResult = formatNumber(result)
            binding.resultTextView.text = formattedResult
        } else {
            binding.resultTextView.text = errorMessage
        }
    }
}