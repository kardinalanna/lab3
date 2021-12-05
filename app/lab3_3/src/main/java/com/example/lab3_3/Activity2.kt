package com.example.lab3_3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3_3.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: Activity2Binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnToFirst.setOnClickListener {
            finish()
        }

        binding.bnToThird.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.bottom_nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.activityAbout) {
            startActivity(Intent(this, ActivityAbout::class.java))
            true
        } else return super.onOptionsItemSelected(item)
    }
}
