package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackBarDemo() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var resultado by remember { mutableStateOf("Sin acción") }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "SnackBar: mensaje breve temporal con acción opcional",
                style = MaterialTheme.typography.titleMedium
            )
            Button(
                onClick = {
                    scope.launch {
                        val respuesta = snackbarHostState.showSnackbar(
                            message = "Elemento eliminado",
                            actionLabel = "Deshacer",
                            duration = SnackbarDuration.Short
                        )
                        resultado = when (respuesta) {
                            SnackbarResult.ActionPerformed -> "Deshecho"
                            SnackbarResult.Dismissed -> "Se cerró solo"
                        }
                    }
                }
            ) {
                Text("Eliminar elemento")
            }
            Text(text = "Resultado: $resultado")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SnackBarDemoPreview() {
    MaterialTheme {
        SnackBarDemo()
    }
}
