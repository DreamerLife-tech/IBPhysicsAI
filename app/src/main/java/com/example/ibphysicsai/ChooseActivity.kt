package com.example.ibphysicsai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn9Grade = findViewById<Button>(R.id.btn9Grade)
        val btn10Grade = findViewById<Button>(R.id.btn10Grade)
        val btn11Grade = findViewById<Button>(R.id.btn11Grade)
        val btn12Grade = findViewById<Button>(R.id.btn12Grade)



        btn9Grade.setOnClickListener {
            startActivity(Intent(this, TheoryActivity::class.java))
        }


        btn10Grade.setOnClickListener {
            startActivity(Intent(this, TheoryActivity::class.java))
        }


        btn11Grade.setOnClickListener {
            startActivity(Intent(this, TheoryActivity::class.java))
        }


        btn12Grade.setOnClickListener {
            startActivity(Intent(this, TheoryActivity::class.java))
        }
    }
}
