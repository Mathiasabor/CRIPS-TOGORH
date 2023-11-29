package UI.Menu

import UI.Routes
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun LeftBar()
{

    val focusd = remember{ mutableStateOf(0)}
    val expanded = remember { mutableStateOf(false) }

    Surface(color = Color.Black,

        modifier = Modifier.fillMaxHeight()) {

        Box{
            Column (modifier = Modifier.align(Alignment.TopStart
            )){

                IconButton(onClick = {

                    if (expanded.value) expanded.value = false else expanded.value = true
                }){
                    Icon(painter = painterResource("categorie.png"),
                        contentDescription = "account",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp).padding(start = 10.dp)
                    )
                }

                Option(expanded,"Tableau de bord", 0, focusd,"tableau-de-bord.png","surveillance")
                Option(expanded,"Membres", 1, focusd,"team-building.png","surveillance")
                Option(expanded,"Congés & Absences", 2, focusd,"jour-de-conge.png","surveillance")
                Option(expanded,"", 3, focusd,"jour-de-conge.png","surveillance")
            }


            Column (modifier = Modifier.align(Alignment.BottomStart
            )){




                Option(expanded,"Mon Compte", 4, focusd,"jour-de-conge.png","surveillance")
                Option(expanded,"Aide", 5, focusd,"jour-de-conge.png","surveillance")

            }



        }


    }



}

@Composable

fun Option(expanded : MutableState<Boolean>,
           label : String,
           id : Int,
           focusd : MutableState<Int>,
           icone : String,
           contentDescription: String
           )
{



    val exp = mutableStateOf(id==focusd.value)

    Button(onClick = { focusd.value = id
        Routes.Nav1.value = id

                     },
        colors = ButtonDefaults.buttonColors(backgroundColor = if(exp.value) Color(112,128,144) else Color.Transparent),
        modifier = Modifier.sizeIn(maxWidth = 400.dp),
        shape = RectangleShape
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Box(modifier = Modifier.size(height = 20.dp, width = 2.dp).background(color = Color.Transparent)){

                Column {

                    AnimatedVisibility(exp.value,

                        enter = expandIn(expandFrom = Alignment.TopStart),
                        exit = shrinkOut(shrinkTowards = Alignment.BottomEnd),


                        ) {
                        Box (modifier = Modifier.size(height = 20.dp, width = 2.dp).background(color= Color.White) )

                    }
                }

            }
            Icon(painter = painterResource(icone), contentDescription = contentDescription, tint = Color.White)


            if(expanded.value){
                Spacer(modifier = Modifier.padding(15.dp))
            }
            AnimatedVisibility(expanded.value,

                enter = expandHorizontally(),
                exit = shrinkHorizontally(),


                ) {

                Row {

                    Text(text = label, fontSize = 18.sp, color = Color.White,  modifier = Modifier.fillMaxWidth())

                }
            }


        }

    }




}