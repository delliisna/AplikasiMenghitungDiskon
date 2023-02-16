package com.example.menghitungdiskon_delliisna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class diskonAdapter (private val dataSet:MutableList<datadiskon>):
        RecyclerView.Adapter<diskonAdapter.DiskonViewHolder>(){
        class DiskonViewHolder(view: View):RecyclerView.ViewHolder(view){
                val dskn=view.findViewById<TextView>(R.id.T_dskn)
                val hrg=view.findViewById<TextView>(R.id.T_harga)
                val ic_delete:ImageButton=view.findViewById(R.id.ib_hapus)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiskonViewHolder {
                val md=LayoutInflater.from(parent.context)
                        .inflate(R.layout.activity_diskon_adapter,parent,false)
                          return DiskonViewHolder(md)
        }

        override fun onBindViewHolder(holder: DiskonViewHolder, position: Int) {
               holder.dskn.text=dataSet[position].diskon_eskrim
                holder.hrg.text=dataSet[position].harganrml_eskrim.toString()
                holder.ic_delete.setOnClickListener {
                        dataSet.removeAt(position)
                        notifyItemRangeChanged(position,dataSet.size)
                        notifyDataSetChanged()
                }
        }

        override fun getItemCount(): Int {
               return dataSet.size
        }

}