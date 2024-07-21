package com.example.frauddetection

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shashank.sony.fancytoastlib.FancyToast

class simpledetectionMainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_simpledetection_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn: Button = findViewById(R.id.btn)
        val sms: EditText = findViewById(R.id.data)
        val phone: EditText = findViewById(R.id.data1)
        val result: EditText = findViewById(R.id.result)

        btn.setOnClickListener {
            val SMS: String = sms.text.toString()
            var PHONE: String = phone.text.toString()


            if (SMS.isNotEmpty() && PHONE.isNotEmpty()) {
                if(PHONE.contains("+91")){
                    PHONE = PHONE.removePrefix("+91")

                }
                if (PHONE.length == 10) {
                    val fraudKeywords = listOf("win", "prize", "lottery", "click", "urgent", "free","otp","balance","A/C")
                    var isFraud = false
                    for (keyword in fraudKeywords) {
                        if (SMS.toLowerCase().contains(keyword, ignoreCase = true)) {
                            isFraud = true
                            break
                        }
                    }
                    if (isFraud) {
                        result.setText("fraud")
                    } else {
                        result.setText("no fraud")
                    }
                } else {
                    result.setText("Invalid phone number")
                }
            } else {
                FancyToast.makeText(this, "Please enter the details", FancyToast.LENGTH_LONG, FancyToast.WARNING, false).show()
            }
        }
    }
}
