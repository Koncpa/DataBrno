package com.pkoncity.BrnoData.ui.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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

class OpenDataInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_data_info)

        val buttonBack = findViewById(R.id.buttonBackOpenData) as Button
        buttonBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

        val buttonMoreInfo = findViewById(R.id.buttonNationalData) as Button
        buttonMoreInfo.setOnClickListener(View.OnClickListener {
            val uri: Uri = Uri.parse("https://opendata.gov.cz/informace:start")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        })


    }
}
