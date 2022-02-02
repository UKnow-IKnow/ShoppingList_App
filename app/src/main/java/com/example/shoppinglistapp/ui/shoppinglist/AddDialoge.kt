package com.example.shoppinglistapp.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.db.entity.ShoppingItem
import kotlinx.android.synthetic.main.dialoge.*

class AddDialoge(
    context: Context,
    var addDialogelistener: addDialogelistener
) : AppCompatDialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialoge)

        tvadd.setOnClickListener {
            val name = etname.text.toString()
            val amount = etamount.text.toString()

            if(amount.isNullOrEmpty()){
                Toast.makeText(context,"Please Enter information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name,amount.toInt())
            addDialogelistener.onAddButtonClicked(item)
            dismiss()
        }

        tvcancel.setOnClickListener {
            cancel()
        }
    }
}