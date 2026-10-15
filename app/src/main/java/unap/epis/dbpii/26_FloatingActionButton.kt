package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
fun FloatingActionButtonDemo() {
    var elementos by remember { mutableStateOf(0) }
    var ediciones by remember { mutableStateOf(0) }

    Scaffold(
        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = androidx.compose.ui.Alignment.End
            ) {
                ExtendedFloatingActionButton(
                    onClick = { ediciones++ },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = null
                        )
                    },
                    text = { Text("Editar") }
                )
                FloatingActionButton(onClick = { elementos++ }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Agregar"
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "FloatingActionButton: acción principal flotante de la pantalla",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = "Elementos agregados: $elementos")
            Text(text = "Ediciones: $ediciones")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FloatingActionButtonDemoPreview() {
    MaterialTheme {
        FloatingActionButtonDemo()
    }
}
