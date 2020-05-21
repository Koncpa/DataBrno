package com.pkoncity.BrnoData.ui.age

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

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.
 */

class AgeHopeTable : AppCompatActivity() {

    private val readerAndMaps = ReaderAndMaps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_hope_table)
        initAgeHope()

    }


    fun initAgeHope() {
        readerAndMaps.ageHopeReader(resources)
        val stk = findViewById(R.id.table_ageHope) as TableLayout

        for ((key, value) in readerAndMaps.hashItemAgeHope) {
            val tbrow = TableRow(this)
            val t1v = TextView(this)
            t1v.text = value.year.toString()
            t1v.setTextColor(Color.WHITE)
            t1v.gravity = Gravity.CENTER

            tbrow.addView(t1v)
            val t2v = TextView(this)
            t2v.text = value.menJMK.toString()
            t2v.setTextColor(Color.WHITE)
            t2v.gravity = Gravity.CENTER
            tbrow.addView(t2v)
            val t3v = TextView(this)
            t3v.text = value.womenJMK.toString()
            t3v.setTextColor(Color.WHITE)
            t3v.gravity = Gravity.CENTER
            tbrow.addView(t3v)
            val t4v = TextView(this)
            if (value.menBrno == null) {
                t4v.text = "–"
            } else {
                t4v.text = value.menBrno.toString()
            }
            t4v.setTextColor(Color.WHITE)
            t4v.gravity = Gravity.CENTER

            tbrow.addView(t4v)
            val t5v = TextView(this)
            if (value.womenBrno == null) {
                t5v.text = "–"
            } else {
                t5v.text = value.womenBrno.toString()
            }
            t5v.setTextColor(Color.WHITE)
            t5v.gravity = Gravity.CENTER
            tbrow.addView(t5v)
            stk.addView(tbrow)
        }

    }
}
