package com.pkoncity.BrnoData.ui.birthness

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.pkoncity.BrnoData.R
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

class DynEvoActivityTable : AppCompatActivity() {

    /**
    This activity use data from .csv file and Dyn Evo table.
     */

    //Initialization of readerAndMaps class which load data from .csv files.
    private val readerAndMaps = ReaderAndMaps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dyn_evo_table)
        //Call method to fill table.
        initDynEvolution()
    }


    fun initDynEvolution() {
        //Load specific data set to HashMap from .csv file.
        readerAndMaps.dynamicEvolutinReader(resources)
        //Initialize table layout.
        val stk = findViewById(R.id.table_dynEvolution) as TableLayout
        //Iterate all objects in HashMap.
        for ((key, value) in readerAndMaps.hashItemDynEvolution) {
            //Initialize table row and textview.
            val tbrow = TableRow(this)
            val t1v = TextView(this)
            //Add attribute from object to textview.
            t1v.text = value.year.toString()
            t1v.setTextColor(Color.WHITE)
            t1v.gravity = Gravity.CENTER
            //Add text to tableRow.
            tbrow.addView(t1v)
            val t2v = TextView(this)
            //Add attribute from object to textview.
            t2v.text = value.naturalGrowth.toString()
            t2v.setTextColor(Color.WHITE)
            t2v.gravity = Gravity.CENTER
            //Add text to tableRow.
            tbrow.addView(t2v)
            val t3v = TextView(this)
            //Add attribute from object to textview.
            t3v.text = value.migrationSaldo.toString()
            t3v.setTextColor(Color.WHITE)
            t3v.gravity = Gravity.CENTER
            //Add text to tableRow.
            tbrow.addView(t3v)
            val t4v = TextView(this)
            //Add attribute from object to textview.
            t4v.text = value.allGrowth.toString()
            t4v.setTextColor(Color.WHITE)
            t4v.gravity = Gravity.CENTER
            //Add text to tableRow.
            tbrow.addView(t4v)
            //Add table row to table layout.
            stk.addView(tbrow)
        }

    }
}
