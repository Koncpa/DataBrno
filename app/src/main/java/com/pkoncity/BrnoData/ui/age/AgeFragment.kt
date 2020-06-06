package com.pkoncity.BrnoData.ui.age

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

class AgeFragment : Fragment() {

    /**
    This fragment manage components for example as buttons and textviews which are showed in Age section.
     */

    private lateinit var ageViewModel: AgeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ageViewModel =
            ViewModelProviders.of(this).get(AgeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_age, container, false)


        //Initialization of button which start new activity which will be show Table.
        val buttonTableForAgeStruct = root.findViewById<Button>(R.id.buttonAgeStructCo)
        //SetOnClick lister for starting new activity with table.
        buttonTableForAgeStruct.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeStructureTable::class.java)
                startActivity(intent)

            }


        }


        //Initialization of button which start new activity which will be show Table.
        val buttonTableAgeIndex = root.findViewById<Button>(R.id.buttonAgeIndexTable)
        //SetOnClick lister for starting new activity with table.
        buttonTableAgeIndex.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeIndexTable::class.java)
                startActivity(intent)

            }


        }

        //Initialization of button which start new activity which will be show Table.
        val buttonTableAgeHope = root.findViewById<Button>(R.id.buttonAgeHopeEvo)
        //SetOnClick lister for starting new activity with table.
        buttonTableAgeHope.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeHopeTable::class.java)
                startActivity(intent)

            }


        }

        //Initialization of button which start new activity which will be show graph.
        val buttonGraphAgeStruct = root.findViewById<Button>(R.id.buttonAgeStructGraph)
        //SetOnClick lister for starting new activity with graph.
        buttonGraphAgeStruct.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeStructureGraph::class.java)
                startActivity(intent)

            }

        }


        //Initialization of button which start new activity which will be show graph.
        val buttonGraphAgeIndex = root.findViewById<Button>(R.id.buttonAgeIndexGraph)
        //SetOnClick lister for starting new activity with graph.
        buttonGraphAgeIndex.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeIndexGraph::class.java)
                startActivity(intent)

            }

        }


        //Initialization of button which start new activity which will be show graph.
        val buttonGraphAgeHope = root.findViewById<Button>(R.id.buttonAgeHopeGraph)
        buttonGraphAgeHope.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeHopeGraph::class.java)
                startActivity(intent)

            }

        }

        return root

    }
}