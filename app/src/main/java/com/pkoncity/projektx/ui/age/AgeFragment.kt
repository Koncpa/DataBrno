package com.pkoncity.projektx.ui.age

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pkoncity.projektx.R

class AgeFragment : Fragment() {

    private lateinit var slideshowViewModel: AgeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(AgeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_age, container, false)
        val textView: TextView = root.findViewById(R.id.text_age)
        slideshowViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}