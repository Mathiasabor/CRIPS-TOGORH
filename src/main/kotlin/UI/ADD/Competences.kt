package UI.ADD

import UI.ADD.Competen.diplome
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object Competen{
    var diplome = mutableStateOf("")
    var dip : Boolean?=null
}
@Composable
fun Competences()
{
    Row(modifier = Modifier.padding(8.dp))
    {
        Surface(modifier = Modifier.weight(1F)) {

            Column {
                FavTextField("Diplôme", "Entrer le diplôme", 0.dp, diplome.value ,onValueChange = { diplome.value = it})
                ChoixElement("Entrer le diplôme")


            }


        }
        Surface(modifier = Modifier.weight(1F)) {


        }
    }

}