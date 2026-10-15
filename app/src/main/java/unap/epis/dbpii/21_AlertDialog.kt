package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
fun AlertDialogDemo() {
    var mostrar by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf("Sin acción") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "AlertDialog: pide confirmar una decisión",
            style = MaterialTheme.typography.titleMedium
        )
        Button(onClick = { mostrar = true }) {
            Text("Eliminar archivo")
        }
        Text(text = "Resultado: $resultado")
    }

    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            title = { Text("¿Eliminar archivo?") },
            text = { Text("Esta acción no se puede deshacer.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        resultado = "Archivo eliminado"
                        mostrar = false
                    }
                ) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        resultado = "Cancelado"
                        mostrar = false
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlertDialogDemoPreview() {
    MaterialTheme {
        AlertDialogDemo()
    }
}
