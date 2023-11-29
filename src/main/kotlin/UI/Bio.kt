package UI

import UI.PersonnelNav.Navpersonnel
import UI.Routed.Nav2
import UI.Routes.Nav1
import UI.Titres.titre
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun Bio()
{


    Column (modifier =  Modifier.fillMaxHeight()) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(8.dp)
                .background(color = Color(87, 102, 100))
                .fillMaxWidth()

        ) {
            Text(
                text = " AHO KODJO MATHIAS ABOR",
                fontSize = 36.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = " Informaticien", color = Color.White)
        }

        /* Card(shape = RectangleShape, elevation = 6.dp, modifier = Modifier.weight(1F))
        {
            DElement(name ="Mémoires",desc ="memoires", image = "programme.png")
        }*/

       /* LazyVerticalGrid(columns = GridCells.Fixed(3),

        content = {
            items(dclist){cof->

                Dcard(cof)
            }
        }
        )*/


    }
}


@Composable
fun Dcard( name : String, qte : String)
{
    Card(shape = RoundedCornerShape(30.dp), backgroundColor = Color(87, 102, 100), elevation = 6.dp, modifier = Modifier.padding(8.dp))
    {
        DElement(name =name, qte = qte)
    }
}


@Composable
fun DElement(name : String, qte : String)
{
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(10.dp)
    ) {

            Text(name, fontSize = 20.sp,  color = Color.White, textDecoration = TextDecoration.Underline)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text =qte, fontSize = 15.sp,  color =  Color.White)

    }
}

@Composable
fun Kitem(name : String, desc : String, image : String, colord : Color)
{
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp,10.dp, 30.dp,10.dp)
    ) {

        Image(
            painter = painterResource(image),
            contentDescription = desc,
            modifier = Modifier.shadow(elevation = 0.dp, shape = RectangleShape).size(64.dp))
        Spacer(modifier = Modifier.padding(8.dp))
        Text(name, fontSize = 20.sp, color = colord, maxLines = 1, overflow = TextOverflow.Clip)

    }
}

//qui s'affiche au menu de organisation
@Composable
fun Kcard(name : String, desc : String, image : String, nav : String, colors : Pair<Color,Color> = Pair(Color(87, 102, 100),
    Color.White))
{
    Card(shape = RoundedCornerShape(30.dp),
        backgroundColor = colors.first,
        elevation = 6.dp,
        modifier = Modifier.padding(8.dp)
            .clickable {
                Nav1.value = 3
                Nav2.value = "Personnel"
               titre.value =nav
                Navpersonnel.value = nav

            }
    )
    {
        Kitem(name , desc , image, colors.second )
    }

   /* Button(onClick = {Nav2.value = nav},
        shape = RoundedCornerShape(30.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colors.first),
        modifier = Modifier.padding(8.dp)

    ){
        Kitem(name , desc , image, colors.second )
    }*/
}

fun generateRandomColors(): Pair<Color, Color> {
    val randomBackground = Color(
        red = (0..255).random() / 255f,
        green = (0..255).random() / 255f,
        blue = (0..255).random() / 255f
    )

    val randomText = if (randomBackground.luminance() > 0.5f) {
        Color.Black
    } else {
        Color.White
    }

    return Pair(randomBackground, randomText)
}