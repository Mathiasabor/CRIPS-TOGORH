package UI.ADD

import Models.Evalutation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Evalutation()
{
    Row(modifier = Modifier.padding(8.dp))
    {
        Surface(modifier = Modifier.weight(1F)) {

            Column {
                ChoixElement("Lettre de motivation")


            }


        }
        Surface(modifier = Modifier.weight(1F)) {

            ChoixElement("CV")
        }
    }
}