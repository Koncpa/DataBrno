package com.pkoncity.projektx.ui.GeneralDemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pkoncity.projektx.R

class GeneralDemo : Fragment() {

    private lateinit var shareViewModel: GeneralDemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shareViewModel =
            ViewModelProviders.of(this).get(GeneralDemoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_demography, container, false)
        val textView: TextView = root.findViewById(R.id.text_demography)
        shareViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}