package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BadgedBoxDemo() {
    var cantidad by remember { mutableStateOf(3) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "BadgedBox: coloca una insignia sobre otro elemento",
            style = MaterialTheme.typography.titleMedium
        )
        BadgedBox(
            badge = {
                if (cantidad > 0) {
                    Badge { Text(text = cantidad.toString()) }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notificaciones"
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { cantidad++ }) {
                Text("Agregar")
            }
            OutlinedButton(onClick = { cantidad = 0 }) {
                Text("Leer todo")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BadgedBoxDemoPreview() {
    MaterialTheme {
        BadgedBoxDemo()
    }
}
