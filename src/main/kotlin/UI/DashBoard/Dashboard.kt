package UI.DashBoard

import UI.DashBoard.Component.BarChartPreview
import UI.DashBoard.Component.RepCard
import UI.DashBoard.Component.serviceSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun Dashboard()
{
val a = remember{mutableStateOf(0)}
    val b = remember{mutableStateOf(0)}
    val c = remember{mutableStateOf(0)}
    val d = remember{mutableStateOf(0)}
Column(modifier = Modifier.fillMaxWidth()) {
    Spacer(modifier = Modifier.padding(20.dp))
    Text(text="Tableau de bord", fontSize = 60.sp, modifier = Modifier.padding(start = 10.dp), color = Color.White)
    Spacer(modifier = Modifier.padding(20.dp))
    val modifier = Modifier.weight(0.3f).padding(10.dp)
    Row (modifier = Modifier.fillMaxWidth()){

        RepCard("Effectif totale",a, modifier)
        RepCard("Employé(e)s",b,modifier)
        RepCard("Stagiaires",c,modifier)
        RepCard("Absences & Congés",d,modifier)


    }

   // serviceSize()
    //BarChartPreview()

}

    repeat(1){
        if(a.value<250){
            a.value ++

        }
        if(b.value<300){
            b.value ++

        }
        if(c.value<350){
            c.value ++

        }
        if(d.value<400){
            d.value ++

        }
    }

}