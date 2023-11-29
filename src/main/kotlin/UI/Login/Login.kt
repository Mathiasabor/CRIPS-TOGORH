package UI.Login

import UI.ADD.FavTextField
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun Login(connect : ()->Unit)
{
    val icon = Pair("oeil.png","cache.png")
    val trans = Pair(VisualTransformation.None, PasswordVisualTransformation())
    val vitrans = remember {mutableStateOf(trans.first)}

    val iconFill = remember{ mutableStateOf(icon.second)}
    val textUser = mutableStateOf("")
    val textPass = mutableStateOf("")
    Box (modifier = Modifier.fillMaxSize()){
        Box (modifier = Modifier.fillMaxSize()){
                Row {
                   // Box(modifier = Modifier.background(color = Color.Cyan).fillMaxSize().weight(0.5f))
                    Box(modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(
                        mutableListOf(Color.Black, Color.Cyan))))
                }
        }

        Box (modifier = Modifier.fillMaxSize()){

            Surface(modifier = Modifier.size(1000.dp).align(Alignment.Center), elevation = 10.dp) {

                Row {
                  //  Box(modifier = Modifier.background(color = Color.Blue).fillMaxSize().weight(0.5f))
                    Box(modifier = Modifier.fillMaxSize().background(brush = Brush.horizontalGradient(
                        mutableListOf(Color.Cyan,Color.Black))))
                }

            }
        }

        Box (modifier = Modifier.fillMaxSize()){

            Surface(modifier = Modifier.size(1000.dp).align(Alignment.Center), color = Color.Transparent) {







                    Box(modifier = Modifier.padding(20.dp).fillMaxSize()){

                        Column (horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(30.dp).align(Alignment.TopCenter)){
                            Image(painter = painterResource("loginicon.png"), contentDescription = "", colorFilter = ColorFilter.tint(color = Color.White))
                            Text("Connectez-vous", fontSize = 20.sp, color = Color.White)
                        }



                         Column (modifier = Modifier.padding(30.dp).align(Alignment.Center)){


                            Spacer(modifier = Modifier.padding(100.dp))


                            OutlinedTextField(value = textUser.value,
                                onValueChange = {textUser.value = it},
                                label = { Text("Email")},
                                textStyle = TextStyle(fontSize = 30.sp),
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth().height(120.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = TextFieldDefaults.textFieldColors(textColor = Color.White, unfocusedIndicatorColor = Color.White, unfocusedLabelColor = Color.White),
                                leadingIcon = { Icon(painter = painterResource("fielduser.png"), contentDescription = "",tint = Color.White)},



                                )
                            Spacer(modifier = Modifier.padding(30.dp))

                            OutlinedTextField(value = textPass.value,
                                onValueChange = {textPass.value = it},
                                label = { Text("Mot de passe")},
                                textStyle = TextStyle(fontSize = 30.sp),
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth().height(120.dp),
                                shape = RoundedCornerShape(50.dp),
                                colors = TextFieldDefaults.textFieldColors(textColor = Color.White, unfocusedIndicatorColor = Color.White, unfocusedLabelColor = Color.White),
                                leadingIcon = { Icon(painter = painterResource("fermer-a-cle.png"), contentDescription = "",tint = Color.White)},
                                trailingIcon = { IconButton(onClick = { if(iconFill.value == icon.second) {
                                    iconFill.value = icon.first
                                    vitrans.value = trans.second

                                }

                                else {iconFill.value = icon.second
                                    vitrans.value = trans.first

                                }


                                }

                                ){
                                    MyIconPersonnalise(iconFill)
                                } },
                                visualTransformation = vitrans.value





                            )

                            Spacer(modifier = Modifier.padding(30.dp))

                            Button(onClick = { connect()

                                             },
                                shape = RoundedCornerShape(50.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp)
                                    .padding(start = 50.dp, end = 50.dp)){
                                Text("Connexion")
                            }


                        }
                    }




            }


        }

    }
}

@Composable

fun MyIconPersonnalise(iconFill : MutableState<String>)
{
    Icon(painter = painterResource(iconFill.value), contentDescription = "", tint = Color.White)
}

