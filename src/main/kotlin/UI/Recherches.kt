package UI

import Models.Competence
import Models.Confidentielles
import Models.InfoPerso
import Models.InfoPro
import UI.PersList.persList
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object ApercuRecherches{
    var infoPerso = mutableStateOf(
        InfoPerso("",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""))
    var infoPro = mutableStateOf(InfoPro(
        "",
        false,
        false,
        0,
        "",
        false))
    var confidentielles = mutableStateOf(Confidentielles(
        false,
        false,
        false,
        false,
        0,
        false,
        false))
    var competence = mutableStateOf(Competence("", false))
}

@Composable
fun Recherches() {
    var selectedItems by remember { mutableStateOf(emptySet<Int>()) }
    val sel = 0..persList.size
    val selLi = mutableStateOf(mutableListOf<Int>())
    for (i in sel)
        selLi.value.add(i)
    val el = mutableStateOf<Int?>(null)
    val backgroundColor = mutableStateOf(Color.Gray)
    val del = mutableStateOf(el.value)


    Column(modifier = Modifier.fillMaxHeight()) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            /*FloatingActionButton(
                backgroundColor = Color(87, 102, 100),
                onClick = { Routes.Nav1.value = 3 },
                modifier = Modifier.padding(16.dp),
                content = {
                    // Image(imageVector = Icons.Default.ArrowBack, contentDescription = null,)
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                })
*/
            PageTitle("Recherches")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp).fillMaxWidth()
        ) {
            SearchBar()


        }


        Row {
            LazyColumn(modifier = Modifier.weight(1F)) {


                    itemsIndexed(persList) { index, item ->

                        KardPersonnel(
                            item.name,
                            item.desc,
                            item.image,
                            item.nav,

                            { el.value = index }
                        )


                    }




            }



                Column(modifier = Modifier.weight(1F)) {
                    Apercu( )
                }
            }


        }

    }









@Composable
fun SearchBar()
{
    Box(modifier = Modifier.width(350.dp).height(50.dp)
        .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(50.dp))

    )
    {


    val textState = remember { mutableStateOf("") }
    Box{
        BasicTextField(
            value = textState.value,
            maxLines = 1,
            onValueChange = {
                textState.value = it},
            textStyle = TextStyle(fontSize = 16.sp,),
            decorationBox = { innerTextField ->
                Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.padding(8.dp).fillMaxWidth())
                {
                    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()){
                        Icon(imageVector = Icons.Filled.Search, contentDescription = null, tint = Color.Black)
                        innerTextField()

                    }
                }
            }
        )
    }

}  }