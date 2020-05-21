package com.pkoncity.BrnoData.ui.birthness

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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

class BirthnessViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value =
            "Tato sekce zobrazuje datové sady ve formě grafů a tabulek související s populačním vývojem ve městě Brně od roku 2001 do roku 2017."
    }


    val text: LiveData<String> = _text


}

