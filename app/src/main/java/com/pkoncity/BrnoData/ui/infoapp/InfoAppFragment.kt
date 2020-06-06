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

Brno v Datech is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Brno v Datech.  If not, see <https://www.gnu.org/licenses/>.
 */

class InfoAppFragment : Fragment() {

    /**
    This fragment manage components for example as buttons and textviews which are showed in info app section.
     */


    private lateinit var sendViewModel: InfoAppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(InfoAppViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_infoapp, container, false)


        //Initialization of button which will open new email to author.
        val buttonAboutMe = root.findViewById(R.id.buttonAboutMe) as Button
        //SetOnClick lister for open new email to author.
        buttonAboutMe.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            val data =
                Uri.parse("mailto:koncpa@gmail.com?subject=BrnoData")
            intent.data = data
            startActivity(intent)
        })

        //Initialization of button which will open website where is more info about used open source library.
        val buttonGraphView = root.findViewById(R.id.buttonGraphView) as Button
        //SetOnClick lister for open website with more info about used open source library.
        buttonGraphView.setOnClickListener(View.OnClickListener {
            val uri: Uri = Uri.parse("https://github.com/jjoe64/graphview")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        })

        //Initialization of button which will open website where is more info about app.
        val buttonGitHub = root.findViewById(R.id.buttonGitHub) as Button
        //SetOnClick lister for open website with more info about app.
        buttonGitHub.setOnClickListener(View.OnClickListener {
            val uri: Uri = Uri.parse("https://github.com/Koncpa/DataBrno/blob/master/COPYING.txt")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        })
        return root
    }
}