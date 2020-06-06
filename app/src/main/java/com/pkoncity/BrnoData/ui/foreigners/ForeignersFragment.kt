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

Brno v Datech is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.
 */

class ForeignersFragment : Fragment() {


    /**
    This fragment manage components for example as buttons and textviews which are showed in Foreigners section.
     */

    private lateinit var foreignersViewModel: ForeignersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        foreignersViewModel =
            ViewModelProviders.of(this).get(ForeignersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_foreigners, container, false)

        //Initialization of button which start new activity which will be show table.
        val buttonTableForCount = root.findViewById<Button>(R.id.buttonForCo)
        //SetOnClick lister for starting new activity with table.
        buttonTableForCount.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersCountTable::class.java)
                startActivity(intent)

            }


        }


        //Initialization of button which start new activity which will be show table.
        val buttonTableForGr = root.findViewById<Button>(R.id.buttonForGr)
        //SetOnClick lister for starting new activity with table.
        buttonTableForGr.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersGrowthTable::class.java)
                startActivity(intent)

            }


        }

        //Initialization of button which start new activity which will be show table.
        val buttonTableEvo = root.findViewById<Button>(R.id.buttonForEvo)
        //SetOnClick lister for starting new activity with table.
        buttonTableEvo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersEvolutionTable::class.java)
                startActivity(intent)

            }


        }

        //Initialization of button which start new activity which will be show graph.
        val buttonGraphForCo = root.findViewById<Button>(R.id.buttonForCoGraph)
        //SetOnClick lister for starting new activity with graph.
        buttonGraphForCo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersCountGraph::class.java)
                startActivity(intent)

            }

        }

        //Initialization of button which start new activity which will be show graph.
        val buttonGraphForGr = root.findViewById<Button>(R.id.buttonForGrGraph)
        //SetOnClick lister for starting new activity with graph.
        buttonGraphForGr.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersGrowthGraph::class.java)
                startActivity(intent)

            }

        }


        //Initialization of button which start new activity which will be show graph.
        val buttonGraphForEvo = root.findViewById<Button>(R.id.buttonForEvoGraph)
        //SetOnClick lister for starting new activity with graph.
        buttonGraphForEvo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, ForeignersCountEvoGraph::class.java)
                startActivity(intent)

            }

        }

        return root
    }

}