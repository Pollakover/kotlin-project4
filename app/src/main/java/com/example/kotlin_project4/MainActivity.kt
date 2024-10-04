package com.example.kotlin_project4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraButton: Button = findViewById(R.id.cameraButton)
        val listButton: Button = findViewById(R.id.listButton)

        cameraButton.setOnClickListener {
            val intent = Intent(this, Camera::class.java)
            startActivity(intent)
        }

        listButton.setOnClickListener {
            val intent = Intent(this, List::class.java)
            startActivity(intent)
        }
    }
}
