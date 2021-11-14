package com.example.lab3_4

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_TASK_ON_HOME
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val button: Button = findViewById(R.id.btn_a1_to_a2)
        button.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }

    }

}