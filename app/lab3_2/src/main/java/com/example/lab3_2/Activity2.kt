package com.example.lab3_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.app.Activity
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback

import androidx.activity.result.contract.ActivityResultContracts

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import java.lang.String


class Activity2 : AppCompatActivity() {

    companion object{
        const val STOP_SECOND = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val buttonNext: Button = findViewById(R.id.btn_a2_to_a3)
        val intent = Intent(this, Activity3::class.java)
        buttonNext.setOnClickListener {
            mStartForResult.launch(intent)
        }

        val buttonBack: Button = findViewById(R.id.btn_a2_to_a1)
        buttonBack.setOnClickListener {
            finish()
        }
    }

    private var mStartForResult = registerForActivityResult(StartActivityForResult())
    { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            if (intent!!.getBooleanExtra(String.valueOf(STOP_SECOND), false)) finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.about )
            startActivity(Intent(this, ActivityAbout::class.java))
        return super.onOptionsItemSelected(item)
    }
}