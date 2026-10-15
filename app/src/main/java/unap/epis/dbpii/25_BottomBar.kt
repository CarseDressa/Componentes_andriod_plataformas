package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private data class DestinoInferior(val titulo: String, val icono: ImageVector)

@Composable
fun BottomBarDemo() {
    val destinos = listOf(
        DestinoInferior("Inicio", Icons.Filled.Home),
        DestinoInferior("Buscar", Icons.Filled.Search),
        DestinoInferior("Perfil", Icons.Filled.Person)
    )
    var seleccionado by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                destinos.forEachIndexed { indice, destino ->
                    NavigationBarItem(
                        selected = seleccionado == indice,
                        onClick = { seleccionado = indice },
                        icon = {
                            Icon(
                                imageVector = destino.icono,
                                contentDescription = destino.titulo
                            )
                        },
                        label = { Text(destino.titulo) }
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
                text = "BottomBar: barra inferior para cambiar de sección",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = "Sección actual: ${destinos[seleccionado].titulo}")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BottomBarDemoPreview() {
    MaterialTheme {
        BottomBarDemo()
    }
}
