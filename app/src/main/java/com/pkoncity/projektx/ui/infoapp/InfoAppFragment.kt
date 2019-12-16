package com.pkoncity.projektx.ui.infoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pkoncity.projektx.R

class InfoAppFragment : Fragment() {

    private lateinit var sendViewModel: InfoAppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(InfoAppViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_infoapp, container, false)
        val textView: TextView = root.findViewById(R.id.text_infoapp)
        sendViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}