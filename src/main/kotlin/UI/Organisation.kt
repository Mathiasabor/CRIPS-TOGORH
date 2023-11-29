package UI

import UI.Members.Component.Member
import UI.OrgList.orgaList
import UI.Titres._titre
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Organisation()
{
    Column(modifier =  Modifier.fillMaxHeight())
    {
        Row( horizontalArrangement = Arrangement.Start,modifier= Modifier.padding(8.dp).fillMaxWidth() )
        {
            /*FloatingActionButton(onClick = {},modifier= Modifier.padding(5.dp), content = {
                Image(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            })
            Spacer(modifier =Modifier.padding(10.dp))*/
            PageTitle("Organisation")
        }
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(orgaList){it ->
                Kcard(it.name,it.desc,it.image,it.nav)


            }
        }
}}