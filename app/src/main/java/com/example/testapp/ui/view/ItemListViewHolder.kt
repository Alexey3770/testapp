package com.example.testapp.ui.view

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * View holder is used for showing string item.
 */
class ItemListViewHolder(
    itemView: View,
    private val selectable: Boolean = false,
    private val onSelectChanged: ((value: String, isSelected: Boolean) -> Unit)? = null
) : RecyclerView.ViewHolder(itemView) {

    private var isSelected = false

    /**
     * Bind view holder with string item.
     */
    fun bind(text: String) {
        itemView.itemListText.text = text
        itemView.setOnClickListener {
            if (selectable) {
                if (isSelected) {
                    isSelected = false
                    itemView.setBackgroundColor(Color.WHITE)
                    itemView.itemListText.setTextColor(Color.BLACK)
                } else {
                    isSelected = true
                    itemView.setBackgroundColor(Color.BLUE)
                    itemView.itemListText.setTextColor(Color.WHITE)
                }
                onSelectChanged?.invoke(text, isSelected)
            }
        }
    }
}