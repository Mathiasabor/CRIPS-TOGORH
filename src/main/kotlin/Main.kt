import UI.Login
import UI.Login.Login
import UI.MainControl
import UI.Openstate
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import java.awt.Dimension
import java.awt.Toolkit

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        /*Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }*/
        MainControl()
    }
}

fun main() = application {
    val maxSize = getScreensize()
    val WindowMaxSize = maxSize.toDp()

    Window(onCloseRequest = ::exitApplication,
        visible = if(Openstate._visible.value == false) false else true,
        resizable = true,//j'ai modifieé ici
        state = WindowState( placement = WindowPlacement.Floating, size = WindowMaxSize, position = WindowPosition(alignment = Alignment.Center)),
        icon = painterResource("AKMA.png"),
        title = "CRIPSRH"

    ) {



        when(Openstate._open.value)
        {
            false ->{
                Window(
                    state = WindowState(position = WindowPosition(alignment = Alignment.Center), size = DpSize(1000.dp, 1000.dp) ),
                    title = "Aperçu", onCloseRequest =  ::exitApplication,
                    visible = if(Openstate._open.value == true) false else true,
                ){


                  //  Login(navHome = {
                     //   Openstate.open.value = true
                     //   Openstate.visible.value = true

                   // })
                    Login(connect = {

                        Openstate.open.value = true
                        Openstate.visible.value = true
                    })
                    // InfoPro()

                    // val drf = listOf<String>()
                    //MyLazyColumnt(drf)





                }
            }
            true ->{

                App()
            }
        }
    }
}
fun getScreensize(): Dimension
{
    return Toolkit.getDefaultToolkit().screenSize
}

fun Dimension.toDp() : DpSize
{
    val density = Toolkit.getDefaultToolkit().screenResolution
    val largeur = Dp((width *96.0 / density).toFloat())
    val hauteur = Dp((height *96.0 / density).toFloat())

    return DpSize(largeur, hauteur)

}