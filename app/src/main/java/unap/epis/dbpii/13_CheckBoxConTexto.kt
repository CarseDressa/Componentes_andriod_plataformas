package unap.epis.dbpii

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxConTextoDemo() {
    var terminos by remember { mutableStateOf(false) }
    var noticias by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "CheckBox con texto: toda la fila es tocable",
            style = MaterialTheme.typography.titleMedium
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = terminos,
                    onValueChange = { terminos = it },
                    role = Role.Checkbox
                )
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = terminos, onCheckedChange = null)
            Text(
                text = "Acepto los términos y condiciones",
                modifier = Modifier.padding(start = 12.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { noticias = !noticias }
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = noticias, onCheckedChange = { noticias = it })
            Text(
                text = "Recibir noticias por correo",
                modifier = Modifier.padding(start = 12.dp)
            )
        }
        Text(text = "Términos: $terminos | Noticias: $noticias")
    }
}

@Preview(showSystemUi = true)
@Composable
fun CheckBoxConTextoDemoPreview() {
    MaterialTheme {
        CheckBoxConTextoDemo()
    }
}
