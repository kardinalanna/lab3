package com.example.lab3_4

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.lab3_4.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val buttonNext: Button = findViewById(R.id.btn_a3_to_a4)
        buttonNext.setOnClickListener {
            startActivity(Intent(this, Activity4::class.java))

        }

        val buttonBack: Button = findViewById(R.id.btn_a3_to_a2)
        buttonBack.setOnClickListener {
            finish()
        }
    }
}