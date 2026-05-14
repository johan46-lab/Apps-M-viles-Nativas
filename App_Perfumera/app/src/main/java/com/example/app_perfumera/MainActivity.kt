package com.example.app_perfumera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Se puede envolver en un Tema de Material 3 personalizado
            PerfumeApp()
        }
    }
}

@Composable
fun PerfumeApp() {
    // --- GESTIÓN DE ESTADO (State Hoisting) ---
    // Controlamos en qué pantalla estamos
    var currentScreen by remember { mutableStateOf("home") }
    // Controlamos qué perfume se seleccionó para mostrar en detalle
    var selectedPerfume by remember { mutableStateOf<Perfume?>(null) }

    // --- LÓGICA DE NAVEGACIÓN ---
    when (currentScreen) {
        "home" -> PerfumeHomeScreen(
            onNavigateToCatalog = { currentScreen = "grid" }
        )
        "grid" -> PerfumeGridScreen(
            lista = PerfumeData.listaPerfumes,
            onPerfumeSelected = { perfume ->
                selectedPerfume = perfume
                currentScreen = "detail"
            }
        )
        "detail" -> selectedPerfume?.let { perfume ->
            PerfumeDetailScreen(
                perfume = perfume,
                onBack = { currentScreen = "grid" }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfumeAppPreview() {
    PerfumeApp()
}
