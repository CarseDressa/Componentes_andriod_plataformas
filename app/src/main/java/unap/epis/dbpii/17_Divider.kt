package unap.epis.dbpii

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DividerDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Divider: línea que separa contenido",
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = "Sección uno")
        HorizontalDivider()
        Text(text = "Sección dos")
        HorizontalDivider(
            thickness = 4.dp,
            color = MaterialTheme.colorScheme.primary
        )
        Text(text = "Sección tres")
        Row(
            modifier = Modifier.height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Izquierda")
            VerticalDivider(modifier = Modifier.fillMaxHeight())
            Text(text = "Derecha")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DividerDemoPreview() {
    MaterialTheme {
        DividerDemo()
    }
}
