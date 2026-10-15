package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun OutlinedButtonDemo() {
    var cancelado by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "OutlinedButton: botón secundario con borde",
            style = MaterialTheme.typography.titleMedium
        )
        OutlinedButton(onClick = { cancelado = !cancelado }) {
            Text(if (cancelado) "Deshacer" else "Cancelar")
        }
        Text(text = if (cancelado) "Estado: cancelado" else "Estado: activo")
    }
}

@Preview(showSystemUi = true)
@Composable
fun OutlinedButtonDemoPreview() {
    MaterialTheme {
        OutlinedButtonDemo()
    }
}
