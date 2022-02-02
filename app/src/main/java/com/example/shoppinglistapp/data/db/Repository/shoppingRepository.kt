package com.example.shoppinglistapp.data.db.Repository

import com.example.shoppinglistapp.data.db.ShoppingDatabase
import com.example.shoppinglistapp.data.db.entity.ShoppingItem

class shoppingRepository (
    private val db :ShoppingDatabase
    ){
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) =db.getShoppingDao().delete(item)

    fun getAllShoppingitem() = db.getShoppingDao().getAllShoppingItem()

}