package UI.Members.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun Departement( name : String,
            desc : String,
            image : String,
            index: Int,
            focusd:MutableState<Int>,
            click : ()->Unit
            )
{
    val exp = mutableStateOf(index==focusd.value)
    Button(onClick = {
        focusd.value = index
        click()

    },

        colors = ButtonDefaults.buttonColors(backgroundColor = if(exp.value) Color.Black else Color.LightGray),
        shape = RoundedCornerShape(30.dp),


        modifier = Modifier.fillMaxWidth().padding(start = 20.dp,top =20.dp, end = 20.dp, bottom = 10.dp )){
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(image),
                contentDescription = desc,
                modifier = Modifier.shadow(elevation = 0.dp, shape = RectangleShape).size(64.dp))
            Spacer(modifier = Modifier.padding(8.dp))
            Text(name, fontSize = 20.sp, maxLines = 1, overflow = TextOverflow.Clip, color = if(exp.value) Color.White else Color.Black)
        }


    }
}

@Composable

fun Member( name : String,
                 desc : String,
                 image : String,
                 index: Int,
                 focusM:MutableState<Int>,
                 click : ()->Unit
)
{
    val exp = mutableStateOf(index==focusM.value)
    Button(onClick = {
        focusM.value = index
        click()

    },

        colors = ButtonDefaults.buttonColors(backgroundColor = if(exp.value) Color.DarkGray else Color.LightGray),
        shape = RoundedCornerShape(30.dp),


        modifier = Modifier.fillMaxWidth().padding(start = 20.dp,top =20.dp, end = 20.dp, bottom = 10.dp )){
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(image),
                contentDescription = desc,
                modifier = Modifier.shadow(elevation = 0.dp, shape = RectangleShape).size(64.dp))
            Spacer(modifier = Modifier.padding(8.dp))
            Text(name, fontSize = 20.sp, maxLines = 1, overflow = TextOverflow.Clip, color = if(exp.value) Color.White else Color.Black)
        }


    }
}


