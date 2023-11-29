package UI

import UI.DashBoard.Component.RepCard
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dashboardp()
{
    val dclist = mutableListOf(1,2,3,4)
    Column(horizontalAlignment = Alignment.Start)
    {
        Row( modifier= Modifier.padding(8.dp).fillMaxWidth().weight(0.5F) )
        {
            PageTitle("Tableau de bord")
        }




       Row (modifier= Modifier.padding(8.dp).fillMaxWidth().weight(1F)){
           LazyVerticalGrid(columns = GridCells.Fixed(2),
               modifier = Modifier.weight(1F),

               content = {
                   /*items(dclist){cof->

                       Dcard(cof)

                   }*/

                   item {
                       Dcard("Employés","15")


                   }

                   item {
                       Dcard("Nombre Centre","2")

                   }
                   item {
                       Dcard("Stagiaire","6")

                   }
                   item {
                       Dcard("En Congés","4")

                   }
               }
           )

           Card(
               backgroundColor = Color(87, 102, 100),
           shape = RoundedCornerShape(30.dp),
               elevation = 5.dp,
           modifier = Modifier.weight(1F).fillMaxHeight().padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 25.dp))


           {
              Column( verticalArrangement = Arrangement.SpaceBetween,
                  modifier = Modifier
                      .fillMaxHeight()
                      .padding(start = 20.dp, top = 10.dp, end = 8.dp, bottom = 10.dp)
              ) {
                  Text("CRIPS-TOGO ( Centre de Recherches et d'Informations Pour la Santé au Togo)", fontSize = 20.sp, color = Color.White)

                  Row {
                      Text("N°Employeur", fontSize = 20.sp, color = Color.White, textDecoration = TextDecoration.Underline)
                      Text(" : 35656745", fontSize = 20.sp, color = Color.White)
                  }

                  Row {
                      Text("N°Récipissé", fontSize = 20.sp,  color = Color.White, textDecoration = TextDecoration.Underline)
                      Text(" : 35656745", fontSize = 20.sp,  color = Color.White)
                  }

                  Row {
                      Text("N°Qual ONG", fontSize = 20.sp,  color = Color.White,textDecoration = TextDecoration.Underline)
                      Text(" : 35656745", fontSize = 20.sp,  color = Color.White)
                  }





              }

           }
       }

        Row(modifier= Modifier.padding(8.dp).fillMaxWidth().weight(2F)) {
            //SearchBar()

            Card(
                backgroundColor = Color(87, 102, 100),
                shape = RoundedCornerShape(30.dp),
                elevation = 5.dp,
                modifier = Modifier.weight(2F).fillMaxHeight().padding(8.dp)){



            }

            Card(
                backgroundColor = Color(87, 102, 100),
                shape = RoundedCornerShape(30.dp),
                elevation = 5.dp,
                modifier = Modifier.weight(1F).fillMaxHeight().padding(8.dp)){

            Column (horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)

                ){

                Text("Activités", fontSize = 20.sp,  color = Color.White, textDecoration = TextDecoration.Underline)

            }


            }


        }

    }
}

@Composable
fun PageTitle(name : String)
{
    Text(text = name, fontSize = 36.sp, modifier = Modifier.padding(16.dp))
}