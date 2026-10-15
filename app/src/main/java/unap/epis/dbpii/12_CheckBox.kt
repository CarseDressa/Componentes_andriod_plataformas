package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
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
fun CheckBoxDemo() {
    var marcado by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "CheckBox: marca o desmarca una opción",
            style = MaterialTheme.typography.titleMedium
        )
        Checkbox(
            checked = marcado,
            onCheckedChange = { marcado = it }
        )
        Text(text = if (marcado) "Opción marcada" else "Opción sin marcar")
    }
}

@Preview(showSystemUi = true)
@Composable
fun CheckBoxDemoPreview() {
    MaterialTheme {
        CheckBoxDemo()
    }
}
