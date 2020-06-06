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

Brno v Datech is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.

This part of application uses the library GraphView (https://github.com/jjoe64/GraphView).
Library is available under the Apache 2.0 license, which can be obtained from http://www.apache.org/licenses/LICENSE-2.0. Or you can find copy of license in this repository with name license.txt
 */

class AgeStructureGraph : AppCompatActivity() {

    /**
    This activity use data from .csv file and create Age Structure graph.
     */

    //Initialization of readerAndMap class which load data from .csv files and also tmp variables and arraylist for this class.
    private val readerAndMaps = ReaderAndMaps()
    val tmpArrListAgeStructure = ArrayList<String>()
    var tmp = 1.0
    var foo = 1
    var fooX = 0.0
    var fooY = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_structure_graph)

        //Initialization component of graph which is from open source library GraphView.
        val graph = findViewById<View>(R.id.graphAgeStructure) as GraphView

        //Load specific data set to HashMap from .csv file.
        readerAndMaps.ageStructureReader(resources)

        //Initialization components of graph series to which will be load data which will be point in graph.
        val series1 = BarGraphSeries<DataPoint>()
        val series2 = BarGraphSeries<DataPoint>()


        //Call method which prepare data for graph
        ageStructureSimple()

        //For loop which iterate every object in HashMap and add attributes of object to graph series.
        for ((key, value) in readerAndMaps.hashItemAgeStructure) {


            val x = tmp

            //Add value variables to graph series with some condition.
            if (tmp == 1.0) {
                series1.appendData(DataPoint(x, value.countAgeMen?.toDouble()!!), true, 20)
                series2.appendData(DataPoint(x, value.countAgeWomen?.toDouble()!!), true, 20)
                tmp++
                continue
            }

            //Adding attributes of object to tmp variable.
            fooX += value.countAgeMen?.toDouble()!!
            fooY += value.countAgeWomen?.toDouble()!!
            //Add value variables to graph series with some condition.
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

        //Create array list which will contain static label strings.
        val tmpArr =
            tmpArrListAgeStructure.toArray(arrayOfNulls<String>(tmpArrListAgeStructure.size))

        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        //Creating static labels for graph.
        staticLabelsFormatter.setHorizontalLabels(tmpArr)

        //Setting label properties.
        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter
        graph.getLegendRenderer().setVisible(true)
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP)
        graph.gridLabelRenderer.setHorizontalAxisTitle("Věková struktura");

        //Setting series of point properties.
        series1.setDrawValuesOnTop(true)
        series1.setColor(Color.BLUE)
        series1.setTitle("Počet mužů")
        series2.setColor(Color.RED)
        series2.setSpacing(10)
        series2.setTitle("Počet žen")
        series2.setDrawValuesOnTop(true)


        //Add series to graph.
        graph.addSeries(series1)
        graph.addSeries(series2)


    }

    fun ageStructureSimple() {
        //tmp variables
        var frontFoo = 94
        var backFoo = 85


        tmpArrListAgeStructure.add("95+")

        //For loop change of age distance attributes which will be shown in graph, this new distance labels are save to tmp arraylist
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
