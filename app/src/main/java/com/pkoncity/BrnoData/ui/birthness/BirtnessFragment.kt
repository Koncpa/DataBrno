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

Brno v Datech is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.
 */

class BirtnessFragment : Fragment() {


    /**
    This fragment manage components for example as buttons and textviews which are showed in Birthness section.
     */

    private lateinit var birthnessViewModel: BirthnessViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        birthnessViewModel =
            ViewModelProviders.of(this).get(BirthnessViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_birthness, container, false)


        //Initialization of button which start new activity which will be show Table.
        val buttonTableDynEvo = root.findViewById<Button>(R.id.buttonDynEvo)
        //SetOnClick lister for starting new activity with table.
        buttonTableDynEvo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, DynEvoActivityTable::class.java)
                startActivity(intent)

            }


        }

        //Initialization of button which start new activity which will be show Table.
        val buttonTableBirthness = root.findViewById<Button>(R.id.buttonEvoBirth)
        //SetOnClick lister for starting new activity with table.
        buttonTableBirthness.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, EvoBirthnessActivityTable::class.java)
                startActivity(intent)

            }


        }
        //Initialization of button which start new activity which will be show graph.
        val buttonGraphDynEvo = root.findViewById<Button>(R.id.buttonDyn_Evo_Graph)
        //SetOnClick lister for starting new activity with graph.
        buttonGraphDynEvo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, GraphDynEvo::class.java)
                startActivity(intent)

            }


        }

        //Initialization of button which start new activity which will be show graph.
        val buttonGraphBirthness = root.findViewById<Button>(R.id.buttonBirthness_Evo_Graph)
        //SetOnClick lister for starting new activity with graph.
        buttonGraphBirthness.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, GraphEvoBirthness::class.java)
                startActivity(intent)

            }


        }

        return root


    }


}





