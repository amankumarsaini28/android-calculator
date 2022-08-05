package com.thejsguy.calculator


data class NumPadButton(val id: Int, val value: String);

val numPadButtons = arrayOf(
    NumPadButton(R.id.btnOne, "1"),
    NumPadButton(R.id.btnTwo, "2"),
    NumPadButton(R.id.btnThree, "3"),
    NumPadButton(R.id.btnFour, "4"),
    NumPadButton(R.id.btnFive, "5"),
    NumPadButton(R.id.btnSix, "6"),
    NumPadButton(R.id.btnSeven, "7"),
    NumPadButton(R.id.btnEight, "8"),
    NumPadButton(R.id.btnNine, "9"),
    NumPadButton(R.id.btnZero, "0"),
)
