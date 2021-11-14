package com.example.lab3_4

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.content.Intent.FLAG_ACTIVITY_TASK_ON_HOME
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val buttonNext: Button = findViewById(R.id.btn_a2_to_a3)
        buttonNext.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java).addFlags(FLAG_ACTIVITY_NO_HISTORY))

        }

        val buttonBack: Button = findViewById(R.id.btn_a2_to_a1)
        buttonBack.setOnClickListener {
            finish()
        }
    }
}