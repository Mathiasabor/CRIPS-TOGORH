package UI.DashBoard.Component

import Models.Departement
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.min


object diagr{
    val charty = mutableListOf(
        Departement("Conseil d'Administration",3),
        Departement("Assemblée Générale",3),
        Departement("Laboratoire",3),
        Departement("Comptabilité",3),
        Departement("Suivi Evamuation",3),
        Departement("Sécrétariat",3),
        Departement("Caisse",3),
        Departement("Pharmacie",3),
        Departement("Infirmerie",3),
        Departement("Psychologie",3),


    )
}


@Composable

internal fun ServiceChartSize(

    modifier: Modifier = Modifier,
    colors: List<Color>,
    inputValues : List<Float>,
    textColor: Color = MaterialTheme.colors.primary,
    animated: Boolean =true,
    enableClickInfo : Boolean = true
)
{
val chartDegree = 360f
    var startAngle = 260f

    val proportions = inputValues.map {
        it*100 /inputValues.sum()
    }

    val angleProgress = proportions.map{prop->
        chartDegree * prop /100
    }

   // var clickedItemIndex by remember { mutableStateOf(emptyIndex) }

    val progressSize = mutableListOf<Float>()

    LaunchedEffect(angleProgress){
        progressSize.add(angleProgress.first())
        for(x in 1 until angleProgress.size){
            progressSize.add(angleProgress[x] + progressSize[x -1 ])
        }
    }


    BoxWithConstraints(modifier = modifier, contentAlignment = Alignment.Center){
            val canvasSize = min(constraints.maxWidth, constraints.maxHeight)
        val size = Size(canvasSize.toFloat(), canvasSize.toFloat())
        val canvasSIzeDp = with(LocalDensity.current){
            canvasSize.toDp()
        }

        Canvas(modifier = Modifier.size(canvasSIzeDp)){
            angleProgress.forEachIndexed{index, angle ->

                drawArc(
                    color = colors[index],
                    startAngle = startAngle,
                    sweepAngle = angle,
                    useCenter = true,
                    size = size,
                    style = Fill
                )
                startAngle += angle

            }


        }
    }
}

@Composable

fun serviceSize()
{
    val chartColors = listOf(
        MaterialTheme.colors.primary,
        MaterialTheme.colors.primaryVariant,
        MaterialTheme.colors.secondary
    )

    val chartValues = listOf(60f, 110f, 20f)

    ServiceChartSize(
        modifier = Modifier.padding(20.dp),
        colors = chartColors,
        inputValues = chartValues )
}