package com.pkoncity.BrnoData.ui.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
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

class QuizFragment : Fragment() {

    /**
    This fragment manage components for example as buttons and textviews which are showed in quizsection.
     */


    private lateinit var sendViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(QuizViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_quiz, container, false)


        //Initialization of button which will be start new activity of quiz.
        val startbutton = root.findViewById(R.id.buttonquiz) as Button
        //SetOnClick lister for start new activity of quiz.
        startbutton.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, QuestionsActivity::class.java)
                startActivity(intent)

            }


        }


        //Initialization of button which will be start new activity info about quiz.
        val infoButton = root.findViewById(R.id.buttonInfoQuiz) as Button
        //SetOnClick lister for start new activity of info about quiz.
        infoButton.setOnClickListener {
            activity?.let {
                val intent = Intent(this.context, QuizInfo::class.java)
                startActivity(intent)

            }


        }

        return root

    }


}