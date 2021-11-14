package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val buttonNext: Button = findViewById(R.id.btn_a2_to_a3)
        buttonNext.setOnClickListener {
            startActivityForResult(Intent(this, Activity3::class.java), Activity3.ACT3)

        }

        val buttonBack: Button = findViewById(R.id.btn_a2_to_a1)
        buttonBack.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == Activity3.ACT3 && resultCode == Activity3.toA1) finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.getItemId() == R.id.about )
            startActivity(Intent(this, ActivityAbout::class.java))
        return super.onOptionsItemSelected(item)
    }
}