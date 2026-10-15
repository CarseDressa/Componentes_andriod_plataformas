package unap.epis.dbpii

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun ProgressBarAvanzadoDemo() {
    var objetivo by remember { mutableStateOf(0f) }
    var cargando by remember { mutableStateOf(false) }

    val progresoAnimado by animateFloatAsState(
        targetValue = objetivo,
        animationSpec = tween(durationMillis = 400),
        label = "progreso"
    )

    LaunchedEffect(cargando) {
        while (cargando && objetivo < 1f) {
            delay(600)
            objetivo = (objetivo + 0.1f).coerceAtMost(1f)
        }
        if (objetivo >= 1f) cargando = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Progreso avanzado: animado y con carga simulada",
            style = MaterialTheme.typography.titleMedium
        )
        LinearProgressIndicator(
            progress = { progresoAnimado },
            modifier = Modifier.fillMaxWidth()
        )
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { progresoAnimado },
                modifier = Modifier.size(96.dp),
                strokeWidth = 8.dp
            )
            Text(text = "${(progresoAnimado * 100).toInt()}%")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = {
                    if (objetivo >= 1f) objetivo = 0f
                    cargando = !cargando
                }
            ) {
                Text(if (cargando) "Pausar" else "Iniciar")
            }
            OutlinedButton(
                onClick = {
                    cargando = false
                    objetivo = 0f
                }
            ) {
                Text("Reiniciar")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProgressBarAvanzadoDemoPreview() {
    MaterialTheme {
        ProgressBarAvanzadoDemo()
    }
}
