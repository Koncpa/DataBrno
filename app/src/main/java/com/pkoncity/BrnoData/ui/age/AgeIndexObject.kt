package com.pkoncity.BrnoData.ui.age

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

class AgeIndexObject {

    var year: Int? = null
        get() = field
        set(value) {         // setter
            field = value
        }

    var indexPercentage: Double = 0.0
        get() = field
        set(value) {         // setter
            field = value
        }
}