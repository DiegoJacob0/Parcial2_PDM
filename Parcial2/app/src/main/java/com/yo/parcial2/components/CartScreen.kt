package com.yo.parcial2.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yo.parcial2.ViewModel.CartViewModel

@Composable
fun CartScreen(cartViewModel: CartViewModel) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Carrito de compras", style = MaterialTheme.typography.headlineMedium)


        Spacer(modifier = Modifier.height(16.dp))

        if (cartItems.isEmpty()) {
            Text("El carrito está vacío.")
        } else {
            LazyColumn {
                items(cartItems) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                            Text(text = "Precio: ${item.price}")
                            Text(text = item.category)
                        }
                    }
                }
            }
        }
    }
}
