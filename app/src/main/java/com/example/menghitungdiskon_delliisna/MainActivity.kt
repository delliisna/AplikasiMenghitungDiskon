package com.example.menghitungdiskon_delliisna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var input_harga : EditText
    private lateinit var input_jumlah:EditText
    private lateinit var txt_diskon:TextView
    private lateinit var txt_hargaktr:TextView
    private lateinit var txt_ttl:TextView
    private lateinit var bt_hitung:Button
    private lateinit var bt_save:Button
    private var vhrgkotor : Double=0.0
    private var vtotal :Double =0.0
    private var vharga:Double=0.0
    private var vjml:Double=0.0
    private lateinit var diskon: String
    private lateinit var recyclerview:RecyclerView
    private lateinit var recycleradapter:RecyclerView.Adapter<*>
    private lateinit var layoutmanager:RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         input_harga=findViewById(R.id.et_harga)
         input_jumlah=findViewById(R.id.et_jumlah)
         txt_diskon=findViewById(R.id.thitung_diskon)
         txt_hargaktr=findViewById(R.id.harga_normal)
         txt_ttl=findViewById(R.id.hasil_diskon)
         bt_hitung=findViewById(R.id.btn_hitung)
        bt_save=findViewById(R.id.btn_save)
        recyclerview=findViewById(R.id.rv_history)

        //membuat variable untuk menyipan data ke datadiskon
        val simpandata= mutableListOf<datadiskon>()
        layoutmanager=LinearLayoutManager(this)
        recycleradapter=diskonAdapter(simpandata)
        recyclerview.adapter=recycleradapter
        recyclerview.layoutManager=layoutmanager

        //onclick button hitung
        bt_save.setOnClickListener{
            //step 1 kita buat variable untuk mrnyimpan data ke array
            val diskon_es =txt_diskon.text.toString()
            val harga_es=txt_hargaktr.text.toString()

            //code agar dapat di simpan

            val menghitung=datadiskon(diskon_es,harga_es)
            simpandata.add(menghitung)
            recycleradapter.notifyDataSetChanged()

        }


       //perintah untuk menghitung button hitung
        bt_hitung.setOnClickListener {
           vharga = input_harga.text.toString().toDouble()
            vjml = input_jumlah.text.toString().toDouble()

            vhrgkotor=vharga*vjml

            if (vjml >= 8){
                vtotal = vhrgkotor -(vhrgkotor*0.20)
                diskon ="20%"

            }else if (vjml >= 5){
                vtotal= vhrgkotor -(vhrgkotor*0.10)
                diskon="10%"

            }else{
                vtotal=vhrgkotor
                diskon="0%"
            }
            txt_diskon.setText(diskon)
            txt_hargaktr.setText(vhrgkotor.toString())
            txt_ttl.setText(vtotal.toString())
        }

    }

}