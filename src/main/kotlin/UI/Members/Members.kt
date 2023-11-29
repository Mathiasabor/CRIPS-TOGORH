package UI.Members


import UI.Members.Component.Departement
import UI.Members.Component.EmployeeView
import UI.Members.Component.Member
import UI.OrgList.orgaList
import UI.PersList
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun Members()
{
    val focusd = remember{ mutableStateOf(-1)}
    val focusM = remember{ mutableStateOf(-1)}
    val memb = remember { mutableStateOf(false) }
    val membd = remember { mutableStateOf(false) }
    val aper = remember { mutableStateOf(false) }
    val aperd = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(20.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween,

            modifier = Modifier.fillMaxWidth()) {
            Text(text="Membres", fontSize = 60.sp, modifier = Modifier.padding(start = 10.dp), color = Color.White)
            Row(horizontalArrangement = Arrangement.SpaceBetween,  modifier = Modifier.padding(end = 20.dp)) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    FloatingActionButton(onClick = {}, elevation = FloatingActionButtonDefaults.elevation())
                    {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "Ajouter un membre")
                    }
                    Text("Ajouter", color = Color.White)
                }

                
            }

        }
        Spacer(modifier = Modifier.padding(20.dp))
        Row (modifier = Modifier.fillMaxWidth()){

            Row(horizontalArrangement = Arrangement.SpaceBetween,

                modifier = Modifier.padding(start = 10.dp, end = 10.dp).weight(0.3f)) {
                Text(text="Départements", fontSize = 30.sp, color = Color.White)

                IconButton(onClick = {}){
                    Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "")

                }
            }
            AnimatedVisibility(memb.value,

                enter = expandHorizontally(),
                exit = shrinkHorizontally(),
                modifier = Modifier.weight(0.3f)


                ) {

                Row(horizontalArrangement = Arrangement.SpaceBetween,

                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                    Text(text="Membres", fontSize = 30.sp, color = Color.White)
                    IconButton(onClick = {}){
                        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "")

                    }
                }

            }


            AnimatedVisibility(aper.value,

                enter = expandHorizontally(),
                exit = shrinkHorizontally(),
                modifier = Modifier.weight(0.3f)


            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,

                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                    Text(text="Aperçu", fontSize = 30.sp, color = Color.White)
                    IconButton(onClick = {}){
                        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "")

                    }
                }


            }





        }



Divider(color = Color.Blue, thickness = 3.dp)

        Row (modifier = Modifier.fillMaxWidth()) {

            LazyColumn(modifier = Modifier.weight(0.3f)) {
                itemsIndexed(orgaList) { index, item ->

                    Departement(item.name,
                        item.desc,
                        item.image,
                        index,
                        focusd
                    ) {
                        memb.value = true
                        membd.value = index == focusd.value
                    }

                }
            }

            AnimatedVisibility(membd.value,

                enter = expandHorizontally(),
                exit = shrinkHorizontally(),
                modifier = Modifier.weight(0.3f)


                ) {

                LazyColumn {
                    itemsIndexed(PersList.persList) { index, item ->

                        Member(item.name,
                            item.desc,
                            item.image,
                            index,
                            focusM
                        ) {
                            memb.value = true
                            aper.value =true
                            aperd.value =true
                            //membd.value = index == focusd.value
                        }

                    }
                  }

            }


            AnimatedVisibility(aperd.value,

                enter = expandHorizontally(),
                exit = shrinkHorizontally(),
                modifier = Modifier.weight(0.3f)


            ) {
                Column(modifier = Modifier.padding(top= 20.dp)) {

                    EmployeeView()

                }

            }



        }


    }
}

