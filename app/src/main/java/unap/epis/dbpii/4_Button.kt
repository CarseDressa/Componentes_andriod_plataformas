package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun ButtonDemo() {
    var clics by remember { mutableStateOf(0) }
    var habilitado by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Button: ejecuta una acción al tocarlo",
            style = MaterialTheme.typography.titleMedium
        )
        Button(
            onClick = { clics++ },
            enabled = habilitado
        ) {
            Text("Sumar clic")
        }
        Text(text = "Clics: $clics")
        Button(onClick = { habilitado = !habilitado }) {
            Text(if (habilitado) "Deshabilitar el botón de arriba" else "Habilitar el botón de arriba")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ButtonDemoPreview() {
    MaterialTheme {
        ButtonDemo()
    }
}
