package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.Orange


@Composable
fun Calc(
state: CalcState,
onAction:(CalculatorActions)->Unit,
buttonSpacing: Dp =8.dp,
modifier: Modifier
) {

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(Color.Black)
                .fillMaxWidth()
        ) {

            // text box
            Text(
                text = state.no1 + (state.operation?.symbol ?: "") + state.no2,
                fontSize = 50.sp,
                fontWeight = FontWeight.Light,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(12.dp)
            )

            //1st row btn
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalcButton(symbol = "AC",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )

                CalcButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    })

                CalcButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalcOperations.Div))
                    }
                )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalcButton(symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(7)) })


                CalcButton(symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(8)) }
                )

                CalcButton(symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(9)) }
                )

                CalcButton(symbol = "x", modifier = Modifier.aspectRatio(1f).weight(1f).background(
                    Orange
                ),
                    onClick = { onAction(CalculatorActions.Operations(CalcOperations.Mul)) })


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalcButton(symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(4)) })


                CalcButton(symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(5)) }
                )

                CalcButton(symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(6)) }
                )

                CalcButton(symbol = "-", modifier = Modifier.aspectRatio(1f).weight(1f).background(
                    Orange
                ),
                    onClick = { onAction(CalculatorActions.Operations(CalcOperations.Sub)) })

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalcButton(symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(1)) })


                CalcButton(symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(2)) }
                )

                CalcButton(symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorActions.Numbers(3)) }
                )

                CalcButton(symbol = "+", modifier = Modifier.aspectRatio(1f).weight(1f).background(
                    Orange
                ),
                    onClick = { onAction(CalculatorActions.Operations(CalcOperations.Add)) })

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalcButton(symbol = "0",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Numbers(0))
                    }
                )

                CalcButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    })

                CalcButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )

            }


        }


    }

}