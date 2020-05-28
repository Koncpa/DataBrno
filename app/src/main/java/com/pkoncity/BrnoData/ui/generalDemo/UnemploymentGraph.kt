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

class UnemploymentGraph : AppCompatActivity() {

    private val readerAndMaps = ReaderAndMaps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unemployment_graph)

        val graph = findViewById<View>(R.id.graphUnem) as GraphView

        readerAndMaps.unemploymentReader(resources)

        val series1 = LineGraphSeries<DataPoint>()
        val series2 = LineGraphSeries<DataPoint>()
        val series3 = LineGraphSeries<DataPoint>()

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(3.1);
        graph.getViewport().setMaxY(12.0);

        for ((key, value) in readerAndMaps.hashItemUnemployment) {

            val x = value.year?.toDouble()!!

            val y = value.unemploymentCR!!
            val z = value.unemploymentJMK!!
            val k = value.unemploymentBrno!!

            series1.appendData(DataPoint(x, y), true, 20)
            series1.setDrawDataPoints(true)
            series2.appendData(DataPoint(x, z), true, 20)
            series2.setDrawDataPoints(true)
            series3.appendData(DataPoint(x, k), true, 20)
            series3.setDrawDataPoints(true)


            readerAndMaps.tmpArrList.add(value.year.toString())

        }

        val tmpArr =
            readerAndMaps.tmpArrList.toArray(arrayOfNulls<String>(readerAndMaps.tmpArrList.size))

        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        staticLabelsFormatter.setHorizontalLabels(tmpArr)

        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter
        graph.getLegendRenderer().setVisible(true)
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP)
        graph.gridLabelRenderer.setHorizontalAxisTitle("Vývoj nezaměstnanosti");

        series1.setTitle("Procent nezaměstnanosti v ČR")
        series1.setColor(Color.MAGENTA)
        series1.setThickness(8)

        series2.setTitle("Procent nezaměstnanosti v Jihomoravském kraji")
        series2.setColor(Color.GREEN)
        series2.setThickness(8)
        series3.setTitle("Procent nezaměstnanosti v Brně")
        series3.setColor(Color.BLUE)
        series3.setThickness(8)

        graph.addSeries(series1)
        graph.addSeries(series2)
        graph.addSeries(series3)
    }
}
