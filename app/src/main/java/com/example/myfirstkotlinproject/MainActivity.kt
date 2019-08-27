package com.example.myfirstkotlinproject

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.SeekBar
import android.os.AsyncTask
import android.util.Log
import java.net.HttpURLConnection
import java.net.URL





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTextViewTranslationY = textView_progress.translationY
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textView_progress.text = p1.toString()
                val TranslationDistance = (initialTextViewTranslationY + p1* resources.getDimension(R.dimen.text_anim_step) *-1 )
                textView_progress.animate().translationY(TranslationDistance)
                if(!p2){
                    textView_progress.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationY)
                }


            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        button_reset.setOnClickListener { v ->
            seekBar.progress = 0

        }


        home_button.setOnClickListener {
            GetDataFromUrl().execute("http://fortunagate.com/Amaya/service.php?q=hotels")
           /* val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)*/
        }

    }

    inner class GetDataFromUrl : AsyncTask<String,String,String>(){

        override fun doInBackground(vararg p0: String?): String {
            val connection = URL(p0[0]).openConnection() as HttpURLConnection
            val string = connection.inputStream.bufferedReader().readText()
            return string
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            intent.putExtra("result",result)
            startActivity(intent)
            Log.d("My Apppppppppppppppp",result)
        }

    }

}


