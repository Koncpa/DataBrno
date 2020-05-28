package com.pkoncity.BrnoData.ui.age

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.pkoncity.BrnoData.R
import com.pkoncity.BrnoData.ReaderAndMaps
import java.util.ArrayList

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

This part of application uses the library GraphView (https://github.com/jjoe64/GraphView).
Library is available under the Apache 2.0 license, which can be obtained from http://www.apache.org/licenses/LICENSE-2.0. Or you can find copy of license in this repository with name license.txt
 */

class AgeStructureGraph : AppCompatActivity() {

    private val readerAndMaps = ReaderAndMaps()
    val tmpArrListAgeStructure = ArrayList<String>()
    var tmp = 1.0
    var foo = 1
    var fooX = 0.0
    var fooY = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_structure_graph)

        val graph = findViewById<View>(R.id.graphAgeStructure) as GraphView


        readerAndMaps.ageStructureReader(resources)

        val series1 = BarGraphSeries<DataPoint>()
        val series2 = BarGraphSeries<DataPoint>()



        ageStructureSimple()
        for ((key, value) in readerAndMaps.hashItemAgeStructure) {

            val x = tmp

            if (tmp == 1.0) {
                series1.appendData(DataPoint(x, value.countAgeMen?.toDouble()!!), true, 20)
                series2.appendData(DataPoint(x, value.countAgeWomen?.toDouble()!!), true, 20)
                tmp++
                continue
            }

            fooX += value.countAgeMen?.toDouble()!!
            fooY += value.countAgeWomen?.toDouble()!!
            if (foo == 2) {
                series1.appendData(DataPoint(x, fooX), true, 20)
                series2.appendData(DataPoint(x, fooY), true, 20)
                fooX -= fooX
                fooY -= fooY
                foo--
                tmp++
                continue
            }

            foo++


        }

        val tmpArr =
            tmpArrListAgeStructure.toArray(arrayOfNulls<String>(tmpArrListAgeStructure.size))

        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        staticLabelsFormatter.setHorizontalLabels(tmpArr)

        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter
        graph.getLegendRenderer().setVisible(true)
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP)
        graph.gridLabelRenderer.setHorizontalAxisTitle("Věková struktura");


        series1.setDrawValuesOnTop(true)
        series1.setColor(Color.BLUE)
        series1.setTitle("Počet mužů")


        series2.setColor(Color.RED)
        series2.setSpacing(10)
        series2.setTitle("Počet žen")
        series2.setDrawValuesOnTop(true)
        graph.addSeries(series1)
        graph.addSeries(series2)


    }

    fun ageStructureSimple() {
        var frontFoo = 94
        var backFoo = 85

        tmpArrListAgeStructure.add("95+")

        for (i in 1..9) {

            tmpArrListAgeStructure.add(frontFoo.toString() + "-" + backFoo.toString())
            for (k in 1..10) {
                frontFoo--
                backFoo--
            }

        }
        tmpArrListAgeStructure.add("0-4")
    }
}
