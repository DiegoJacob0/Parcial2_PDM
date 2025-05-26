package com.yo.parcial2.ViewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.yo.parcial2.data.Product
import com.yo.parcial2.data.ProductRepository

class ProductViewModel : ViewModel() {
    private val _allPets = ProductRepository.productLists

    var searchQuery by mutableStateOf("")
    val products: List<Product>
        get() = if (searchQuery.isBlank()) _allPets
        else _allPets.filter {
            it.name.contains(searchQuery, ignoreCase = true) ||
                    it.category.contains(searchQuery, ignoreCase = true)
        }

    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    fun getPetById(id: Int): Product? = _allPets.find { it.id == id }
    val cartViewModel = CartViewModel()

}
