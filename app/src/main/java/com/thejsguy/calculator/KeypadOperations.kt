package com.thejsguy.calculator

enum class Operation {
    ADD,
    MULTIPLY,
    DIVIDE,
    SUBSTRACT
}

data class KeypadOperation(val id: Int, val name: Operation);

val keypadOperations = arrayOf(
    KeypadOperation(R.id.btnAdd, Operation.ADD),
    KeypadOperation(R.id.btnSubstract, Operation.SUBSTRACT),
    KeypadOperation(R.id.btnMultiply, Operation.MULTIPLY),
    KeypadOperation(R.id.btnDivide, Operation.DIVIDE),
)