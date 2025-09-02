package com.example.ibphysicsai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnTheory = findViewById<Button>(R.id.btnTheory)
        val btnFormulas = findViewById<Button>(R.id.btnFormulas)
        val btnPractice = findViewById<Button>(R.id.btnPracticeAI)


        btnTheory.setOnClickListener {
            startActivity(Intent(this, ChooseActivity::class.java))
        }

        btnFormulas.setOnClickListener {
            startActivity(Intent(this, ChooseActivity::class.java))
        }

        btnPractice.setOnClickListener {
            startActivity(Intent(this, PracticeAIActivity::class.java))
        }
    }
}
