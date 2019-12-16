package com.pkoncity.projektx.ui.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pkoncity.projektx.R

class GeneralFragment : Fragment() {

    private lateinit var homeViewModel: GeneralViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(GeneralViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_general, container, false)
        val textView: TextView = root.findViewById(R.id.text_general)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}