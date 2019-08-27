package com.example.myfirstkotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import org.json.JSONObject


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerview = recycler
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerview.setHasFixedSize(true)
        //Log.d("My error hereeeee",result)


        val result = intent.getStringExtra("result")
        if(result == null){
            Toast.makeText(this, "null", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,result, Toast.LENGTH_LONG).show()
        }

        val jsonObject = JSONObject(result)
        val jArray = jsonObject.getJSONArray("topimages")
        val array = ArrayList<UsedData>()

        for (i in 0 until (jArray.length()) ){
            val finalObject = jArray.getJSONObject(i)
            array.add(UsedData(finalObject.getString("title"), finalObject.getString("image_large"), R.drawable.car))
        }


        /*val users = ArrayList<UsedData>()
        users.add(UsedData(finalObject.getString("title"), "hello", R.drawable.car))
        users.add(UsedData("kavinda", "bye", R.drawable.cat))
        users.add(UsedData("kavinda", "bye", R.drawable.lepod))
        users.add(UsedData("kavinda", "bye", R.drawable.heart))
        users.add(UsedData("kavinda", "bye", R.drawable.fire))*/

        val adapter = CustomAdapter(array)
        recyclerview.adapter = adapter
    }

}
