package UI.Modify

import UI.ADD.InfoPerso
import UI.ADD.InfoPro
import UI.Openstate
import UI.PageTitle
import UI.Routed
import UI.Titres
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModifyPersonnel(retour : String)
{
    val selectedTabIndex = remember { mutableStateOf(0) }



    Column(modifier = Modifier.fillMaxHeight()) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            FloatingActionButton(
                backgroundColor = Color(87, 102, 100),
                onClick = { Routed.Nav2.value = "Personnel"
                    Titres.titre.value =retour

                },
                modifier = Modifier.padding(16.dp),
                content = {
                    // Image(imageVector = Icons.Default.ArrowBack, contentDescription = null,)
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                })

            PageTitle(Titres._titre.value)
        }



        TabRow(selectedTabIndex = selectedTabIndex.value, backgroundColor = Color(87, 102, 100), contentColor = Color.White) {
            Tab(
                selected = selectedTabIndex.value == 0,
                onClick = { selectedTabIndex.value = 0 },

                ) {
                Text("Informations Personnelles", modifier = Modifier.padding(5.dp))
            }
            Tab(
                selected = selectedTabIndex.value == 1,
                onClick = { selectedTabIndex.value = 1 },

                ) {
                Text("Informations Professionnelles", modifier = Modifier.padding(5.dp))
            }

            Tab(
                selected = selectedTabIndex.value == 2,
                onClick = { selectedTabIndex.value = 2 },

                ) {
                Text("Formations & Compétences", modifier = Modifier.padding(5.dp))
            }
            Tab(
                selected = selectedTabIndex.value == 3,
                onClick = { selectedTabIndex.value = 3 },

                ) {
                Text("Informations Confidentielles", modifier = Modifier.padding(5.dp))
            }


            Tab(
                selected = selectedTabIndex.value == 4,
                onClick = { selectedTabIndex.value = 4 },

                ) {
                Text("Salaire & Avantages Sociaux", modifier = Modifier.padding(5.dp))
            }

            Tab(
                selected = selectedTabIndex.value == 5,
                onClick = { selectedTabIndex.value = 5 },

                ) {
                Text("Congés & Absences", modifier = Modifier.padding(5.dp))
            }

            Tab(
                selected = selectedTabIndex.value == 6,
                onClick = { selectedTabIndex.value = 6 },

                ) {
                Text("Evaluations & Performances", modifier = Modifier.padding(5.dp))
            }
        }

        when (selectedTabIndex.value) {
            0 -> {

                InfoPerso()
            }
            1 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                InfoPro()
            }

            }


            2 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Text("Contenu de l'onglet 2")
            }

            }
            3 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Text("Contenu de l'onglet 2")
            }

            }
            4 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Text("Contenu de l'onglet 2")
            }

            }
            5 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Text("Contenu de l'onglet 2")
            }

            }
            6 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Text("Contenu de l'onglet 2")
            }

            }


        }



    }


    if(Openstate.shouldShowDialog.value)
    {
        AlertDialog(
            onDismissRequest = {
                Openstate.shouldShowDialog.value = false

            },
            title = {
                Text(text = "Alert")
            },
            text = {

                Text(text = "This is an example AlertDialog.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        Openstate.shouldShowDialog.value = false
                        // Handle the positive button action here
                    }
                ) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        Openstate.shouldShowDialog.value = false
                        // Handle the positive button action here
                    }
                ) {
                    Text(text = "cancel")
                }

            }

        )
    }
}