package com.pkoncity.BrnoData.ui.generalDemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
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

This part of application uses the library GraphView (https://github.com/jjoe64/GraphView).
Library is available under the Apache 2.0 license, which can be obtained from http://www.apache.org/licenses/LICENSE-2.0. Or you can find copy of license in this repository with name license.txt
 */

class CitizenCountGraph : AppCompatActivity() {

    private val readerAndMaps = ReaderAndMaps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citizen_count_graph)

        val graph = findViewById<View>(R.id.graphCitCount) as GraphView

        readerAndMaps.countCitizen(resources)

        val series1 = LineGraphSeries<DataPoint>()
        val series2 = LineGraphSeries<DataPoint>()


        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(172000.0);
        graph.getViewport().setMaxY(200001.0);

        for ((key, value) in readerAndMaps.hashItemCitizenCount) {

            val x = value.year?.toDouble()!!
            val y = value.countMen?.toDouble()!!
            val z = value.countWomen?.toDouble()!!

            series1.appendData(DataPoint(x, y), true, 20)
            series1.setDrawDataPoints(true)
            series2.appendData(DataPoint(x, z), true, 20)
            series2.setDrawDataPoints(true)


            if (value.year!!.rem(2) != 0) {
                readerAndMaps.tmpArrList.add(value.year.toString())
            }


        }

        val tmpArr =
            readerAndMaps.tmpArrList.toArray(arrayOfNulls<String>(readerAndMaps.tmpArrList.size))

        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        staticLabelsFormatter.setHorizontalLabels(tmpArr)

        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter
        graph.getLegendRenderer().setVisible(true)
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP)
        graph.gridLabelRenderer.setHorizontalAxisTitle("Vývoj počtu obyvatel v Brně")

        graph.viewport.setScrollableY(true)
        series1.setTitle("Muži")
        series1.setColor(Color.BLUE)
        series1.setThickness(8)

        series2.setTitle("Ženy")
        series2.setColor(Color.RED)
        series2.setThickness(8)



        graph.addSeries(series1)
        graph.addSeries(series2)


    }


}

