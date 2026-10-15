package unap.epis.dbpii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class Componente(val nombre: String, val contenido: @Composable () -> Unit)

private val componentes = listOf(
    Componente("Text") { TextDemo() },
    Componente("TextField") { TextFieldDemo() },
    Componente("OutlinedTextField") { OutlinedTextFieldDemo() },
    Componente("Button") { ButtonDemo() },
    Componente("OutlinedButton") { OutlinedButtonDemo() },
    Componente("TextButton") { TextButtonDemo() },
    Componente("Image") { ImageDemo() },
    Componente("Icon") { IconDemo() },
    Componente("ProgressBar (lineal y circular)") { ProgressBarDemo() },
    Componente("ProgressBar avanzado") { ProgressBarAvanzadoDemo() },
    Componente("Switch") { SwitchDemo() },
    Componente("CheckBox") { CheckBoxDemo() },
    Componente("CheckBox con texto") { CheckBoxConTextoDemo() },
    Componente("Card") { CardDemo() },
    Componente("Surface") { SurfaceDemo() },
    Componente("BadgedBox") { BadgedBoxDemo() },
    Componente("Divider") { DividerDemo() },
    Componente("DropdownMenu") { DropdownMenuDemo() },
    Componente("Slider") { SliderDemo() },
    Componente("RangeSlider") { RangeSliderDemo() },
    Componente("AlertDialog") { AlertDialogDemo() },
    Componente("Scaffold") { ScaffoldDemo() },
    Componente("TopAppBar") { TopAppBarDemo() },
    Componente("SnackBar") { SnackBarDemo() },
    Componente("BottomBar") { BottomBarDemo() },
    Componente("FloatingActionButton") { FloatingActionButtonDemo() },
    Componente("ModalNavigationDrawer") { ModalNavigationDrawerDemo() }
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MenuComponentes()
                }
            }
        }
    }
}

@Composable
fun MenuComponentes() {
    var actual by remember { mutableIntStateOf(-1) }

    if (actual >= 0) {
        BackHandler { actual = -1 }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            componentes[actual].contenido()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding(),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    text = "Componentes de Jetpack Compose",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            itemsIndexed(componentes) { indice, componente ->
                OutlinedButton(
                    onClick = { actual = indice },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(componente.nombre)
                }
            }
        }
    }
}
