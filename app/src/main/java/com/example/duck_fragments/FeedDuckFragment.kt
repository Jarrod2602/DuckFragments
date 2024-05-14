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
var hungerCount: Int = 0
class FeedDuckFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val layout = inflater.inflate(R.layout.fragment_feed_duck, container, false)
        val imgFeedDuck: ImageView = layout.findViewById(R.id.imgFeedDuck)
        val lblMessage: TextView = layout.findViewById(R.id.lblMessageFeed)
        val lblMessageFull: TextView = layout.findViewById(R.id.lblMessageFull)
        val imgSpeechBubble: ImageView = layout.findViewById(R.id.imgSpeechBubble)

        val layout2 = inflater.inflate(R.layout.fragment_duck__stats, container, false)
        val lblDuckHunger: TextView = layout2.findViewById(R.id.lblDuckFeed)
        var isLayout2Added = false

        imgFeedDuck.setOnClickListener{
            if(hungerCount < 100)
            {
                hungerCount += 20
                lblDuckHunger.text = "Hunger: $hungerCount%"
                lblMessage.visibility = View.VISIBLE
                imgSpeechBubble.visibility = View.VISIBLE
                Handler().postDelayed({
                    lblMessage.visibility = View.INVISIBLE
                    imgSpeechBubble.visibility = View.INVISIBLE
                }, 1000)
            }
            else
            {
                lblDuckHunger.text = "Hunger: $hungerCount%"
                lblMessageFull.visibility = View.VISIBLE
                //Code Attribution
                //https://stackoverflow.com/questions/43348623/how-to-call-a-function-after-delay-in-kotlin
                Handler().postDelayed({
                    lblMessageFull.visibility = View.INVISIBLE
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