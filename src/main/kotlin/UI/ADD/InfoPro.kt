package UI.ADD

import Controller.PdfElement._pdfitem
import Controller.PdfElement.pdfitems
import UI.ADD.infpro.Nssocial
import UI.Choosepdf
import UI.Openstate
import UI.Oper
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.io.File
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

object infpro{
    var Fonction : String? = null
    var CV : Boolean? = null
    var Motivation : Boolean? = null
    var Nssocial = mutableStateOf("")
    var Casierju : String? = null
    var Casi : Boolean? = null
}

@Composable
fun InfoPro()
{

    val fonctions = listOf("Directeur", "Coordonatrice", " RAF ", "Comptable", "Assistant Médical", "Infirmière")
    val Casier = listOf("Vide", "B1","B2","Inoffensif","Inexistant","Partiel","Complet")


    Row(horizontalArrangement = Arrangement.SpaceBetween,

        modifier = Modifier.padding(8.dp))
    {
        Surface(modifier = Modifier.weight(1F)) {



            Row (modifier = Modifier.padding(8.dp)){
                Column {

                    MyContent(fonctions, "Fonctions", 0.dp, 280.dp)
                    ChoixElement("Lettre de motivation")


                }
                Spacer(modifier = Modifier.padding(20.dp))

                Column {

                    MyContent(Casier, "Casier judiciare", 0.dp, 280.dp)
                    ChoixElement("Entrer le casier judiciare")



                }

            }


        }
        Surface(modifier = Modifier.weight(1F)) {




            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(8.dp)) {
                Column {

                    FavTextField("N° de sécurité sociale","Entrer le NSS",0.dp,Nssocial.value,{ Nssocial.value = it})
                    ChoixElement("CV")
                }



                Column {
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
    }

}

@Composable
fun Pdfitem(file : File)
{
    Column ( horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.padding(8.dp)){
        Image(painter = painterResource("fichier-pdf.png"), contentDescription = "pdf")
        Text(text =file.name)
    }
}

@Composable
fun Pdfitemt(file : String)
{
    Column ( horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.padding(8.dp)){
        Image(painter = painterResource("fichier-pdf.png"), contentDescription = "pdf")
        Text(text =file)
    }
}