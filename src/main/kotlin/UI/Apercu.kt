package UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable

fun Apercu( aperdu : ApercuRecherches = ApercuRecherches)
{

    val infod = mutableListOf("Nom","Prénom","Sexe","Nationalité","Date de naissance","N°CNSS","Contrat","Date d'entrée","Date de sortie","Casier judiciaire")

    Card( elevation = 3.dp,

        modifier = Modifier
            .padding(8.dp, 0.dp,8.dp, 8.dp)
            .fillMaxSize()){



        LazyColumn(modifier = Modifier.padding(8.dp))
        {
            item {
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(

                        painter = painterResource("moi.jpg"),
                        contentDescription = "moi",
                        modifier = Modifier
                            .shadow(elevation = 2.dp, shape = CircleShape)
                            .size(150.dp)
                    )

                    Spacer(modifier = Modifier.padding(8.dp))
                    Column {
                        Text(text = ""+aperdu.infoPerso.value.Nom+""+aperdu.infoPerso.value.Prenom, fontSize = 25.sp)
                        Text(aperdu.infoPerso.value.Email, fontSize = 15.sp)
                        Text(aperdu.infoPerso.value.Telephone, fontSize = 15.sp)
                        Text(aperdu.infoPro.value.Fonction, fontSize = 15.sp)

                    }
                }
                Divider(thickness = 5.dp)

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1F)) {
                        Spacer(modifier = Modifier.padding(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Sexe :", fontSize = 20.sp)
                            Text(text = aperdu.infoPerso.value.Sexe, fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Nationalité :", fontSize = 20.sp)
                            Text(text = aperdu.infoPerso.value.Nationaite, fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Date d'entrée :", fontSize = 20.sp)
                            Text(text = "02/03/2023", fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "N°CNSS :", fontSize = 20.sp)
                            Text(text = "${aperdu.infoPro.value.Nssocial}", fontSize = 15.sp)
                        }

                    }
                    Column(modifier = Modifier.weight(1F)) {
                        Spacer(modifier = Modifier.padding(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Diplome :", fontSize = 20.sp)
                            Text(text = aperdu.competence.value.diplome, fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Contrat :", fontSize = 20.sp)
                            Text(text = "CDI", fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Date de sortie :", fontSize = 20.sp)
                            Text(text = "", fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Casier judiciaire :", fontSize = 20.sp)
                            Text(text = aperdu.infoPro.value.Casierju, fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Casier judiciaire :", fontSize = 20.sp)
                            Text(text = aperdu.infoPro.value.Casierju, fontSize = 15.sp)
                        }


                    }
                }
            }

        }

    }
}

