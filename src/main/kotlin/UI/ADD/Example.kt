package UI.ADD

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.io.File
import javax.swing.JFileChooser

@Composable
fun MyLazyColumn(items: List<String>)
{
    val mutableItems = remember { mutableStateListOf(*items.toTypedArray()) }
    LazyColumn {
        itemsIndexed(mutableItems) { index, item ->
            Text(text = item, modifier = Modifier.padding(16.dp))
            IconButton(onClick = { mutableItems.removeAt(index) }) {
                Icon(Icons.Filled.Delete, contentDescription = "Supprimer")
            }
        }
    }

    Row(modifier = Modifier.padding(16.dp)) {
        var newItem by remember { mutableStateOf("") }
        TextField(
            value = newItem,
            onValueChange = { newItem = it },
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = {
            mutableItems.add(newItem)
            newItem = ""
        }) {
            Icon(Icons.Filled.Add, contentDescription = "Ajouter")
        }
    }
}

@Composable
fun MyLazyColumnt(items: List<String>)
{

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



    val mutableItems = remember { mutableStateListOf(*items.toTypedArray()) }

    Column {

        Row(modifier = Modifier.padding(16.dp)) {
            var newItem by remember { mutableStateOf("") }
            TextField(
                value = newItem,
                onValueChange = { newItem = it },
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = {
                mutableItems.add(newItem)
                newItem = ""
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Ajouter")
            }
        }

        LazyColumn {
            itemsIndexed(mutableItems) { index, item ->
                Text(text = item, modifier = Modifier.padding(16.dp))
                IconButton(onClick = { mutableItems.removeAt(index) }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Supprimer")
                }
            }
        }

    }






}
