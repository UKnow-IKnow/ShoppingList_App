package com.example.shoppinglistapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistapp.data.db.Repository.shoppingRepository


@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
     private val repository: shoppingRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T

    }
}

