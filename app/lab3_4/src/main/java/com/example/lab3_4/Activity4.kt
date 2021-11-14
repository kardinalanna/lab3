package com.example.lab3_4

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
import android.content.Intent.FLAG_ACTIVITY_TASK_ON_HOME
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Activity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        val buttonBack: Button = findViewById(R.id.btn_a4_to_a3)
        buttonBack.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java).setFlags(FLAG_ACTIVITY_REORDER_TO_FRONT))
        }
    }
}