package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
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
fun ProgressBarDemo() {
    var progreso by remember { mutableStateOf(0.3f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "ProgressIndicator: muestra el avance de una tarea",
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = "Lineal con progreso: ${(progreso * 100).toInt()}%")
        LinearProgressIndicator(
            progress = { progreso },
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Circular con progreso")
        CircularProgressIndicator(progress = { progreso })
        Text(text = "Lineal indeterminado")
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        Text(text = "Circular indeterminado")
        CircularProgressIndicator()
        Button(onClick = { progreso = if (progreso >= 1f) 0f else progreso + 0.1f }) {
            Text("Avanzar 10%")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProgressBarDemoPreview() {
    MaterialTheme {
        ProgressBarDemo()
    }
}
