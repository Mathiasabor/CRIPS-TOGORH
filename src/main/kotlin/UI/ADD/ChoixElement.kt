package UI.ADD

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import java.io.File
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

@Composable
fun ChoixElement(option : String)
{val checked = remember{ mutableStateOf(false) }
    var selectedFile by remember { mutableStateOf<File?>(null) }
    val pdfFilter = FileNameExtensionFilter("PDF files", "pdf")
    val imageFilter = FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif")


    Column {


        Row (horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically,){

            Text(text = option)

            Switch(checked = checked.value, onCheckedChange = {checked.value = it }, colors = SwitchDefaults.colors(checkedThumbColor =  Color(87, 102, 100)))
        }

        Spacer(modifier = Modifier.padding(5.dp))


        Button(onClick = {

            val fileChooser = JFileChooser()
            fileChooser.fileFilter = pdfFilter
             fileChooser.addChoosableFileFilter(imageFilter)
            val result = fileChooser.showOpenDialog(null)
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.selectedFile
            }},
            shape = RoundedCornerShape(30.dp),
            enabled = checked.value,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(87, 102, 100), contentColor = Color.White)


        )
        {
            Text("Charger le fichier")
        }

        selectedFile?.let {file ->
            Pdfitem(file)

        }

        Spacer(modifier = Modifier.padding(5.dp))



    }
}