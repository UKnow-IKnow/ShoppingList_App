package com.example.shoppinglistapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglistapp.data.db.entity.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)//this function is mix of update and insert. is not then insert if,exist then replace that

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM Shopping_Items")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>
}