package com.pkoncity.BrnoData.ui.quiz

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

Brno v Datech is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.
 */

class QuizInfo : AppCompatActivity() {

    /**
    This activity show info about quiz.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_info)
        getSupportActionBar()?.setTitle("Informace o kvízu")

        //Button which you get back to previous fragment.
        val buttonInfo = findViewById(R.id.btnBackInfoQuiz) as Button
        buttonInfo.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

    }


}



