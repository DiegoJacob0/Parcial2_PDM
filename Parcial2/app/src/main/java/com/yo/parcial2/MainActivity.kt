package com.yo.parcial2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.yo.parcial2.ViewModel.ProductViewModel
import com.yo.parcial2.navigation.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val petViewModel: ProductViewModel = viewModel()
            Navigation(navController, petViewModel)
        }
    }
}


