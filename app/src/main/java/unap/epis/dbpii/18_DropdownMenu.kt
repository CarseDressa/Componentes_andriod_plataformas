package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
fun DropdownMenuDemo() {
    var expandido by remember { mutableStateOf(false) }
    var seleccion by remember { mutableStateOf("Ninguna") }
    val opciones = listOf("Kotlin", "Java", "Swift")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "DropdownMenu: lista desplegable de opciones",
            style = MaterialTheme.typography.titleMedium
        )
        Box {
            OutlinedButton(onClick = { expandido = true }) {
                Text("Elegir lenguaje")
            }
            DropdownMenu(
                expanded = expandido,
                onDismissRequest = { expandido = false }
            ) {
                opciones.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            seleccion = opcion
                            expandido = false
                        }
                    )
                }
            }
        }
        Text(text = "Seleccionado: $seleccion")
    }
}

@Preview(showSystemUi = true)
@Composable
fun DropdownMenuDemoPreview() {
    MaterialTheme {
        DropdownMenuDemo()
    }
}
