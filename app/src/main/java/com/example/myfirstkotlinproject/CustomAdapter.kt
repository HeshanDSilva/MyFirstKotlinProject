package com.example.myfirstkotlinproject

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.R.id
import com.squareup.picasso.Picasso
import kotlin.coroutines.coroutineContext


class CustomAdapter(val UsedData:ArrayList<UsedData>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.item_view,p0,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return UsedData.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val user:UsedData = UsedData[p1]
        val image:Int = user.idn
        p0.textViewName.text = user.name
        /*p0.textviewAddress.text = user.address*/
        Picasso.get().load(user.address).into(p0.imageViewShow)
        /*p0.imageViewShow.setImageResource(image)*/
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewName = itemView.findViewById(R.id.textViewName) as TextView
        /*val textviewAddress = itemView.findViewById(R.id.textViewAddress) as TextView*/
        val imageViewShow = itemView.findViewById<ImageView>(R.id.imageViewShow)
    }
}