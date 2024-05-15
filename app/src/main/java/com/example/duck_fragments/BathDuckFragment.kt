package com.example.duck_fragments

import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
var bathCount: Int = 0
class BathDuckFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val layout = inflater.inflate(R.layout.fragment_bath_duck, container, false)
        val imgBathDuck: ImageView = layout.findViewById(R.id.imgBathDuck)
        val lblMessage: TextView = layout.findViewById(R.id.lblMessageBath)
        val lblMessageCleaned: TextView = layout.findViewById(R.id.lblMessageCleaned)
        val imgSpeechBubble: ImageView = layout.findViewById(R.id.imgSpeechBubbleBath)

        val layout2 = inflater.inflate(R.layout.fragment_duck__stats, container, false)
        val lblDuckPlay: TextView = layout2.findViewById(R.id.lblDuckPlay)
        val lblDuckFeed: TextView = layout2.findViewById(R.id.lblDuckFeed)
        val lblDuckBath: TextView = layout2.findViewById(R.id.lblDuckBath)
        var isLayout2Added = false

        imgBathDuck.setOnClickListener{
            if(bathCount < 100)
            {
                bathCount += 20
                lblDuckPlay.text = "Attention: $playCount%"
                lblDuckFeed.text = "Hunger: $hungerCount%"
                lblDuckBath.text = "Cleanliness: $bathCount%"
                lblMessage.visibility = View.VISIBLE
                imgSpeechBubble.visibility = View.VISIBLE
                Handler().postDelayed({
                    lblMessage.visibility = View.INVISIBLE
                    imgSpeechBubble.visibility = View.INVISIBLE
                }, 1000)
            }
            else
            {
                lblDuckPlay.text = "Attention: $playCount%"
                lblDuckFeed.text = "Hunger: $hungerCount%"
                lblDuckBath.text = "Cleanliness: $bathCount%"
                lblMessageCleaned.visibility = View.VISIBLE
                //Code Attribution
                //https://stackoverflow.com/questions/43348623/how-to-call-a-function-after-delay-in-kotlin
                Handler().postDelayed({
                    lblMessageCleaned.visibility = View.INVISIBLE
                }, 1000)
            }

            if (!isLayout2Added) {
                container?.addView(layout2)
                isLayout2Added = true
            }
        }
        return layout
    }
}