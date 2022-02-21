package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var TextView_1=findViewById<TextView>(R.id.text_view_1)
        var TextView_2=findViewById<TextView>(R.id.text_view_2)

        val str_1= intent.getStringExtra("sa")
        val str2= intent.getStringExtra("sau")
        TextView_1.text=str_1
        TextView_2.text=str2
        Toast.makeText(this,str_1+" " +" "+ str2+"Secoend_Activity",Toast.LENGTH_LONG).show()
    }
}