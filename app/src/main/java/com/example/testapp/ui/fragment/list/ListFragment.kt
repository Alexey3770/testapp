package com.example.testapp.ui.fragment.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.ui.BaseFragment
import com.example.testapp.ui.adapter.ItemListAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : BaseFragment() {

    override val layoutId = R.layout.fragment_list

    private val viewModel by viewModels<ListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        setupListeners()
    }

    private fun setupList() {
        val itemListAdapter = ItemListAdapter(listOf(), true) { value, isSelected ->
            if (isSelected) {
                viewModel.selectItem(value)
            } else {
                viewModel.deselectItem(value)
            }
        }
        listRecyclerView.apply {
            adapter = itemListAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
        viewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            itemListAdapter.list = it
            itemListAdapter.notifyDataSetChanged()
        })
    }

    private fun setupListeners() {
        listBtnRemoveItem.setOnClickListener {
            viewModel.removeSelectedItems()
        }
    }
}