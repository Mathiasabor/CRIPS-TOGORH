package Controller

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toComposeImageBitmap
import java.awt.image.BufferedImage
import java.io.File
import java.net.URL
import javax.imageio.ImageIO

data class PdfComposant(
    val nom : String
)

object PdfElement
{
    var pdfitem = mutableStateOf(mutableListOf<File?>())
    val _pdfitem : State<MutableList<File?>> = pdfitem
    val pdfitems = mutableStateListOf(*pdfitem.value.toTypedArray())
}

@Composable
fun imaged()
{
    var monimage = URL("https://cdn.dribbble.com/users/3213519/screenshots/6844850/matter_details_4x.png?resize=400x0")
    val bufferedImage: BufferedImage = ImageIO.read(monimage)
    Image(bitmap = bufferedImage.toComposeImageBitmap(), contentDescription = "")
}