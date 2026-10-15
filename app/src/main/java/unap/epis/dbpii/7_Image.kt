package unap.epis.dbpii

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ImageDemo() {
    var tintado by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Image: muestra una imagen o gráfico",
            style = MaterialTheme.typography.titleMedium
        )
        Image(
            imageVector = Icons.Filled.Face,
            contentDescription = "Cara de ejemplo",
            contentScale = ContentScale.Fit,
            colorFilter = if (tintado) ColorFilter.tint(MaterialTheme.colorScheme.primary) else null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .clickable { tintado = !tintado }
        )
        Text(text = "Toca la imagen para teñirla")
    }
}

@Preview(showSystemUi = true)
@Composable
fun ImageDemoPreview() {
    MaterialTheme {
        ImageDemo()
    }
}
