package com.pkoncity.projektx.ui.foreigners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pkoncity.projektx.R

class ForeignersFragment : Fragment() {

    private lateinit var toolsViewModel: ForeignersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        toolsViewModel =
            ViewModelProviders.of(this).get(ForeignersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_foreigners, container, false)
        val textView: TextView = root.findViewById(R.id.text_foreigners)
        toolsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}