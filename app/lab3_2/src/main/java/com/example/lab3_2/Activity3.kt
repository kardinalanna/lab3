package com.example.lab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val buttonBack2: Button = findViewById(R.id.btn_a3_to_a2)
        buttonBack2.setOnClickListener {
            setResult(RESULT_OK, Intent())
            finish()
        }

        val buttonBack1: Button = findViewById(R.id.btn_a3_to_a1)
        buttonBack1.setOnClickListener {
            val intent = Intent().putExtra(Activity2.STOP_SECOND.toString(), true)
            setResult(RESULT_OK, intent)
            finish()
        }
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