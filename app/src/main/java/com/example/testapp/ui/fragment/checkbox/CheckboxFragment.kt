package com.example.testapp.ui.fragment.checkbox

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.ui.BaseFragment
import com.example.testapp.ui.adapter.ItemListAdapter
import kotlinx.android.synthetic.main.fragment_checkbox.*

/**
 * Fragment is used for editing list of string with help of checkboxes.
 */
class CheckboxFragment : BaseFragment() {

    override val layoutId = R.layout.fragment_checkbox

    private val viewModel by viewModels<CheckboxViewModel>()
    private val itemListAdapter = ItemListAdapter(listOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        setupListeners()
    }

    private fun setupList() {
        checkboxRecyclerView.apply {
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
        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                viewModel.addItem(buttonView.text.toString())
            } else {
                viewModel.removeItem(buttonView.text.toString())
            }
        }
        checkboxTest.setOnCheckedChangeListener(listener)
        checkboxApp.setOnCheckedChangeListener(listener)
    }
}