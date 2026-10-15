package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
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
fun RangeSliderDemo() {
    var rango by remember { mutableStateOf(20f..80f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "RangeSlider: elige un mínimo y un máximo",
            style = MaterialTheme.typography.titleMedium
        )
        RangeSlider(
            value = rango,
            onValueChange = { rango = it },
            valueRange = 0f..100f
        )
        Text(text = "Precio entre ${rango.start.toInt()} y ${rango.endInclusive.toInt()}")
    }
}

@Preview(showSystemUi = true)
@Composable
fun RangeSliderDemoPreview() {
    MaterialTheme {
        RangeSliderDemo()
    }
}
