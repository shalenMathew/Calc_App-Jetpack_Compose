package com.example.calculator

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class MainViewModel:ViewModel() {

 var state by mutableStateOf(CalcState())
     private set

    fun onAction(calculatorActions: CalculatorActions){

    when(calculatorActions){

        is CalculatorActions.Numbers -> enteredNo(calculatorActions.no)
        is CalculatorActions.Calculate -> calculate()
        is CalculatorActions.Decimal -> decimal()
        is CalculatorActions.Delete-> delete()
        is CalculatorActions.Clear -> state= CalcState()
        is CalculatorActions.Operations -> enterOperation(calculatorActions.operations)
    }

}

    private fun delete() {

        when{

            state.no2.isNotBlank() -> state=state.copy(no2 = state.no2.dropLast(1))
            state.operation!=null-> state=state.copy(operation = null)
            state.no1.isNotBlank() -> state=state.copy(no1 = state.no1.dropLast(1))


        }

    }

    private fun enterOperation(operations: CalcOperations) {

        if (state.no2.isNotBlank()){

            calculate()

            state=state.copy(
                operation=operations
            )
        }

        if (state.no1.isNotBlank() && state.no2.isBlank()){
           state = state.copy(
               operation = operations
           )
        }


    }


    private fun decimal() {

        if( state.operation==null && !state.no1.contains(".") && state.no1.isNotBlank() ){
            state=state.copy(
                no1 = state.no1+"."
            )
            return
        }

        if (!state.no2.contains(".") && state.no2.isNotBlank()){
            state=state.copy(
                no2 = state.no2+"."
            )
        }

    }

    private fun calculate() {

        val no1 = state.no1.toDoubleOrNull()
        val no2=state.no2.toDoubleOrNull()

        if(no1!=null && no2!=null ){

            val result = when(state.operation){
                is CalcOperations.Add ->  no1+no2
                is CalcOperations.Sub ->  no1-no2
                is CalcOperations.Mul-> no1*no2
                is CalcOperations.Div-> no1/no2
                null->return
            }

            state=state.copy(
                no1=result.toString().take(5),
                operation = null,
                no2 = ""
            )

        }

    }

    private fun enteredNo(no: Int) {

        if (state.operation==null){

            if(state.no1.length>=MAX_NUM_LENGTH){
                return
            }

            state = state.copy(
                no1 = state.no1+no
            )

            return
        }

        if (state.no2.length>= MAX_NUM_LENGTH){
            return
        }

        state=state.copy(
            no2 = state.no2+no
        )

    }


    companion object{
        private const val MAX_NUM_LENGTH=9
    }

}