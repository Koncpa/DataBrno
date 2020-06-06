package com.pkoncity.BrnoData


import android.content.res.Resources
import com.pkoncity.BrnoData.ui.age.AgeHopeObject
import com.pkoncity.BrnoData.ui.age.AgeIndexObject
import com.pkoncity.BrnoData.ui.age.AgeStructureObject
import com.pkoncity.BrnoData.ui.birthness.DynEvolutionObject
import com.pkoncity.BrnoData.ui.foreigners.ForeignersCountBrnoObject
import com.pkoncity.BrnoData.ui.foreigners.ForeignersEvolutionObject
import com.pkoncity.BrnoData.ui.generalDemo.CitizenCountObject
import com.pkoncity.BrnoData.ui.generalDemo.HumanDensityObject
import com.pkoncity.BrnoData.ui.generalDemo.UnemploymentObject
import com.pkoncity.BrnoData.ui.birthness.EvolutionBirthnessObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.Charset
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
 */

class ReaderAndMaps {

    /**
    This Activity read all .csv files which are showed in app.
     */


    //Initialization of HashMaps which are use for load data from .csv files.
    val hashItemAgeStructure = HashMap<Int, AgeStructureObject>()
    val hashItemAgeIndex = HashMap<Int, AgeIndexObject>()
    val hashItemForeignersCount = HashMap<Int, ForeignersCountBrnoObject>()
    val hashItemForeignersGrowth = HashMap<Int, ForeignersCountBrnoObject>()
    val hashItemForeignersEvolution = HashMap<Int, ForeignersEvolutionObject>()
    val hashItemAgeHope = HashMap<Int, AgeHopeObject>()
    val hashItemEvoBirthness = HashMap<Int, EvolutionBirthnessObject>()
    val hashItemDynEvolution = HashMap<Int, DynEvolutionObject>()
    val hashItemHumanDensity = HashMap<Int, HumanDensityObject>()
    val hashItemUnemployment = HashMap<Int, UnemploymentObject>()
    val hashItemCitizenCount = HashMap<Int, CitizenCountObject>()
    //Tmp arraylist which is used for temporary steps in other class.
    val tmpArrList = ArrayList<String>()

