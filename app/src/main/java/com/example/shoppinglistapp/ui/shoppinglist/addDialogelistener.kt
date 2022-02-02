package com.example.shoppinglistapp.ui.shoppinglist

import com.example.shoppinglistapp.data.db.entity.ShoppingItem

interface addDialogelistener {
    fun onAddButtonClicked (item: ShoppingItem)
}