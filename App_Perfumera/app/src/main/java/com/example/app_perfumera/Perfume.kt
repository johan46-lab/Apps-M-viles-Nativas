package com.example.app_perfumera




data class Perfume(
    val id: Int,
    val nombre: String,
    val marca: String,
    val precio: Double,
    val volumen: String, // ej. 100ml
    val notasOlfativas: String, // ej. Amaderado, Cítrico
    val imageUrl: String
)

object PerfumeData {
    val listaPerfumes = listOf(
        Perfume(1, "Sauvage", "Dior", 125.50, "100ml", "Pimienta, Bergamota, Ambroxan", "https://www.dior.com/dw/image/v2/BGXS_PRD/on/demandware.static/-/Sites-dior-master/default/dw4f65c924/Y0996004/Y0996004_E01.jpg"),
        Perfume(2, "Bleu de Chanel", "Chanel", 140.00, "50ml", "Cítricos, Cedro, Sándalo", "https://www.chanel.com/images/t_one//w_600,h_600,c_f_pad/f_auto/bleu-de-chanel-eau-de-parfum-spray-100ml.jpg"),
        Perfume(3, "Eros", "Versace", 95.00, "100ml", "Menta, Manzana Verde, Vainilla", "https://m.media-amazon.com/images/I/51A9I7a7uFL._SL1000_.jpg"),
        Perfume(4, "La Vie Est Belle", "Lancôme", 110.25, "75ml", "Grosella Negra, Iris, Pachulí", "https://m.media-amazon.com/images/I/61M8+q+uI9L._SL1500_.jpg"),
        Perfume(5, "Acqua di Gio", "Giorgio Armani", 105.00, "100ml", "Notas Marinas, Romero, Caqui", "https://m.media-amazon.com/images/I/517iC6Oa+DL._SL1000_.jpg"),
        Perfume(6, "Light Blue", "Dolce & Gabbana", 85.00, "50ml", "Limón Siciliano, Manzana, Cedro", "https://m.media-amazon.com/images/I/61r5T0xQn5L._SL1500_.jpg"),
        Perfume(7, "One Million", "Paco Rabanne", 115.00, "100ml", "Mandarina, Canela, Cuero", "https://m.media-amazon.com/images/I/61Y6T+XkG4L._SL1500_.jpg"),
        Perfume(8, "Good Girl", "Carolina Herrera", 130.00, "80ml", "Almendra, Jazmín, Haba Tonka", "https://m.media-amazon.com/images/I/51GvS7Y5eHL._SL1000_.jpg")
    )
}








