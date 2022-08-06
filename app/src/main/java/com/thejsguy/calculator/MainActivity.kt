package com.thejsguy.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var screen: TextView? = null
    var buffer: String = ""

    var preNumber: String = ""
    var operation: Operation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen = findViewById(R.id.screen)

        numPadButtons.forEach { this.mapOperationsToNumpad(it) }

        keypadOperations.forEach { this.mapKeypadOperations(it) }

        val clearButton: Button = findViewById(R.id.clearButton)
        clearButton.setOnClickListener { clearScreen() }

        val equalButton: Button = findViewById(R.id.btnEquals)
        equalButton.setOnClickListener { handleEquals() }
    }

    @SuppressLint("SetTextI18n")
    private fun updateScreenWithNumber(digit: String) {
        screen?.let {
            buffer = "$buffer$digit"
            it.text = "${it.text}$digit";
        }
    }


    @SuppressLint("SetTextI18n")
    private fun clearScreen() {
        screen?.let {
            buffer = ""
            it.text = ""
            operation = null
            preNumber = ""
        }
    }

    private fun mapOperationsToNumpad(btn: NumPadButton) {
        val button: Button = findViewById(btn.id)

        button.setOnClickListener { this.updateScreenWithNumber(btn.value) }
    }

    private fun mapKeypadOperations(keypadOperation: KeypadOperation) {
        val button: Button = findViewById(keypadOperation.id)

        button.setOnClickListener {
            if (operation === null) {
                preNumber = buffer;
                buffer = "";
                operation = keypadOperation.name
                screen?.let {
                    it.text = "${it.text}\n${keypadOperation.symbol}\n";
                }
            }
        }
    }

    private fun handleEquals() {
        screen?.let { _screen ->
            operation?.let {
                val n_first: Double = preNumber.toDouble()
                val n_second: Double = buffer.toDouble()
                var result = 0.0;

                when (operation) {
                    Operation.ADD -> {
                        result = n_first + n_second;
                    }
                    Operation.SUBSTRACT -> {
                        result = n_first - n_second;
                    }
                    Operation.MULTIPLY -> {
                        result = n_first * n_second;
                    }
                    Operation.DIVIDE -> {
                        result = n_first / n_second;
                    }
                }
                _screen.text = "${_screen.text}\n=\n$result"
                buffer = "$result";
                operation = null
                preNumber = buffer
            }
        }
    }
}