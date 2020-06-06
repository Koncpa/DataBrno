package com.pkoncity.BrnoData.ui.foreigners

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.ValueDependentColor
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.pkoncity.BrnoData.R
import com.pkoncity.BrnoData.ReaderAndMaps
import java.util.*

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

class ForeignersCountGraph : AppCompatActivity() {
    /**
    This activity use data from .csv file and create Foreigners count graph.
     */

    //Initialization of readerAndMaps class which load data from .csv files.
    private val readerAndMaps = ReaderAndMaps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreigners_count_graph)

        //Initialization components of spinners and buttons.
        val spinnerOne = findViewById(R.id.spinner_one) as Spinner
        val spinnerTwo = findViewById(R.id.spinner_two) as Spinner
        val spinnerThree = findViewById(R.id.spinner_three) as Spinner
        val buttonGraph = findViewById(R.id.button_choose_nationality) as Button
        val textFor = findViewById(R.id.text_foreigners_count_graph) as TextView
        val textForNext = findViewById(R.id.text_choose_countries) as TextView
        //Initialization component of graph which is from open source library GraphView.
        val graph = findViewById<View>(R.id.graph_for_count) as GraphView

        //Set graphv invisible.
        graph.setVisibility(View.INVISIBLE)

        //Load specific data set to HashMap from .csv file.
        readerAndMaps.foreignersCountReader(resources)
        //Iterate all objects in HashMap and save attributes from objects to tmpArrList
        for ((key, value) in readerAndMaps.hashItemForeignersCount) {
            if (value.countForeigners!! >= 1) {
                readerAndMaps.tmpArrList.add(value.country.toString())
            }
        }
        //Add to arraylist string
        readerAndMaps.tmpArrList.add(0, "-Zvolte zemi-")
        //Sort arraylist from A to Z
        Collections.sort(readerAndMaps.tmpArrList, String.CASE_INSENSITIVE_ORDER)

        //Initialize adapter for spinners where we add to spinners arraylist, which we can show in spinner.
        val adapter = ArrayAdapter<String>(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            readerAndMaps.tmpArrList
        )
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        //Add adapters to spinners.
        spinnerOne.setAdapter(adapter)
        spinnerTwo.setAdapter(adapter)
        spinnerThree.setAdapter(adapter)

        //Button which onClick select actuall string in spinners.
        buttonGraph.setOnClickListener(View.OnClickListener {
            //Condition if in some spinner is empty choose, then you see toast error.
            if (spinnerOne.getSelectedItem().toString() == "-Zvolte zemi-" || spinnerTwo.getSelectedItem().toString() == "-Zvolte zemi-" || spinnerThree.getSelectedItem().toString() == "-Zvolte zemi-") {
                Toast.makeText(
                    applicationContext,
                    "Nezvolil jsi všechny možnosti",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            //Condition if in some spinner are same strings, then you see errot to choose another coutry.
            if (spinnerOne.getSelectedItem().toString() == spinnerTwo.getSelectedItem().toString() || spinnerTwo.getSelectedItem().toString() == spinnerThree.getSelectedItem().toString() || spinnerOne.getSelectedItem().toString() == spinnerThree.getSelectedItem().toString()) {
                Toast.makeText(
                    applicationContext,
                    "Prosím zvol jiné země",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }

            //Set invisible some of components
            spinnerOne.setVisibility(View.INVISIBLE)
            spinnerTwo.setVisibility(View.INVISIBLE)
            spinnerThree.setVisibility(View.INVISIBLE)
            buttonGraph.setVisibility(View.INVISIBLE)
            textFor.setVisibility(View.INVISIBLE)
            textForNext.setVisibility(View.INVISIBLE)
            graph.setVisibility(View.VISIBLE)

            //Initialization components of graph series to which will be load data which will be point in graph.
            val series1 = BarGraphSeries<DataPoint>()
            //Initializate helping array list.
            val tmpArrListFor = ArrayList<String>()
            val tmpArrStaticLabel = ArrayList<String>()

            //Take string which are actually in spinner.
            tmpArrListFor.add(spinnerOne.getSelectedItem().toString())
            tmpArrListFor.add(spinnerTwo.getSelectedItem().toString())
            tmpArrListFor.add(spinnerThree.getSelectedItem().toString())
            var tmp = 1.0

            //For loop which iterate every object in HashMap and add attributes of object to graph series.
            for ((key, value) in readerAndMaps.hashItemForeignersCount) {


                //adding attributes to series if are equal to strings which was choose in spinners.
                if (tmpArrListFor[0] == value.country) {
                    //Adding attributes of object to tmp variables.
                    val x = tmp
                    val y = value.countForeigners?.toDouble()!!
                    //Add tmp variables to graph series
                    series1.appendData(DataPoint(x, y), true, 4)
                    tmpArrStaticLabel.add(tmpArrListFor[0])
                    tmp++
                }
                //adding attributes to series if are equal to strings which was choose in spinners.
                if (tmpArrListFor[1] == value.country) {
                    //Adding attributes of object to tmp variables.
                    val x = tmp
                    val y = value.countForeigners?.toDouble()!!
                    //Add tmp variables to graph series
                    series1.appendData(DataPoint(x, y), true, 4)
                    tmpArrStaticLabel.add(tmpArrListFor[1])
                    tmp++

                }
                //adding attributes to series if are equal to strings which was choose in spinners.
                if (tmpArrListFor[2] == value.country) {
                    //Adding attributes of object to tmp variables.
                    val x = tmp
                    val y = value.countForeigners?.toDouble()!!
                    //Add tmp variables to graph series
                    series1.appendData(DataPoint(x, y), true, 4)
                    tmpArrStaticLabel.add(tmpArrListFor[2])
                    tmp++
                }

                //Set color properties of added point.
                series1.setValueDependentColor(ValueDependentColor<DataPoint> { data ->
                    Color.rgb(
                        data.x.toInt() * 255 / 4,
                        Math.abs(data.y * 255 / 6).toInt(),
                        100
                    )
                })


            }

            //Create array list which will contain static label strings.
            val tmpArr = tmpArrStaticLabel.toArray(arrayOfNulls<String>(tmpArrStaticLabel.size))


            val staticLabelsFormatter = StaticLabelsFormatter(graph)
            //Creating static labels for graph.//Creating static labels for graph.
            staticLabelsFormatter.setHorizontalLabels(tmpArr)

            //Setting label properties.
            graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter
            //Setting series of point properties.
            series1.setSpacing(50);
            series1.setDrawValuesOnTop(true)
            series1.setValuesOnTopColor(Color.RED)
            //Add series to graph.
            graph.addSeries(series1)


        })


    }


}
