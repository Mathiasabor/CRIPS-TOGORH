package UI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Login(navHome : ()->Unit)
{
    MaterialTheme {
        /*Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()) {*/

            Box(modifier = Modifier.fillMaxSize()
               // .padding(30.dp)
                .background(color = Color(87, 102, 100))

            ){
               /* Image(
                    painter = painterResource("AKMA.png"),
                    contentDescription = "",
                    alpha = 0.5F,
                    modifier = Modifier.fillMaxSize()
                )*/

                Text(text ="Bienvenue",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,


                    modifier = Modifier.align(Alignment.TopCenter).padding(25.dp))

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.align(Alignment.Center)){


                    Image(

                        imageVector = Icons.Filled.AccountCircle,
                        colorFilter = ColorFilter.tint(color = Color.White),
                        contentDescription = "moi",
                        modifier = Modifier
                            .border(width = 2.dp, color = Color.White, shape = CircleShape)
                            .shadow(elevation = 2.dp, shape = CircleShape)
                            .size(150.dp)

                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    LoginField(Icons.Filled.AccountBox)
                    Spacer(modifier = Modifier.padding(8.dp))
                    LoginField(Icons.Filled.Lock)
                    Spacer(modifier = Modifier.padding(8.dp))
                    Button(onClick = {navHome()},
                        shape = RoundedCornerShape(50.dp),
                        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, hoveredElevation = 3.dp),
                        border = BorderStroke(width = 2.dp, color = Color.White),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent, contentColor = Color.White)
                    )
                    {
                        Text("Se connecter")
                    }
                }
            }

        }
   // }

}

@Composable
fun LoginField( icon : ImageVector)
{
    Box(modifier = Modifier.width(350.dp).height(50.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(50.dp))

    )
    {


        val textState = remember { mutableStateOf("") }
        Box{
            BasicTextField(
                value = textState.value,
                maxLines = 1,
                onValueChange = {
                    textState.value = it},
                textStyle = TextStyle(fontSize = 16.sp, color = Color.White),
                decorationBox = { innerTextField ->
                    Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.padding(8.dp).fillMaxWidth())
                    {
                        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()){
                            Icon(imageVector = icon, contentDescription = null, tint = Color.White)
                            innerTextField()

                        }
                    }
                }
            )
        }

    }
}