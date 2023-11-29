package UI.Absence

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.ui.platform.*

@Composable
fun CalendarApp() {
    var selectedDate = remember { mutableStateOf(Calendar.getInstance()) }
    var monthOffset = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = SimpleDateFormat("MMMM yyyy").format(selectedDate.value.time),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h6
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { monthOffset.value-- }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Previous Month")
                    }
                },
                actions = {
                    IconButton(onClick = { monthOffset.value++ }) {
                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next Month")
                    }
                }
            )
        }
    ) { paddingValues ->
        CalendarContent(
            selectedDate = selectedDate.value,
            onDateSelected = { selectedDate.value = it },
            monthOffset = monthOffset.value,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun CalendarContent(
    selectedDate: Calendar,
    onDateSelected: (Calendar) -> Unit,
    monthOffset: Int = 0,
    modifier: Modifier = Modifier
) {
    //val context = LocalContext.current
    val density = LocalDensity.current.density

    val daysOfWeek = SimpleDateFormat("EEEE", Locale.getDefault()).let {
        (1..7).map { dayOfWeek ->
            it.format(Calendar.getInstance().apply { set(Calendar.DAY_OF_WEEK, dayOfWeek) }.time)
        }
    }

    val monthDays = buildList {
        val calendar = selectedDate.clone() as Calendar
        calendar.add(Calendar.MONTH, monthOffset)

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

    LazyColumn(modifier = modifier) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                daysOfWeek.forEach { day ->
                    Text(
                        text = day.take(3), // Display only the first three letters of the day
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.weight(1f).padding(density.dp)
                        , color = Color.White
                    )
                }
            }
        }

        items(monthDays.chunked(7)) { week ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                week.forEach { day ->
                    if (day != null) {
                        CalendarDay(
                            date = day,
                            isSelected = day.isSameDay(selectedDate),
                            onDateSelected = { onDateSelected(it) }
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun CalendarDay(date: Calendar, isSelected: Boolean, onDateSelected: (Calendar) -> Unit) {
    //val context = LocalContext.current
    val background = if (isSelected) {
        Color.Black
    } else {
        Color.Transparent
    }

    Box(
        modifier = Modifier
            //.weight(1f)
            .aspectRatio(1f)
            .padding(4.dp)
            .clickable { onDateSelected(date) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = date.get(Calendar.DAY_OF_MONTH).toString(),
            color = if (isSelected) Color.White else Color.Black,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .background(background, CircleShape)
                .padding(4.dp)
        )
    }

   /* Row(
        modifier = Modifier
            .scrollable(
                orientation = Orientation.Horizontal,
                // Set the scrollbar thickness
                scrollbarThickness = 8.dp,
                // Set the scrollbar color
                scrollbarColor = Color.Gray
            )
    ) {
        // Add your content here
    }*/

}
/*
fun Calendar.isSameDay(other: Calendar): Boolean {
    return this[Calendar.YEAR] == other[Calendar.YEAR] &&
            this[Calendar.MONTH] == other[Calendar.MONTH] &&
            this[Calendar.DAY_OF_MONTH] == other[Calendar.DAY_OF_MONTH]
}*/