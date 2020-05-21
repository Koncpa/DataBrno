package com.pkoncity.BrnoData.ui.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.pkoncity.BrnoData.R

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

class OpenDataUrl : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_data_url)
        val tmpArrList = resources.getStringArray(R.array.text_spinner_choose_data).toList()
        val openDataList = resources.getStringArray(R.array.text_spinner_open_data_info).toList()
        val urlDataArrList =
            resources.getStringArray(R.array.text_spinner_open_data_info_url).toList()
        var tmp = 0

        val spinner = findViewById(R.id.spinner_choose_data) as Spinner
        val buttonChoose = findViewById(R.id.button_general_info_data_url_choose) as Button
        val buttonBackMain = findViewById(R.id.button_general_info_data_back_main) as Button
        val buttonBack = findViewById(R.id.button_general_info_data_url_back) as Button
        val buttonOpen = findViewById(R.id.button_general_info_data_url_open) as Button
        val textDataInfo = findViewById(R.id.textView_header_url) as TextView
        val textChooseData = findViewById(R.id.textView_choose_data) as TextView
        val textOpenData = findViewById(R.id.textView_info_open_data) as TextView

        buttonBack.setVisibility(View.INVISIBLE)
        buttonOpen.setVisibility(View.INVISIBLE)
        textOpenData.setVisibility(View.INVISIBLE)

        val adapter =
            ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tmpArrList)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)

        buttonChoose.setOnClickListener(View.OnClickListener {
            if (spinner.getSelectedItem().toString() == "---") {
                Toast.makeText(
                    applicationContext,
                    "Vyber datovou sadu!",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            buttonBack.setVisibility(View.VISIBLE)
            buttonBackMain.setVisibility(View.INVISIBLE)
            buttonOpen.setVisibility(View.VISIBLE)
            textOpenData.setVisibility(View.VISIBLE)
            spinner.setVisibility(View.INVISIBLE)
            textChooseData.setVisibility(View.INVISIBLE)
            buttonChoose.setVisibility(View.INVISIBLE)
            for (i in 1..11) {

                if (spinner.getSelectedItem().toString() == tmpArrList[i]) {
                    buttonOpen.setText("Odkaz na zdroj dat: \n" + tmpArrList[i])
                    textDataInfo.setTextSize(29.33F)
                    textDataInfo.setText(tmpArrList[i])
                    textOpenData.setText(openDataList[i])
                    tmp = i
                }
            }


        })

        buttonOpen.setOnClickListener(View.OnClickListener {
            val uri: Uri = Uri.parse(urlDataArrList[tmp])
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        })

        buttonBack.setOnClickListener(View.OnClickListener {
            textDataInfo.setText(R.string.text_data_info_header)
            textDataInfo.setTextSize(20.00F)
            val adapter = ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tmpArrList
            )
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.setAdapter(adapter)
            buttonBackMain.setVisibility(View.VISIBLE)
            buttonBack.setVisibility(View.INVISIBLE)
            buttonOpen.setVisibility(View.INVISIBLE)
            textOpenData.setVisibility(View.INVISIBLE)
            spinner.setVisibility(View.VISIBLE)
            textChooseData.setVisibility(View.VISIBLE)
            buttonChoose.setVisibility(View.VISIBLE)
        })

        buttonBackMain.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })


    }

}


