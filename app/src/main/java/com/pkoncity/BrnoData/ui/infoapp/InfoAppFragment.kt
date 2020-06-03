package com.pkoncity.BrnoData.ui.infoapp

import android.content.Intent
import android.net.Uri
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

Foobar is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.
 */

class InfoAppFragment : Fragment() {

    private lateinit var sendViewModel: InfoAppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(InfoAppViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_infoapp, container, false)


        val buttonAboutMe = root.findViewById(R.id.buttonAboutMe) as Button
        buttonAboutMe.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            val data =
                Uri.parse("mailto:koncpa@gmail.com?subject=BrnoData")
            intent.data = data
            startActivity(intent)
        })

        val buttonGraphView = root.findViewById(R.id.buttonGraphView) as Button
        buttonGraphView.setOnClickListener(View.OnClickListener {
            val uri: Uri = Uri.parse("https://github.com/jjoe64/graphview")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        })
        val buttonGitHub = root.findViewById(R.id.buttonGitHub) as Button
        buttonGitHub.setOnClickListener(View.OnClickListener {
            val uri: Uri = Uri.parse("https://github.com/Koncpa/DataBrno/blob/master/COPYING.txt")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        })
        return root
    }
}