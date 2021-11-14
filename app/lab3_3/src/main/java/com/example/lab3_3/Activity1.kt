package com.example.lab3_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.lab3_3.databinding.Activity1Binding

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: Activity1Binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA1ToA2.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java    ))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(item.itemId == R.id.about ){
            startActivity(Intent(this, ActivityAbout::class.java))
            true
        }
        else return super.onOptionsItemSelected(item)
    }
}