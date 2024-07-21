package com.example.frauddetection

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class switchMainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_switch_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn1:Button=findViewById(R.id.normal)
        val btn2:Button=findViewById(R.id.advance)

        btn1.setOnClickListener{

            val intent= Intent(this,simpledetectionMainActivity2::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent=Intent(this,recyclerMainActivity2::class.java)
            startActivity(intent)
        }

    }
}