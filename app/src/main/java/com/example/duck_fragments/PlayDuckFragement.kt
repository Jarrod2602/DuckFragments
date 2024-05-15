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
var playCount: Int = 0
class PlayDuckFragement : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val layout = inflater.inflate(R.layout.fragment_play_duck_fragement, container, false)
        val imgPlayDuck: ImageView = layout.findViewById(R.id.imgPlayDuck)
        val lblMessage: TextView = layout.findViewById(R.id.lblMessagePlay)
        val lblMessageSatisfied: TextView = layout.findViewById(R.id.lblMessageSatisfied)
        val imgSpeechBubble: ImageView = layout.findViewById(R.id.imgSpeechBubblePlay)

        val layout2 = inflater.inflate(R.layout.fragment_duck__stats, container, false)
        val lblDuckPlay: TextView = layout2.findViewById(R.id.lblDuckPlay)
        val lblDuckFeed: TextView = layout2.findViewById(R.id.lblDuckFeed)
        var isLayout2Added = false

        imgPlayDuck.setOnClickListener{
            if(playCount < 100)
            {
                playCount += 20
                lblDuckPlay.text = "Attention: $playCount%"
                lblDuckFeed.text = "Hunger: $hungerCount%"
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
                lblMessageSatisfied.visibility = View.VISIBLE
                //Code Attribution
                //https://stackoverflow.com/questions/43348623/how-to-call-a-function-after-delay-in-kotlin
                Handler().postDelayed({
                    lblMessageSatisfied.visibility = View.INVISIBLE
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