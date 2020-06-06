package com.pkoncity.BrnoData.ui.age

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

Brno v Datech is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.

This part of application uses the library GraphView (https://github.com/jjoe64/GraphView).
Library is available under the Apache 2.0 license, which can be obtained from http://www.apache.org/licenses/LICENSE-2.0. Or you can find copy of license in this repository with name license.txt
 */

class AgeHopeGraph : AppCompatActivity() {

    /**
    This activity use data from .csv file and create Age Hope graph.
     */

    //Initialization of readerAndMaps class which load data from .csv files.
    private val readerAndMaps = ReaderAndMaps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_hope_graph)

        //Initialization component of graph which is from open source library GraphView.
        val graph = findViewById<View>(R.id.graphHope) as GraphView

        //Load specific data set to HashMap from .csv file.
        readerAndMaps.ageHopeReader(resources)

        //Initialization components of graph series to which will be load data which will be point in graph.
        val series1 = LineGraphSeries<DataPoint>()
        val series2 = LineGraphSeries<DataPoint>()
        val series3 = LineGraphSeries<DataPoint>()
        val series4 = LineGraphSeries<DataPoint>()

        //Set manual maximum and minimum of axis Y.
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(69.0);
        graph.getViewport().setMaxY(84.0);

        //For loop which iterate every object in HashMap and add attributes of object to graph series.
        for ((key, value) in readerAndMaps.hashItemAgeHope) {

            //Adding attributes of object to tmp variables.
            val x = value.year?.toDouble()!!
            val y = value.menJMK!!
            val n: Double
            val k: Double
            val z = value.womenJMK!!
            if (value.menBrno != null) {
                k = value.menBrno!!
                n = value.womenBrno!!
                //Add tmp variables to graph series.
                series3.appendData(DataPoint(x, k), true, 30)
                series3.setDrawDataPoints(true)
                series4.appendData(DataPoint(x, n), true, 30)
                series4.setDrawDataPoints(true)


            }

            //Add tmp variables to graph series.
            series1.appendData(DataPoint(x, y), true, 30)
            series1.setDrawDataPoints(true)
            series2.appendData(DataPoint(x, z), true, 30)
            series2.setDrawDataPoints(true)



            //Saving attribute of year from object to tmp array list, with some condition.
            if (value.year!!.rem(2) != 0 || value.year == 2016) {
                readerAndMaps.tmpArrList.add(value.year.toString())
            }

        }


        //Create array list which will contain static label strings.
        val tmpArr =
            readerAndMaps.tmpArrList.toArray(arrayOfNulls<String>(readerAndMaps.tmpArrList.size))

        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        //Creating static labels for graph.
        staticLabelsFormatter.setHorizontalLabels(tmpArr)

        //Setting label properties.
        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter
        graph.getLegendRenderer().setVisible(true)
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM)
        graph.gridLabelRenderer.setHorizontalAxisTitle("Naděje na dožití");

        //Setting series of point properties.
        series1.setTitle("Muži - Jihomoravský kraj")
        series1.setColor(Color.MAGENTA)
        series1.setThickness(8)
        series2.setTitle("Ženy - Jihomoravský kraj")
        series2.setColor(Color.GREEN)
        series2.setThickness(8)
        series3.setTitle("Muži - Brno")
        series3.setColor(Color.BLUE)
        series3.setThickness(8)
        series4.setTitle("Ženy - Brno")
        series4.setColor(Color.RED)
        series4.setThickness(8)
        //Add series to graph.
        graph.addSeries(series1)
        graph.addSeries(series2)
        graph.addSeries(series3)
        graph.addSeries(series4)
    }
}
