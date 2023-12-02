package com.example.calculator

sealed class CalcOperations(val symbol:String) {

    object Add:CalcOperations("+")
    object Sub:CalcOperations("-")
    object Mul:CalcOperations("x")
    object Div:CalcOperations("/")

}