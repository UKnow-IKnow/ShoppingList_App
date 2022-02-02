package com.example.shoppinglistapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglistapp.data.db.Repository.shoppingRepository
import com.example.shoppinglistapp.data.db.entity.ShoppingItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: shoppingRepository
): ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItem() = repository.getAllShoppingitem()
}