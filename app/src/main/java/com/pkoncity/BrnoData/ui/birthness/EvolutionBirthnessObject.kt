package com.pkoncity.BrnoData.ui.birthness

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

class EvolutionBirthnessObject {
    var year: Int? = null
        get() = field
        set(value) {         // setter
            field = value
        }
    var birthness: Double? = null
        get() = field
        set(value) {         // setter
            field = value
        }

    var mortality: Double? = null
        get() = field
        set(value) {         // setter
            field = value
        }
}