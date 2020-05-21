package com.pkoncity.BrnoData.ui.generalDemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.ValueDependentColor
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
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
Library is available under the Apache 2.0 license, which can be obtained from http://www.apache.org/licenses/LICENSE-2.0.
 */

class HumanDensityGraph : AppCompatActivity() {

    private val readerAndMaps = ReaderAndMaps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_human_density_graph)


        val graph = findViewById<View>(R.id.graphHumanDensity) as GraphView

        readerAndMaps.humanDensityReader(resources)


        val series1 = BarGraphSeries<DataPoint>()

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(1500.0);
        graph.getViewport().setMaxY(1680.0);

        for ((key, value) in readerAndMaps.hashItemHumanDensity) {

            val x = value.year?.toDouble()!!

            val y = value.humanePerKm?.toDouble()!!

            series1.appendData(DataPoint(x, y), true, 30)

            if (value.year!!.rem(2) != 0) {
                readerAndMaps.tmpArrList.add(value.year.toString())
            }

            series1.setValueDependentColor(ValueDependentColor<DataPoint> { data ->
                Color.rgb(
                    data.x.toInt() * 20 / 4,
                    Math.abs(data.y * 10 / 6).toInt(),
                    255
                )
            })


        }

        val tmpArr =
            readerAndMaps.tmpArrList.toArray(arrayOfNulls<String>(readerAndMaps.tmpArrList.size))

        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        staticLabelsFormatter.setHorizontalLabels(tmpArr)

        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter
        graph.getLegendRenderer().setVisible(true)
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP)
        graph.gridLabelRenderer.setHorizontalAxisTitle("Hustota zalidnění v městě Brně");

        series1.setTitle("Počet obyvatel na kilometr čtvereční")
        series1.setSpacing(10);

        graph.addSeries(series1)


    }
}
