package com.example.shoppinglistapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.db.entity.ShoppingItem
import com.example.shoppinglistapp.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_list.view.*

class ShoppingItemAdapter(
    var items:  List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter< ShoppingItemAdapter.ShoppingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_list,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvamount.text = "${currentShoppingItem.amount}"

        holder.itemView.ivdelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        holder.itemView.ivplus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }

        holder.itemView.ivminus.setOnClickListener {
            if(currentShoppingItem.amount> 0){
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }
        }
    }




    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}