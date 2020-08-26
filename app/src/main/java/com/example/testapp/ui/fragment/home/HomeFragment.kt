package com.example.testapp.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.testapp.R
import com.example.testapp.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    override val layoutId = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        homeBtnCheckboxScreen.setOnClickListener {
            navController.navigate(R.id.navigation_checkbox)
        }
        homeBtnListScreen.setOnClickListener {
            navController.navigate(R.id.navigation_list)
        }
    }
}