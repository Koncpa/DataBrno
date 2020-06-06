package com.pkoncity.BrnoData.ui.generalDemo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.pkoncity.BrnoData.R

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

class GeneralDemo : Fragment() {

    private lateinit var generalViewModel: GeneralDemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        generalViewModel =
            ViewModelProviders.of(this).get(GeneralDemoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_demography, container, false)

        val textView: TextView = root.findViewById(R.id.text_demography)

        val buttontablecitcount = root.findViewById<Button>(R.id.buttonCitCountBrnoTable)
        buttontablecitcount.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, CitizenCountTable::class.java)
                startActivity(intent)

            }


        }

        val buttonTableHumDensity = root.findViewById<Button>(R.id.buttonHumDensityTable)
        buttonTableHumDensity.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, HumanDensityTable::class.java)
                startActivity(intent)

            }


        }

        val buttonTableUnem = root.findViewById<Button>(R.id.buttonUnenmTable)
        buttonTableUnem.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, UnemploymentTable::class.java)
                startActivity(intent)

            }


        }

        val buttonGraphCitCount = root.findViewById<Button>(R.id.buttonCitCountBrnoGraph)
        buttonGraphCitCount.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, CitizenCountGraph::class.java)
                startActivity(intent)

            }

        }

        val buttonGraphHumDensity = root.findViewById<Button>(R.id.buttonHumDensityGraph)
        buttonGraphHumDensity.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, HumanDensityGraph::class.java)
                startActivity(intent)

            }

        }

        val buttonGraphUnem = root.findViewById<Button>(R.id.buttonUnenmGraph)
        buttonGraphUnem.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, UnemploymentGraph::class.java)
                startActivity(intent)

            }

        }

        return root
    }
}