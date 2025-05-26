package com.yo.parcial2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.yo.parcial2.ViewModel.ProductViewModel
import com.yo.parcial2.components.CartScreen
import com.yo.parcial2.components.ProductInfo
import com.yo.parcial2.components.ProductMain

@Composable
fun Navigation(navController: NavHostController, viewModel: ProductViewModel) {
    NavHost(navController, startDestination = "list") {
        composable("list") {
            ProductMain(navController, viewModel)
        }
        composable("detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull() ?: return@composable
            ProductInfo(
                productId = productId,
                viewModel = viewModel,
                navController = navController,
            )
        }
        composable("cart") {
            CartScreen(cartViewModel = viewModel.cartViewModel)
        }
    }
}
