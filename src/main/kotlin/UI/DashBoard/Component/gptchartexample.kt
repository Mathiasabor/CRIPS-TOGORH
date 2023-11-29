package UI.DashBoard.Component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp



@Composable
fun BarChart() {
    var data by remember { mutableStateOf(listOf(50f, 80f, 30f, 120f)) }
    var newData by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Gray.copy(alpha = 0.1f))
        ) {
            drawBars(data)
        }

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = newData,
            onValueChange = {
                newData = it
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            textStyle = TextStyle(fontFamily = FontFamily.Cursive),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Gray)
                .padding(16.dp)
                .onGloballyPositioned {
                    // Automatically request focus when the TextField is first laid out
                    focusManager.clearFocus()
                }
        )

        Button(
            onClick = {
                // Add the new data to the list and reset the input field
                if (newData.isNotEmpty()) {
                    data = data + newData.toFloat()
                    newData = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Data")
        }
    }
}


private fun DrawScope.drawBars(data: List<Float>) {

    val barWidth = size.width / data.size
    val maxValue = data.maxOrNull() ?: 1f

    data.forEachIndexed { index, value ->
        val barHeight = size.height * (value / maxValue)
        val barOffsetX = index * barWidth
        val barOffsetY = size.height - barHeight

        drawRoundRect(
            color = Color.Green,
            size = Size(barWidth, barHeight),
            topLeft = Offset(barOffsetX, barOffsetY),
            cornerRadius = CornerRadius(4f)
        )
    }


}


@Preview()
@Composable
fun BarChartPreview() {

        BarChart()

}