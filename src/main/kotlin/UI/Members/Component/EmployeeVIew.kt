package UI.Members.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.awt.image.BufferedImage
import java.net.URL
import javax.imageio.ImageIO


@Composable
fun EmployeeView()
{

    val infod = mutableListOf("Nom","Prénom","Sexe","Nationalité","Date de naissance","N°CNSS","Contrat","Date d'entrée","Date de sortie","Casier judiciaire")



    Card (modifier = Modifier.fillMaxSize().padding(end = 20.dp), elevation = 6.dp, backgroundColor = Color.LightGray){

        Column(modifier = Modifier.fillMaxSize()) {


            Image(

                painter = painterResource("moi.jpg"),
                contentDescription = "moi",
                modifier = Modifier
                    .shadow(elevation = 2.dp, shape = CircleShape)
                    .size(150.dp)
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))
            Row(modifier = Modifier.fillMaxSize()) {

                Column(modifier = Modifier.weight(0.4f).verticalScroll(rememberScrollState())) {
                    infod.forEach {

                        Row (horizontalArrangement = Arrangement.SpaceBetween,

                            modifier = Modifier.fillMaxWidth().padding(5.dp)){
                            Text(it,fontSize = 20.sp)
                            Text(":",fontSize = 20.sp)
                        }

                    }


                }
                Column(modifier = Modifier.weight(0.6f)) {

                }
            }


        }
    }

}