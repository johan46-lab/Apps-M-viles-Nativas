package com.example.app_perfumera


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

// 1. PANTALLA DE INICIO
@Composable
fun PerfumeHomeScreen(onNavigateToCatalog: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("ELEGANCE PARFUM", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Tu destino exclusivo para fragancias de lujo.", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(48.dp))
            Button(onClick = onNavigateToCatalog, modifier = Modifier.fillMaxWidth().height(56.dp)) {
                Text("VER CATÁLOGO (Grid)")
            }
        }
    }
}

// 2. PANTALLA DE CATÁLOGO (GRID)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfumeGridScreen(lista: List<Perfume>, onPerfumeSelected: (Perfume) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Colección Exclusiva") }) }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(padding).fillMaxSize().padding(4.dp)
        ) {
            items(lista) { perfume ->
                PerfumeItem(perfume = perfume, onClick = { onPerfumeSelected(perfume) })
            }
        }
    }
}

// 3. PANTALLA DE DETALLE
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfumeDetailScreen(perfume: Perfume, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(perfume.nombre) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Card(shape = MaterialTheme.shapes.large) {
                AsyncImage(
                    model = perfume.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    contentScale = ContentScale.Crop,
                    onError = { println("Error cargando: ${it.result.throwable}") }


                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = perfume.marca, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
            Text(text = perfume.nombre, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
            Text(text = "$${perfume.precio}", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.secondary)

            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

            Text(text = "Especificaciones", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Presentación: ${perfume.volumen}")
            Text(text = "Notas: ${perfume.notasOlfativas}")

            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text("Añadir al Carrito")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfumeCatalogPreview() {
    // Aquí llamas a la función que quieres ver
    PerfumeGridScreen(lista = PerfumeData.listaPerfumes, onPerfumeSelected = {})
}