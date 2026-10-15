package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderDemo() {
    var volumen by remember { mutableStateOf(40f) }
    var nivel by remember { mutableStateOf(2f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Slider: elige un valor deslizando dentro de un rango",
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = "Volumen: ${volumen.toInt()}")
        Slider(
            value = volumen,
            onValueChange = { volumen = it },
            valueRange = 0f..100f
        )
        Text(text = "Nivel por pasos: ${nivel.toInt()}")
        Slider(
            value = nivel,
            onValueChange = { nivel = it },
            valueRange = 0f..5f,
            steps = 4
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SliderDemoPreview() {
    MaterialTheme {
        SliderDemo()
    }
}
