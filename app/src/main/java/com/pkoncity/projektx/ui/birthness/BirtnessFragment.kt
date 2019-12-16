package com.pkoncity.projektx.ui.birthness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pkoncity.projektx.R

class BirtnessFragment : Fragment() {

    private lateinit var birthnessViewModel: BirthnessViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        birthnessViewModel =
            ViewModelProviders.of(this).get(BirthnessViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_birthness, container, false)
        val textView: TextView = root.findViewById(R.id.text_birthness)
        birthnessViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}