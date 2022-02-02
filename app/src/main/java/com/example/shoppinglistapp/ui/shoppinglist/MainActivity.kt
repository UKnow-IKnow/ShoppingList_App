package com.example.shoppinglistapp.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.db.Repository.shoppingRepository
import com.example.shoppinglistapp.data.db.ShoppingDatabase
import com.example.shoppinglistapp.data.db.entity.ShoppingItem
import com.example.shoppinglistapp.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = ShoppingDatabase(this)
        val repository = shoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory)
            .get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvshoppingItems.layoutManager = LinearLayoutManager(this)
        rvshoppingItems.adapter = adapter

        viewModel.getAllShoppingItem().observe(this, Observer{
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fav.setOnClickListener {
            AddDialoge(this,
            object : addDialogelistener {
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }

}


