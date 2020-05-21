package com.pkoncity.BrnoData.ui.birthness


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.pkoncity.BrnoData.R
import android.widget.*
import androidx.lifecycle.Observer

import com.pkoncity.BrnoData.ReaderAndMaps

/*
This file is part of Brno v Datech.

Brno v Datech is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.
 */

class BirtnessFragment : Fragment() {


    //private lateinit var textView2: TextView
    private val readerAndMaps = ReaderAndMaps()


    private lateinit var birthnessViewModel: BirthnessViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        birthnessViewModel =
            ViewModelProviders.of(this).get(BirthnessViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_birthness, container, false)

        val textView: TextView = root.findViewById(R.id.text_mainBirthness)
        birthnessViewModel.text.observe(this, Observer {
            textView.text = it
        })

        val buttonTableDynEvo = root.findViewById<Button>(R.id.buttonDynEvo)
        buttonTableDynEvo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, DynEvoActivityTable::class.java)
                startActivity(intent)

            }


        }

        val buttonTableBirthness = root.findViewById<Button>(R.id.buttonEvoBirth)
        buttonTableBirthness.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, EvoBirthnessActivityTable::class.java)
                startActivity(intent)

            }


        }

        val buttonGraphDynEvo = root.findViewById<Button>(R.id.buttonDyn_Evo_Graph)
        buttonGraphDynEvo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, GraphDynEvo::class.java)
                startActivity(intent)

            }


        }

        val buttonGraphBirthness = root.findViewById<Button>(R.id.buttonBirthness_Evo_Graph)
        buttonGraphBirthness.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, GraphEvoBirthness::class.java)
                startActivity(intent)

            }


        }

        return root


    }


}