    //Here will be described one model method how works loading files to hashMaps, every file has own load method and own HashMap. So next method are will not described, because are basically same.
    fun ageStructureReader(resources: Resources) {

        //Loading .csv file to InputStream
        val inputStream: InputStream = resources.openRawResource(R.raw.vekovastrukturabrna1)
        //Loading inputStream to bufferedReader, which stream read in UTF-8 format
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0

        //Foor loop which read data forEach line.
        reader.readLines().forEach {

            //Split all words in line, split character is ;.
            val items = it.split(";")
            //Initialize object to which will be save data from .csv file and then add to HashMap.
            val aObject = AgeStructureObject()


            //Load specific data on line as specific attributes of object.
            if (tmp >= 2) {
                for (i in items.indices) {
                    if (i == 0) {
                        aObject.ageDistance = items.get(i)

                    } else if (i == 1) {
                        aObject.countAgeMen = items.get(i).toInt()
                    } else if (i == 2) {
                        aObject.countAgeWomen = items.get(i).toInt()
                    }
                }

            }


            //Save object to HashMap of object.
            if (!aObject.ageDistance.isNullOrEmpty()) {
                hashItemAgeStructure.put(tmp - 2, aObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()

    }

    //Same principle as first described method, but load different data set.
    fun ageIndexReader(resources: Resources) {

        val inputStream: InputStream = resources.openRawResource(R.raw.indexstari1)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val aObject = AgeIndexObject()



            if (tmp >= 1) {
                for (i in items.indices) {
                    if (i == 0) {

                        aObject.year = items.get(i).toInt()

                    } else if (i == 1) {

                        aObject.indexPercentage = items.get(i).toDouble()
                    }
                }

            }

            if (tmp >= 1) {
                hashItemAgeIndex.put(tmp - 1, aObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()

    }

    //Same principle as first described method, but load different data set.
    fun ageHopeReader(resources: Resources) {

        val inputStream: InputStream = resources.openRawResource(R.raw.nadejedoziti1)
        val reader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val aObject = AgeHopeObject()



            if (tmp >= 2) {
                for (i in items.indices) {
                    if (i == 0) {

                        aObject.year = items.get(i).toInt()

                    } else if (i == 1) {

                        aObject.menJMK = items.get(i).toDouble()
                    } else if (i == 2) {


                        aObject.womenJMK = items.get(i).toDouble()
                    } else if (tmp >= 20 && i == 3) {


                        aObject.menBrno = items.get(i).toDouble()


                    } else if (tmp >= 20 && i == 4) {

                        aObject.womenBrno = items.get(i).toDouble()


                    }


                }

            }

            if (tmp >= 2) {
                hashItemAgeHope.put(tmp - 2, aObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()

    }

    //Same principle as first described method, but load different data set.
    fun foreignersEvolutionReader(resources: Resources) {

        val inputStream: InputStream = resources.openRawResource(R.raw.datacizincivyvoj)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val fObject = ForeignersEvolutionObject()



            if (tmp >= 2) {
                for (i in items.indices) {
                    if (i == 0) {

                        fObject.year = items.get(i)

                    } else if (i == 1) {

                        fObject.countForeignersCity = items.get(i).toInt()
                    } else if (i == 2) {
                        fObject.countForeignersCountryside = items.get(i).toInt()

                    }
                }

            }

            if (!fObject.year.isNullOrEmpty()) {
                hashItemForeignersEvolution.put(tmp - 2, fObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()

    }

    //Same principle as first described method, but load different data set.
    fun foreignersCountReader(resources: Resources) {

        val inputStream = resources.openRawResource(R.raw.datacizincipocet)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val fObject = ForeignersCountBrnoObject()



            if (tmp >= 1) {
                for (i in items.indices) {
                    if (i == 0) {

                        fObject.country = items.get(i)

                    } else if (i == 1) {

                        fObject.countForeigners = items.get(i).toInt()
                    } else if (i == 3) {
                        fObject.legendForeigners = items.get(i)

                    }
                }

            }

            if (!fObject.country.isNullOrEmpty()) {
                hashItemForeignersCount.put(tmp - 1, fObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()

    }

    //Same principle as first described method, but load different data set.
    fun foreignersGrowthReader(resources: Resources) {


        val inputStream = resources.openRawResource(R.raw.datacizinciprirustek)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val fObject = ForeignersCountBrnoObject()



            if (tmp >= 1) {
                for (i in items.indices) {
                    if (i == 0) {

                        fObject.country = items.get(i)

                    } else if (i == 1) {

                        fObject.countForeigners = items.get(i).toInt()
                    } else if (i == 3) {
                        fObject.legendForeigners = items.get(i)

                    }
                }

            }

            if (!fObject.country.isNullOrEmpty()) {
                hashItemForeignersGrowth.put(tmp - 1, fObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()
    }

    //Same principle as first described method, but load different data set.
    fun evolutionBirthnessReader(resources: Resources) {

        val inputStream = resources.openRawResource(R.raw.hrubamiraporodnostiumrtnosti1)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val bObject = EvolutionBirthnessObject()



            if (tmp >= 2) {
                for (i in items.indices) {
                    if (i == 0) {

                        bObject.year = items.get(i).toInt()

                    } else if (i == 1) {

                        bObject.birthness = items.get(i).toDouble()

                    } else if (i == 2) {
                        bObject.mortality = items.get(i).toDouble()

                    }
                }

            }

            if (tmp >= 2) {
                hashItemEvoBirthness.put(tmp - 2, bObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()

    }

    //Same principle as first described method, but load different data set.
    fun dynamicEvolutinReader(resources: Resources) {

        val inputStream = resources.openRawResource(R.raw.dynamikapopulacnihovyvojebrna1)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val bObject = DynEvolutionObject()



            if (tmp >= 2) {
                for (i in items.indices) {
                    if (i == 0) {

                        bObject.year = items.get(i).toInt()

                    } else if (i == 1) {

                        bObject.naturalGrowth = items.get(i).toDouble()

                    } else if (i == 2) {
                        bObject.migrationSaldo = items.get(i).toDouble()

                    } else if (i == 3) {
                        bObject.allGrowth = items.get(i).toDouble()

                    }
                }

            }

            if (tmp >= 2) {
                hashItemDynEvolution.put(tmp - 2, bObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()

    }

    //Same principle as first described method, but load different data set.
    fun humanDensityReader(resources: Resources) {
        val inputStream = resources.openRawResource(R.raw.hustotazalidneni1)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val gObject = HumanDensityObject()



            if (tmp >= 1) {
                for (i in items.indices) {
                    if (i == 0) {

                        gObject.year = items.get(i).toInt()

                    } else if (i == 1) {

                        gObject.humanePerKm = items.get(i).toInt()

                    }
                }

            }

            if (tmp >= 1) {
                hashItemHumanDensity.put(tmp - 1, gObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()

    }

    //Same principle as first described method, but load different data set.
    fun unemploymentReader(resources: Resources) {

        val inputStream =
            resources.openRawResource(R.raw.podilnezamestnanychosob1moznepridani)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {

            val items = it.split(";")
            val gObject = UnemploymentObject()



            if (tmp >= 2) {
                for (i in items.indices) {
                    if (i == 0) {

                        gObject.year = items.get(i).toInt()

                    } else if (i == 1) {

                        gObject.unemploymentCR = items.get(i).toDouble()

                    } else if (i == 2) {

                        gObject.unemploymentJMK = items.get(i).toDouble()

                    } else if (i == 3) {

                        gObject.unemploymentBrno = items.get(i).toDouble()

                    }
                }

            }

            if (tmp >= 2) {
                hashItemUnemployment.put(tmp - 2, gObject)
            }
            tmp += 1
        }

        inputStream.close()
        reader.close()


    }

    //Same principle as first described method, but load different data set.
    fun countCitizen(resources: Resources) {

        val inputStream =
            resources.openRawResource(R.raw.vyvojpoctuobyvatelvbrne1)
        val reader =
            BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        var tmp = 0
        reader.readLines().forEach {


            //get a string array of all items in this line
            val items = it.split(";")
            val gObject = CitizenCountObject()



            if (tmp >= 1) {
                for (i in items.indices) {
                    if (i == 0) {

                        gObject.year = items.get(i).toInt()

                    } else if (i == 1) {

                        gObject.countMen = items.get(i).toInt()

                    } else if (i == 2) {

                        gObject.countWomen = items.get(i).toInt()

                    }
                }

            }

            if (tmp >= 1) {
                hashItemCitizenCount.put(tmp - 1, gObject)
            }
            tmp += 1
        }



        inputStream.close()
        reader.close()

    }


    //This method call all reading files method.
    fun allReaders(allResources: Resources) {
        ageStructureReader(allResources)
        ageIndexReader(allResources)
        ageHopeReader(allResources)
        foreignersCountReader(allResources)
        foreignersEvolutionReader(allResources)
        foreignersGrowthReader(allResources)
        evolutionBirthnessReader(allResources)
        dynamicEvolutinReader(allResources)
        humanDensityReader(allResources)
        unemploymentReader(allResources)
        countCitizen(allResources)
    }

}





