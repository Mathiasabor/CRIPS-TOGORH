package UI

import Models.*
import UI.Members.Component.Member
import UI.Oper._Nav3
import UI.PersList.persList
import UI.Routed.Nav2
import UI.Titres._titre
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Global{
    var infoPerso = mutableStateOf<InfoPerso?>(null)
    var infoPro: InfoPro? = null
    var confidentielles: Confidentielles? = null
    var competence: Competence? = null
}

@Composable
fun Personnel()
{
    var selectedItems by remember { mutableStateOf(emptySet<Int>()) }
    Column ( modifier =  Modifier.fillMaxHeight()) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            FloatingActionButton(
                backgroundColor = Color(87, 102, 100),
                onClick = { Routes.Nav1.value = 1 },
                modifier = Modifier.padding(16.dp),
                content = {
                    // Image(imageVector = Icons.Default.ArrowBack, contentDescription = null,)
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                })

            PageTitle(_titre.value)
        }


        Row ( horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp).fillMaxWidth()){
            Text(text= "Membres", fontSize = 25.sp,modifier = Modifier.padding(start = 16.dp))
            Row {

                FloatingActionButton(
                    backgroundColor = Color(87, 102, 100),
                    onClick = {  },
                    modifier = Modifier.padding(16.dp),
                    content = {
                        // Image(imageVector = Icons.Default.ArrowBack, contentDescription = null,)
                        Icon(imageVector = Icons.Filled.List, contentDescription = null, tint = Color.White)
                    })


                FloatingActionButton(
                    backgroundColor = Color(87, 102, 100),
                    onClick = { Nav2.value = "Ajouter" },
                    modifier = Modifier.padding(16.dp),
                    content = {
                        // Image(imageVector = Icons.Default.ArrowBack, contentDescription = null,)
                        Icon(imageVector = Icons.Filled.Add, contentDescription = null, tint = Color.White)
                    })
                FloatingActionButton(
                    backgroundColor = Color(87, 102, 100),
                    onClick = { Nav2.value = "Modifier" },
                    modifier = Modifier.padding(16.dp),
                    content = {
                        // Image(imageVector = Icons.Default.ArrowBack, contentDescription = null,)
                        Icon(imageVector = Icons.Filled.Edit, contentDescription = null, tint = Color.White)
                    })
                FloatingActionButton(
                    backgroundColor = Color.Red,
                    onClick = {  },
                    modifier = Modifier.padding(16.dp),
                    content = {
                        // Image(imageVector = Icons.Default.ArrowBack, contentDescription = null,)
                        Icon(imageVector = Icons.Filled.Delete, contentDescription = null, tint = Color.White)
                    })

            }
        }



        Row {


            LazyColumn {
                itemsIndexed(persList){index, item ->
                    val isSelected = selectedItems.contains(index)
                    val backgroundColor = if (isSelected) Color(87, 102, 100) else Color.Gray

                    KardPersonnel(item.name, item.desc, item.image, item.nav,  {  selectedItems = setOf(index)})


                }
            }

            Column(modifier = Modifier.weight(1F)) {
                Apercu()
            }
        }
    }
}

@Composable
fun PersonnelItem(name : String, desc : String, image : String, colord : Color)
{
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp,10.dp, 30.dp,10.dp)
    ) {

        Image(
            painter = painterResource(image),
            contentDescription = desc,
            modifier = Modifier.shadow(elevation = 0.dp, shape = RectangleShape).size(32.dp))
        Spacer(modifier = Modifier.padding(8.dp))
        Text(name, fontSize = 15.sp, color = colord, maxLines = 1, overflow = TextOverflow.Visible)

    }
}

@Composable
fun KardPersonnel(name : String, desc : String, image : String, nav : Int, exec :()->Unit)
{
    val col = remember {   mutableStateOf(false)}
    Card(shape = RoundedCornerShape(30.dp),
        backgroundColor =  Color(87, 102, 100),
        elevation = 6.dp,
        modifier = Modifier.padding(8.dp)

            .clickable {
                exec()

                if(col.value== true) col.value = false else col.value =true




            }
    )
    {
        PersonnelItem(name , desc , image, Color.White)
    }
}


