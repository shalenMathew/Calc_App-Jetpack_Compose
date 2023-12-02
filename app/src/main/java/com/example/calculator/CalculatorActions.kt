package com.example.calculator

sealed class CalculatorActions{

    object Clear:CalculatorActions()
    object Delete:CalculatorActions()
    object Decimal:CalculatorActions()
    object  Calculate :CalculatorActions()
    data class Numbers( val no:Int):CalculatorActions()
    data class Operations(val operations: CalcOperations):CalculatorActions()

}
