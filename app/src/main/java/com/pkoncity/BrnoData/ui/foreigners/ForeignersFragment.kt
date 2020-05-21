package com.pkoncity.BrnoData.ui.foreigners

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

class ForeignersFragment : Fragment() {

    private lateinit var foreignersViewModel: ForeignersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        foreignersViewModel =
            ViewModelProviders.of(this).get(ForeignersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_foreigners, container, false)
        val buttonTableForCount = root.findViewById<Button>(R.id.buttonForCo)
        buttonTableForCount.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersCountTable::class.java)
                startActivity(intent)

            }


        }

        val buttonTableForGr = root.findViewById<Button>(R.id.buttonForGr)
        buttonTableForGr.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersGrowthTable::class.java)
                startActivity(intent)

            }


        }

        val buttonTableEvo = root.findViewById<Button>(R.id.buttonForEvo)
        buttonTableEvo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersEvolutionTable::class.java)
                startActivity(intent)

            }


        }

        val buttonGraphForCo = root.findViewById<Button>(R.id.buttonForCoGraph)
        buttonGraphForCo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersCountGraph::class.java)
                startActivity(intent)

            }

        }

        val buttonGraphForGr = root.findViewById<Button>(R.id.buttonForGrGraph)
        buttonGraphForGr.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersGrowthGraph::class.java)
                startActivity(intent)

            }

        }


        val buttonGraphForEvo = root.findViewById<Button>(R.id.buttonForEvoGraph)
        buttonGraphForEvo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersCountEvoGraph::class.java)
                startActivity(intent)

            }

        }

        return root
    }

}