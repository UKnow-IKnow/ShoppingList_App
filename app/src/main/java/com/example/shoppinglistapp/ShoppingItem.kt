package com.example.shoppinglistapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Shopping_Items")
data class ShoppingItem (
    @ColumnInfo(name = "Item_Name")
    var name: String,
    @ColumnInfo(name = "Item_Amount")
    var amount: Int
    ){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

}