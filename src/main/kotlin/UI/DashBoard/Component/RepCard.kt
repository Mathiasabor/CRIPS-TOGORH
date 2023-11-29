package UI.DashBoard.Component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import org.jetbrains.skia.Color
import androidx.compose.ui.graphics.Color


@Composable
fun RepCard(label : String,valeur : MutableState<Int> , modifier: Modifier)
{
    Card (shape = RoundedCornerShape(30.dp), backgroundColor = Color.Blue,
        elevation = 6.dp,
        modifier = modifier){
        Box (modifier = Modifier.size(width = 300.dp, height = 200.dp).padding(20.dp)){

            Text(text= label , color = Color.White ,modifier = Modifier.align(Alignment.TopStart))

            Icon(imageVector = Icons.Filled.CheckCircle, tint = Color.White,contentDescription = "checkcircle",modifier = Modifier.align(Alignment.TopEnd) )

            Text("${valeur.value}",  color = Color.White, fontSize = 50.sp,modifier = Modifier.align(Alignment.Center) )

        }
    }
}