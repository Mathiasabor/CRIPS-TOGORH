package UI.ADD

import UI.ADD.Confidentielle.Enfants
import UI.Openstate
import UI.Oper
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


object Confidentielle{
    var CarteIdentite : Boolean? = null
    var CertificatNationalite : Boolean?= null
    var ActeDeNaissance : Boolean?= null
    var CertificatMedical : Boolean?= null
    var Enfants = mutableStateOf("")
    var ActeDeNaissanceEnfant: Boolean?= null
    var CertificatDeVieEnfant : Boolean?= null

}


@Composable
fun Confidentiel()
{
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(8.dp))
    {
        Surface(modifier = Modifier.weight(1F)) {

            Row(modifier = Modifier.padding(8.dp)){
            Column {
                ChoixElement("Carte d'identité")
                ChoixElement("Certificat de Nationalité")


            }
                Spacer(modifier= Modifier.padding(20.dp))
                Column {
                    ChoixElement("Acte de Naissance")
                    ChoixElement("Certificat Médicale")
                }

            }


        }
        Surface(modifier = Modifier.weight(1F)) {

            Row(modifier = Modifier.padding(8.dp))
            {

            Column {

                ChoixElement("Acte de Naissance Enfants")
                ChoixElement("Certificat de Vie des Enfants")





            }

                Spacer(modifier = Modifier.padding(20.dp))
                Column{
                    FavTextField("Enfants","Entrer le nombre d'enfant", 0.dp,Enfants.value,{ Enfants.value = it})

                    Row(verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxHeight()
                            .horizontalScroll(rememberScrollState())
                    ) {

                        // KardPersonnel("AHO KODJO MATHIAS ABOR","","homme.png",0)

                        when (Oper._Nav3.value) {
                            "ajouter" -> {
                                MonButton("Ajouter", Icons.Filled.Add, { Openstate.shouldShowDialog.value = true })
                                Spacer(modifier = Modifier.padding(8.dp))
                                MonButton("Vider", Icons.Filled.Clear, { Openstate.shouldShowDialog.value = true })

                            }

                            "modifier" -> {

                                MonButton("Annuler", Icons.Filled.Clear, { Openstate.shouldShowDialog.value = true })
                                Spacer(modifier = Modifier.padding(8.dp))
                                MonButton("Appliquer", Icons.Filled.Done, { Openstate.shouldShowDialog.value = true })
                            }
                        }

                    }
                }




        }
    }
}}

