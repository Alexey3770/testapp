package com.example.testapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.ui.view.ItemListViewHolder

/**
 * Adapter for showing string items.
 */
class ItemListAdapter(
    var list: List<String>,
    private val selectable: Boolean = false,
    private val onSelectChanged: ((value: String, isSelected: Boolean) -> Unit)? = null
) : RecyclerView.Adapter<ItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        return ItemListViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false), selectable, onSelectChanged)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.bind(list[position])
    }
}