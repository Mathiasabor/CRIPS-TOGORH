package UI.Absence

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun calend()
{
    var onDateSelected : (Calendar)-> Unit
    val selectedDate = remember { mutableStateOf(Calendar.getInstance()) }
    val monthOffset = remember { mutableStateOf(0) }
    onDateSelected = {selectedDate.value = it}
    var mois = remember { mutableStateOf(SimpleDateFormat("MMMM").format(selectedDate.value.time)) }

    Row (modifier = Modifier.fillMaxWidth())
    {

        Row (modifier = Modifier.weight(0.3f), verticalAlignment = Alignment.CenterVertically){
            IconButton(onClick = {

                monthOffset.value--

            }){
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
            }
            IconButton(onClick = {
                monthOffset.value++
                onDateSelected = {selectedDate.value = it}
            }){
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
            }

            Text(text= mois.value, fontSize = 20.sp)
        }

        Row (modifier = Modifier.weight(0.3f),verticalAlignment = Alignment.CenterVertically){
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
            }
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
            }

            Text(text = SimpleDateFormat("yyyy").format(selectedDate.value.time), fontSize = 20.sp)
        }

        Row (modifier = Modifier.weight(0.3f),verticalAlignment = Alignment.CenterVertically){
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "")
            }
            IconButton(onClick = {}){
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
            }

            Text("Janvier", fontSize = 20.sp)
        }

    }
    Divider(color = Color.Blue, thickness = 3.dp)




    val density = LocalDensity.current.density

    val daysOfWeek = SimpleDateFormat("EEEE", Locale.getDefault()).let {
        (1..7).map { dayOfWeek ->
            it.format(Calendar.getInstance().apply { set(Calendar.DAY_OF_WEEK, dayOfWeek) }.time)
        }
    }

    val monthDays = buildList {
        val calendar = selectedDate.value.clone() as Calendar
        calendar.add(Calendar.MONTH, monthOffset.value)

        val firstDayOfMonth = calendar.clone() as Calendar
        firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1)

        val lastDayOfMonth = calendar.clone() as Calendar
        lastDayOfMonth.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))

        val startOffset = firstDayOfMonth.get(Calendar.DAY_OF_WEEK) - 1
        val totalDays = lastDayOfMonth.get(Calendar.DAY_OF_MONTH)

        addAll(List(startOffset) { null }) // Days of previous month
        addAll((1..totalDays).map { day ->
            calendar.set(Calendar.DAY_OF_MONTH, day)
            calendar.clone() as Calendar
        })
        addAll(List((7 - (totalDays + startOffset) % 7) % 7) { null }) // Days of next month
    }






        LazyColumn  (
            modifier = Modifier.padding(10.dp)){
            items(monthDays.chunked(7)){week->
                var dayMap = week.zip(daysOfWeek).toMap()

                for (jour in week) {

                    if (jour != null) {
                        calendItem(jour,dayMap[jour] )
                    }



                }
            }
        }




}

@Composable
fun calendItem(date: Calendar?, jour :String?)
{
    Button(onClick = {},modifier = Modifier.padding(10.dp), shape = RoundedCornerShape(3.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)) {

            Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(5.dp)){
                if (jour != null) {
                    Text(jour, color = Color.White, fontSize = 15.sp)
                }
                Spacer(modifier = Modifier.padding(30.dp))
                Text("2 événements", color = Color.White, fontSize = 15.sp)
                Spacer(modifier = Modifier.padding(30.dp))
                Badge {
                    Text(date!!.get(Calendar.DAY_OF_MONTH).toString(),  fontSize = 15.sp)
                }

            }

    }
}

fun Calendar.isSameDay(other: Calendar): Boolean {
    return this[Calendar.YEAR] == other[Calendar.YEAR] &&
            this[Calendar.MONTH] == other[Calendar.MONTH] &&
            this[Calendar.DAY_OF_MONTH] == other[Calendar.DAY_OF_MONTH]
}