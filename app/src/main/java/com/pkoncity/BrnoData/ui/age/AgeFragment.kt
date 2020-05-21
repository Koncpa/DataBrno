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

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.
 */

class AgeFragment : Fragment() {

    private lateinit var ageViewModel: AgeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ageViewModel =
            ViewModelProviders.of(this).get(AgeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_age, container, false)

        val buttonTableForAgeStruct = root.findViewById<Button>(R.id.buttonAgeStructCo)
        buttonTableForAgeStruct.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeStructureTable::class.java)
                startActivity(intent)

            }


        }

        val buttonTableAgeIndex = root.findViewById<Button>(R.id.buttonAgeIndexTable)
        buttonTableAgeIndex.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeIndexTable::class.java)
                startActivity(intent)

            }


        }

        val buttonTableAgeHope = root.findViewById<Button>(R.id.buttonAgeHopeEvo)
        buttonTableAgeHope.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeHopeTable::class.java)
                startActivity(intent)

            }


        }

        val buttonGraphAgeStruct = root.findViewById<Button>(R.id.buttonAgeStructGraph)
        buttonGraphAgeStruct.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeStructureGraph::class.java)
                startActivity(intent)

            }

        }

        val buttonGraphAgeIndex = root.findViewById<Button>(R.id.buttonAgeIndexGraph)
        buttonGraphAgeIndex.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, AgeIndexGraph::class.java)
                startActivity(intent)

            }

        }


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