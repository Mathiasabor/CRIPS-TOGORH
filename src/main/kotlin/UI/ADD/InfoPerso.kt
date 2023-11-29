package UI.ADD

import UI.ADD.Persoi.Adresse
import UI.ADD.Persoi.Email
import UI.ADD.Persoi.Images
import UI.ADD.Persoi.Nom
import UI.ADD.Persoi.Prenom
import UI.ADD.Persoi.Telephone
import UI.Openstate.shouldShowDialog
import UI.Oper
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


object Persoi{
    var Nom = mutableStateOf("")
    var Prenom = mutableStateOf("")
    var Sexe = mutableStateOf("")
    var Nationaite = mutableStateOf("")
    var Telephone = mutableStateOf("")
    var Email = mutableStateOf("")
    var Adresse = mutableStateOf("")
    var Ville = mutableStateOf("")
    var Images = mutableStateOf("avatar.png")
}

@Composable
fun InfoPerso()
{
    val ville = listOf("Lomé", "Sanguera", "Agoe", "Aneho")
    val sexe = listOf("Masculin", "Féminin", "Autres")
    val nationalite = listOf("TOGO", "GHANA", "BENIN", "BURKINA-FASO", "cameroun")
    val fonctions = listOf("Directeur", "Coordonatrice", " RAF ", "Comptable", "Assistant Médical", "Infirmière")
    Column(modifier = Modifier.padding(20.dp).fillMaxHeight())
    {
        //Spacer(modifier = Modifier.padding( 20.dp))
        LazyColumn{
            item {
                Row (horizontalArrangement = Arrangement.SpaceBetween){

                    Column{

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {

                            FavTextField("Nom", "Entrer le nom", 16.dp, Nom.value,{Nom.value = it})
                            FavTextField("Prenom", "Entrer le prenom", 16.dp, Prenom.value, {Prenom.value =it})


                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {


                            MyContent(sexe, "Sexe", 16.dp, 280.dp)
                            MyContent(nationalite, "Nationalité", 16.dp, 280.dp)


                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {

                            FavTextField("Telephone", "Entrer le numero", 16.dp, Telephone.value,{ Telephone.value = it})
                            FavTextField("Email", "Entrer l'email", 16.dp, Email.value, {Email.value =it})


                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {


                            FavTextField("Adresse", "Entrer l'adresse", 16.dp, Adresse.value,{ Adresse.value = it})
                            MyContent(ville, "Ville", 16.dp,280.dp)


                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {


                            MyContent(fonctions, "Fonctions", 16.dp, 280.dp)

                        }



                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {

                            // KardPersonnel("AHO KODJO MATHIAS ABOR","","homme.png",0)

                            when (Oper._Nav3.value) {
                                "ajouter" -> {
                                    MonButton("Ajouter", Icons.Filled.Add, { shouldShowDialog.value = true })
                                    Spacer(modifier = Modifier.padding(8.dp))
                                    MonButton("Vider", Icons.Filled.Clear, { shouldShowDialog.value = true })

                                }

                                "modifier" -> {

                                    MonButton("Annuler", Icons.Filled.Clear, { shouldShowDialog.value = true })
                                    Spacer(modifier = Modifier.padding(8.dp))
                                    MonButton("Appliquer", Icons.Filled.Done, { shouldShowDialog.value = true })
                                }
                            }

                        }



                    }
                    Column{

                        Row(
                            horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                        ) {

                          Column (horizontalAlignment = Alignment.CenterHorizontally){
                              Spacer(modifier = Modifier.padding(8.dp))
                              Image(

                                  painter = painterResource(Images.value),

                                  contentDescription = "moi",
                                  modifier = Modifier
                                      .shadow(elevation = 2.dp, shape = CircleShape)
                                      .size(150.dp)
                              )


                              Button(onClick = {
                                               Images.value = "moi.jpg"
                              },
                                  shape = RoundedCornerShape(30.dp),

                                  colors = ButtonDefaults.buttonColors(backgroundColor = Color(87, 102, 100), contentColor = Color.White)



                              )
                              {
                                  Text(text ="ajouter")
                              }

                          }





                        }



                    }

                }




        }}


    }

}