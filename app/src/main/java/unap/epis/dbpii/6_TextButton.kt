package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextButtonDemo() {
    var verMas by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "TextButton: botón de baja prioridad, solo texto",
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = "Jetpack Compose permite construir interfaces escribiendo funciones.")
        if (verMas) {
            Text(text = "Cada función describe cómo se ve la pantalla para un estado dado.")
        }
        TextButton(onClick = { verMas = !verMas }) {
            Text(if (verMas) "Ver menos" else "Ver más")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TextButtonDemoPreview() {
    MaterialTheme {
        TextButtonDemo()
    }
}
