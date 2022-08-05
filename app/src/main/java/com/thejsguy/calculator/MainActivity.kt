package com.thejsguy.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    var screen: TextView? = null

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
        equalButton.setOnClickListener{ handleEquals() }
    }

    @SuppressLint("SetTextI18n")
    private fun updateScreenWithNumber(digit: String) {
        screen?.let {
            it.text = "${it.text}${digit}"
        }
    }


    @SuppressLint("SetTextI18n")
    private fun clearScreen() {
        screen?.let {
            it.text = ""
            operation = null
            preNumber = ""
        }
    }

    private fun mapOperationsToNumpad(btn: NumPadButton) {
        val button: Button = findViewById(btn.id)

        button.setOnClickListener {
            this.updateScreenWithNumber(btn.value)
        }
    }

    private fun mapKeypadOperations(keypadOperation: KeypadOperation) {
        val button: Button = findViewById(keypadOperation.id)
        val _self = this;

        button.setOnClickListener {
            if (_self.operation === null) {
                _self.preNumber = screen?.text as String;
                _self.operation = keypadOperation.name
                screen?.let {
                    it.text = "";
                }
            }
        }
    }

    private fun handleEquals() {
        screen?.let { _screen ->
            operation?.let {
                val _first: Double = preNumber.toDouble()
                val _second: Double = (_screen.text as String).toDouble()

                when (operation) {
                    Operation.ADD -> {
                        _screen.text = "${_first + _second}"
                    }
                    Operation.SUBSTRACT -> {
                        _screen.text = "${_first - _second}"
                    }
                    Operation.MULTIPLY -> {
                        _screen.text = "${_first * _second}"
                    }
                    Operation.DIVIDE -> {
                        _screen.text = "${_first / _second}"
                    }
                }

                operation = null
                preNumber = _screen.text as String
            }
        }
    }
}