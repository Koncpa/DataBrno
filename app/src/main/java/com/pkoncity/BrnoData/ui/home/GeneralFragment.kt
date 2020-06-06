package com.pkoncity.BrnoData.ui.home

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

class GeneralFragment : Fragment() {

    /**
    This fragment manage components for example as buttons and textviews which are showed in home section.
     */

    private lateinit var homeViewModel: GeneralViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(GeneralViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_general, container, false)


        //Initialization of button which start new activity which will be show info about specific data sets which are used in app .
        val buttonOpenDataUrl = root.findViewById<Button>(R.id.button_general_info_data_url)
        //SetOnClick lister for starting new activity with info about data sets.
        buttonOpenDataUrl.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, OpenDataUrl::class.java)
                startActivity(intent)

            }


        }

        //Initialization of button which start new activity which will be show info about open data .
        val buttonOpenDataInfo = root.findViewById<Button>(R.id.button_general_info_data)
        //SetOnClick lister for starting new activity with info about open data.
        buttonOpenDataInfo.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, OpenDataInfo::class.java)
                startActivity(intent)

            }


        }

        return root
    }
}