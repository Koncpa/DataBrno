package com.pkoncity.BrnoData.ui.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import com.pkoncity.BrnoData.R
import com.pkoncity.BrnoData.ReaderAndMaps
import kotlinx.android.synthetic.main.activity_questions.*
import java.util.*
import kotlin.collections.ArrayList

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

class QuestionsActivity : AppCompatActivity() {


    private val readerAndMaps = ReaderAndMaps()
    val questionsArrList = ArrayList<String>()
    val optionArrList = ArrayList<String>()
    val randomGenerator = Random()
    var point = 0
    var marks = 0
    var correct: Int = 0
    var wrong: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        readerAndMaps.allReaders(resources)

        questionCitizenCount()
        questionHumanDensity()
        questionUnemployment()
        questionDynEvo()
        questionEvoBirthnes()
        questionAgeStructure()
        questionAgeIndex()
        questionAgeHope()
        questionForCount()
        questionForGrowth()
        getSupportActionBar()?.setTitle("Kvíz - Otázka 1/" + questionsArrList.size)

        val score = findViewById(R.id.textView4) as TextView
        val quitbutton = findViewById(R.id.buttonquit) as Button
        quitbutton.setVisibility(View.GONE)
        val subbutton = findViewById(R.id.button3) as Button
        val corectresult = findViewById(R.id.tvres2) as TextView
        val wrongresult = findViewById(R.id.tvres) as TextView
        corectresult.setVisibility(View.GONE)
        wrongresult.setVisibility(View.GONE)
        val textviewque = findViewById(R.id.tvque) as TextView
        val radio_group = findViewById(R.id.answersgrp) as RadioGroup
        val radiob1 = findViewById(R.id.radioButton) as RadioButton
        val radiob2 = findViewById(R.id.radioButton2) as RadioButton
        val radiob3 = findViewById(R.id.radioButton3) as RadioButton
        val radiob4 = findViewById(R.id.radioButton4) as RadioButton
        textviewque.text = questionsArrList.get(point)
        radiob1.text = optionArrList.get(0)
        radiob2.setText(optionArrList.get(1))
        radiob3.setText(optionArrList.get(2))
        radiob4.setText(optionArrList.get(3))
        subbutton.setOnClickListener(View.OnClickListener {

            if (radio_group.checkedRadioButtonId == -1) {
                Toast.makeText(
                    applicationContext,
                    "Prosím zvol jednu možnost",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            val uans =
                findViewById(radio_group.checkedRadioButtonId) as RadioButton
            val answerText = uans.text.toString()
            if (answerText == readerAndMaps.tmpArrList.get(point)) {
                correct++
                Toast.makeText(applicationContext, "Správně", Toast.LENGTH_SHORT)
                    .show()
            } else {
                wrong++
                Toast.makeText(applicationContext, "Špatně", Toast.LENGTH_SHORT).show()
            }
            point++
            if (score != null) score.text = "" + correct
            if (point < questionsArrList.size) {
                val tmp = 1
                getSupportActionBar()?.setTitle("Kvíz - Otázka " + tmp.plus(point) + "/" + questionsArrList.size)
                textviewque.text = questionsArrList.get(point)
                radiob1.text = optionArrList.get(point * 4)
                radiob2.setText(optionArrList.get(point * 4 + 1))
                radiob3.setText(optionArrList.get(point * 4 + 2))
                radiob4.setText(optionArrList.get(point * 4 + 3))
            } else {
                getSupportActionBar()?.setTitle("Výsledek")
                subbutton.setVisibility(View.GONE)
                radio_group.setVisibility(View.GONE)
                corectresult.setVisibility(View.VISIBLE)
                corectresult.setText("Dobře: " + correct)
                corectresult.setGravity(Gravity.CENTER)
                wrongresult.setVisibility(View.VISIBLE)
                wrongresult.setText("Špatně: " + wrong)
                wrongresult.setGravity(Gravity.CENTER)
                textView4.setVisibility(View.INVISIBLE)
                textView3.setVisibility(View.INVISIBLE)
                tvque.setText("Výsledné skóre testu:")
                tvque.setGravity(Gravity.CENTER)

                marks = correct
                quitbutton.setVisibility(View.VISIBLE)
                radio_group.setVisibility(View.GONE)

            }
            radio_group.clearCheck()
        })
        quitbutton.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }


    fun questionCitizenCount() {
        var randomNumber = randomGenerator.nextInt(readerAndMaps.hashItemCitizenCount.size)
        val tmp1 = readerAndMaps.hashItemCitizenCount.get(randomNumber)?.countMen
        val tmp2 = readerAndMaps.hashItemCitizenCount.get(randomNumber)?.countWomen!!
        val tmp = tmp1?.plus(tmp2)
        readerAndMaps.tmpArrList.add(tmp.toString())




        questionsArrList.add("V roce " + readerAndMaps.hashItemCitizenCount.get(randomNumber)?.year.toString() + " bylo ve městě Brně kolik obyvatel?")
        randomNumber = (1..4).random()
        if (tmp != null) {
            forMethodHelpInt(randomNumber, 100000, 2, 100000, tmp, false)
        }


    }

    fun questionHumanDensity() {

        var randomNumber = randomGenerator.nextInt(readerAndMaps.hashItemHumanDensity.size)
        val tmp = readerAndMaps.hashItemHumanDensity.get(randomNumber)?.humanePerKm
        readerAndMaps.tmpArrList.add(tmp.toString())



        questionsArrList.add(
            "Jakou mělo město Brno v roce " + readerAndMaps.hashItemHumanDensity.get(
                randomNumber
            )?.year.toString() + " hustotu zalidnění v kilometrech čtverečních?"
        )
        randomNumber = (1..4).random()
        if (tmp != null) {
            forMethodHelpInt(randomNumber, 500, 2, 500, tmp, false)
        }


    }

    fun questionUnemployment() {
        var randomNumber = randomGenerator.nextInt(readerAndMaps.hashItemUnemployment.size)
        val tmp = readerAndMaps.hashItemUnemployment.get(randomNumber)?.unemploymentBrno
        readerAndMaps.tmpArrList.add(tmp.toString() + "%")



        questionsArrList.add(
            "Jaké bylo procento nezaměstnanosti za rok " + readerAndMaps.hashItemUnemployment.get(
                randomNumber
            )?.year.toString() + " pro Brno?"
        )
        randomNumber = (1..4).random()
        if (tmp != null) {
            forMethodHelpDouble(randomNumber, 10, 2.0, 2, tmp, true)
        }

    }

    fun questionDynEvo() {
        var randomNumber = randomGenerator.nextInt(readerAndMaps.hashItemDynEvolution.size)
        val tmp = readerAndMaps.hashItemDynEvolution.get(randomNumber)?.allGrowth
        readerAndMaps.tmpArrList.add(tmp.toString())



        questionsArrList.add(
            "Hrubá míra celkového přírůstku pro rok " + readerAndMaps.hashItemDynEvolution.get(
                randomNumber
            )?.year.toString() + " je?"
        )
        randomNumber = (1..4).random()
        if (tmp != null) {
            forMethodHelpDouble(randomNumber, 3, 2.0, 3, tmp, false)
        }

    }

    fun questionEvoBirthnes() {
        var randomNumber = randomGenerator.nextInt(readerAndMaps.hashItemEvoBirthness.size)
        val tmp = readerAndMaps.hashItemEvoBirthness.get(randomNumber)?.birthness
        readerAndMaps.tmpArrList.add(tmp.toString())



        questionsArrList.add(
            "Hrubá míra porodnosti se pro rok " + readerAndMaps.hashItemEvoBirthness.get(
                randomNumber
            )?.year.toString() + " pohybovala na úrovni?"
        )
        randomNumber = (1..4).random()
        if (tmp != null) {
            forMethodHelpDouble(randomNumber, 4, 2.0, 5, tmp, false)
        }

    }


    fun questionAgeStructure() {

        var randomNumber = randomGenerator.nextInt(readerAndMaps.hashItemAgeStructure.size)
        val tmp = readerAndMaps.hashItemAgeStructure.get(randomNumber)?.countAgeWomen
        readerAndMaps.tmpArrList.add(tmp.toString())



        questionsArrList.add(
            "Ve městě Brně se ve věkovém rozmezí " + readerAndMaps.hashItemAgeStructure.get(
                randomNumber
            )?.ageDistance.toString() + " let nachází jaký počet obyvatel ženského pohlaví?"
        )
        randomNumber = (1..4).random()
        if (tmp != null) {
            forMethodHelpInt(randomNumber, 50000, 2, 400, tmp, false)
        }

    }


    fun questionAgeIndex() {
        var randomNumber = randomGenerator.nextInt(readerAndMaps.hashItemAgeIndex.size)
        val tmp = readerAndMaps.hashItemAgeIndex.get(randomNumber)?.indexPercentage
        readerAndMaps.tmpArrList.add(tmp.toString() + "%")



        questionsArrList.add(
            "Pro rok " + readerAndMaps.hashItemAgeIndex.get(randomNumber)?.year + " byl index stáří na jaké hodnotě?"
        )
        randomNumber = (1..4).random()
        if (tmp != null) {
            forMethodHelpDouble(randomNumber, 10, 2.0, 10, tmp, true)
        }

    }

    fun questionAgeHope() {

        var randomNumber = randomGenerator.nextInt(readerAndMaps.hashItemAgeHope.size)
        val tmp = readerAndMaps.hashItemAgeHope.get(randomNumber)?.womenJMK
        readerAndMaps.tmpArrList.add(tmp.toString())



        questionsArrList.add(
            "Naděje na dožití pro obyvatelky Jihomoravského kraje v roce " + readerAndMaps.hashItemAgeHope.get(
                randomNumber
            )?.year + " byla jaká?"
        )
        randomNumber = (1..4).random()
        if (tmp != null) {
            forMethodHelpDouble(randomNumber, 10, 1.3, 10, tmp, false)
        }


    }

    fun questionForCount() {

        var randomNumber = 0
        for (i in 1..200) {
            var tmpNum = randomGenerator.nextInt(readerAndMaps.hashItemForeignersCount.size)
            if (readerAndMaps.hashItemForeignersCount.get(tmpNum)?.countForeigners!! > 0) {
                randomNumber = tmpNum
                break
            }
        }

        val tmp = readerAndMaps.hashItemForeignersCount.get(randomNumber)?.countForeigners
        readerAndMaps.tmpArrList.add(tmp.toString())



        questionsArrList.add(
            "V roce 2018 se v Brně nacházelo kolik občanů státu " + readerAndMaps.hashItemForeignersCount.get(
                randomNumber
            )?.country + "?"
        )
        randomNumber = (1..4).random()
        if (tmp != null && tmp > 10) {
            forMethodHelpInt(randomNumber, 1000, 2, 10, tmp, false)
        } else if (tmp != null && tmp < 10) {
            forMethodHelpInt(randomNumber, 1000, 2, 10, tmp, true)
        }


    }

    fun questionForGrowth() {
        var randomNumber = 0
        for (i in 1..200) {
            var tmpNum = randomGenerator.nextInt(readerAndMaps.hashItemForeignersCount.size)
            if (readerAndMaps.hashItemForeignersCount.get(tmpNum)?.countForeigners!! > 0) {
                randomNumber = tmpNum
                break
            }
        }

        val tmp = readerAndMaps.hashItemForeignersGrowth.get(randomNumber)?.countForeigners
        readerAndMaps.tmpArrList.add(tmp.toString())



        questionsArrList.add(
            "V roce 2018 byl jaký přírůstek občaný státu " + readerAndMaps.hashItemForeignersGrowth.get(
                randomNumber
            )?.country + " do města Brna?"
        )
        randomNumber = (1..4).random()
        if (tmp != null && tmp > 10) {
            forMethodHelpInt(randomNumber, 100, 2, 10, tmp, false)
        } else if (tmp != null && tmp < 10) {
            forMethodHelpInt(randomNumber, 100, 2, 10, tmp, true)
        }
    }


    fun forMethodHelpInt(
        randomNumber: Int,
        plus: Int,
        times: Int,
        minus: Int,
        tmp: Int,
        lowCount: Boolean
    ) {
        var foo = 0
        if (lowCount == false) {
            for (i in 1..4) {
                if (randomNumber == i) {
                    optionArrList.add(tmp.toString())

                } else if (foo == 0 && randomNumber != i) {

                    optionArrList.add((tmp.plus(plus)).toString())
                    foo++


                } else if (foo == 1 && randomNumber != i) {
                    optionArrList.add((tmp.times(times)).toString())
                    foo++

                } else if (foo == 2 && randomNumber != i) {
                    optionArrList.add((tmp.minus(minus)).toString())
                    foo++
                }

            }
        }
        if (lowCount == true) {
            for (i in 1..4) {
                if (randomNumber == i) {
                    optionArrList.add(tmp.toString())

                } else if (foo == 0 && randomNumber != i) {

                    optionArrList.add((tmp.plus(plus)).toString())
                    foo++


                } else if (foo == 1 && randomNumber != i) {
                    optionArrList.add((tmp.times(times)).toString())
                    foo++

                } else if (foo == 2 && randomNumber != i) {
                    optionArrList.add((tmp.plus(20)).toString())
                    foo++
                }

            }
        }


    }

    fun forMethodHelpDouble(
        randomNumber: Int,
        plus: Int,
        times: Double,
        minus: Int,
        tmp: Double,
        percentage: Boolean
    ) {
        var foo = 0
        if (percentage == true) {
            for (i in 1..4) {
                if (randomNumber == i) {
                    optionArrList.add(tmp.toString() + "%")

                } else if (foo == 0 && randomNumber != i) {

                    optionArrList.add(String.format("%.2f", (tmp.plus(plus))) + "%")
                    foo++


                } else if (foo == 1 && randomNumber != i) {

                    optionArrList.add(String.format("%.2f", (tmp.times(times))) + "%")
                    foo++

                } else if (foo == 2 && randomNumber != i) {
                    optionArrList.add(String.format("%.2f", (tmp.minus(minus))) + "%")
                    foo++
                }

            }
        }
        if (percentage == false) {
            for (i in 1..4) {
                if (randomNumber == i) {
                    optionArrList.add(tmp.toString())

                } else if (foo == 0 && randomNumber != i) {

                    optionArrList.add(String.format("%.1f", (tmp.plus(plus))))
                    foo++


                } else if (foo == 1 && randomNumber != i) {
                    optionArrList.add(String.format("%.1f", (tmp.times(times))))
                    foo++

                } else if (foo == 2 && randomNumber != i) {
                    optionArrList.add(String.format("%.1f", (tmp.minus(minus))))
                    foo++
                }

            }
        }


    }


}


