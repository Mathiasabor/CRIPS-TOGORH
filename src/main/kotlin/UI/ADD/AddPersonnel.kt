package UI.ADD

import UI.Openstate.shouldShowDialog
import UI.Oper._Nav3
import UI.PageTitle
import UI.Routed.Nav2
import UI.Titres._titre
import UI.Titres.titre
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddPersonnel(retour : String)

{
    val selectedTabIndex = remember { mutableStateOf(0) }



    Column(modifier = Modifier.fillMaxHeight()) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            FloatingActionButton(
                backgroundColor = Color(87, 102, 100),
                onClick = { Nav2.value = "Personnel"
                          titre.value =retour

                          },
                modifier = Modifier.padding(16.dp),
                content = {
                    // Image(imageVector = Icons.Default.ArrowBack, contentDescription = null,)
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                })

            PageTitle(_titre.value)
        }



        TabRow(selectedTabIndex = selectedTabIndex.value, backgroundColor = Color(87, 102, 100), contentColor = Color.White) {
            Tab(
                selected = selectedTabIndex.value == 0,
                onClick = { selectedTabIndex.value = 0 },

            ) {
                Text("Informations Personnelles", modifier = Modifier.padding(5.dp))
            }
            Tab(
                selected = selectedTabIndex.value == 1,
                onClick = { selectedTabIndex.value = 1 },

            ) {
                Text("Informations Professionnelles", modifier = Modifier.padding(5.dp))
            }

            Tab(
                selected = selectedTabIndex.value == 2,
                onClick = { selectedTabIndex.value = 2 },

            ) {
                Text("Formations & Compétences", modifier = Modifier.padding(5.dp))
            }
            Tab(
                selected = selectedTabIndex.value == 3,
                onClick = { selectedTabIndex.value = 3 },

            ) {
                Text("Informations Confidentielles", modifier = Modifier.padding(5.dp))
            }


            Tab(
                selected = selectedTabIndex.value == 4,
                onClick = { selectedTabIndex.value = 4 },

            ) {
                Text("Salaire & Avantages Sociaux", modifier = Modifier.padding(5.dp))
            }

            Tab(
                selected = selectedTabIndex.value == 5,
                onClick = { selectedTabIndex.value = 5 },

            ) {
                Text("Congés & Absences", modifier = Modifier.padding(5.dp))
            }

            Tab(
                selected = selectedTabIndex.value == 6,
                onClick = { selectedTabIndex.value = 6 },

            ) {
                Text("Evaluations & Performances", modifier = Modifier.padding(5.dp))
            }
        }

        when (selectedTabIndex.value) {
            0 -> {

                InfoPerso()
            }
            1 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                InfoPro()
            }

            }


            2 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Competences()
            }

            }
            3 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))

                Confidentiel()
            }

            }
            4 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Text("Contenu de l'onglet 2")
            }

            }
            5 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Text("Contenu de l'onglet 2")
            }

            }
            6 -> { Column(modifier = Modifier.padding(20.dp).fillMaxHeight()) {
                //Spacer(modifier = Modifier.padding( 20.dp))
                Text("Contenu de l'onglet 2")
            }

            }


        }



    }


    if(shouldShowDialog.value)
    {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false

            },
            title = {
                Text(text = "Alert")
            },
            text = {

                Text(text = "This is an example AlertDialog.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        shouldShowDialog.value = false
                        // Handle the positive button action here
                    }
                ) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        shouldShowDialog.value = false
                        // Handle the positive button action here
                    }
                ) {
                    Text(text = "cancel")
                }

            }

        )
    }
}


@Composable
fun FavTextField(label : String, placeholder : String, padding: Dp, textState : String, onValueChange :(String)->Unit)
{

    OutlinedTextField(
        value = textState,
        onValueChange = onValueChange,
        label = {Text(text =label)},
        placeholder = { Text(placeholder) },

        keyboardActions = KeyboardActions(onDone = null),
        modifier = Modifier
           .width(312.dp)
           .padding(padding)


    )
}

@Composable
fun MyContent(Elements : List<String>, labeld: String, padding: Dp, width : Dp){

    // Declaring a boolean value to store
    // the expanded state of the Text Field
    val mExpanded = remember { mutableStateOf(false) }

    // Create a list of cities
    val mCities = Elements

    // Create a string value to store the selected city
    val mSelectedText = remember { mutableStateOf("") }

    val mTextFieldSize = remember { mutableStateOf(Size.Zero)}

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded.value)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(padding)) {

        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText.value,
            onValueChange = {newvl ->
                mSelectedText.value = newvl },
            modifier = Modifier
                .width(width)
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize.value = coordinates.size.toSize()
                },
            enabled = false,
            label = {Text(text = labeld)},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded.value = !mExpanded.value })
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded.value,
            onDismissRequest = { mExpanded.value = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.value.width.toDp()})
        ) {
            mCities.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText.value = label
                    mExpanded.value = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}

@Composable
fun MonButton(label : String, icond : ImageVector, oncli :()->Unit)
{
    ExtendedFloatingActionButton(
        onClick = { oncli() },
        icon = { Icon(icond, "Localized description") },
        text = { Text(text = label) },
        backgroundColor= Color(87, 102, 100),
        contentColor= Color.White,
      //  modifier = Modifier.padding(16.dp)
    )
}