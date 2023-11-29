package UI

import UI.Routes.Nav1
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable

fun Menu()
{
    val Meitem = Triple("Menu",false,Icons.Filled.Menu)

   // var items = listOf(Pair("Menu",false),  Pair("Tableau de bord",true),Pair("Membres",true),Pair("Recherche",true),                  )
    var selectedItem = remember { mutableStateOf(0) }
    val items = listOf("Tableau de bord", "Membres", "Recherche")
    val icons = listOf( Icons.Filled.Home, Icons.Filled.Face, Icons.Filled.Search)
   Column (verticalArrangement = Arrangement.SpaceBetween,

       modifier = Modifier.fillMaxHeight())


   {

       Button(onClick ={} )
       {

       }
       NavigationRail (header = {
           NavigationRailItem(
               icon = { Icon(Meitem.third, contentDescription = Meitem.first) },
               label = { Text(Meitem.first) },
               enabled = Meitem.second,
               selected = false,
               onClick = {
               }
           )

       })
       {



           items.forEachIndexed { index, item ->
               NavigationRailItem(
                   icon = { Icon(icons[index], contentDescription = item) },
                   label = { Text(item) },
                   selected = selectedItem.value == index,
                   onClick = { selectedItem.value = index
                   Nav1.value = index
                   }
               )
           }
       }

   }
}