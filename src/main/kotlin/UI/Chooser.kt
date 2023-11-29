package UI

import Controller.PdfElement.pdfitem
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.io.File
import javax.swing.JFileChooser



fun Choosepdf()
{
    var iselectedFile = mutableStateOf<File?>(null)
    val fileChooser = JFileChooser()
    val result = fileChooser.showOpenDialog(null)

    if (result == JFileChooser.APPROVE_OPTION) {
        var selectedFile = fileChooser.selectedFile
        if (selectedFile != null) {
            iselectedFile.value = selectedFile
            pdfitem.value.add(iselectedFile.value!!)
        }
    }
}
@Composable
fun ChooseFile() {
    var iselectedFile by remember { mutableStateOf<File?>(null) }

    Button(onClick = {
        val fileChooser = JFileChooser()
        val result = fileChooser.showOpenDialog(null)

        if (result == JFileChooser.APPROVE_OPTION) {
            var selectedFile = fileChooser.selectedFile
            if (selectedFile != null) {
                iselectedFile = selectedFile
            }
        }

    }) {
        Text("Choose File")
    }

    //Spacer(modifier = Modifier.height(16.dp))

    // Show the selected file path, if available
   /* iselectedFile?.let {
        Text("Selected File: ${it.absolutePath}")

    }*/


}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Choose File Example",
        state = rememberWindowState(width = 800.dp, height = 600.dp)
    ) {
        MaterialTheme {
            ChooseFile()
        }
    }
}