package com.example.beta_ikiosk_vr14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TechSupport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ocl_tech_support)

        val back = findViewById<ImageView>(R.id.back_arrow)
        back.setOnClickListener {
            val intent = Intent(this@TechSupport, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}