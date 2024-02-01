package com.example.beta_ikiosk_vr14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.beta_ikiosk_vr14.frag_art_menu.*
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val back = findViewById<ImageView>(R.id.back_arrow)
        back.setOnClickListener {
            val intent = Intent(this@ArticleActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        val covidOverview = FragmentCovidOverview()
        val covidSymptoms = FragmentCovidSymptoms()
        val vaccineFacts = FragmentVaccineFacts()
        val universityGuidelines = FragmentUniversityGuidelines()
        val ikioskManual = FragmentIkioskManual()

        setCurrentFragment3(covidOverview)

        article_nav_bar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_overview -> setCurrentFragment3(covidOverview)
                R.id.nav_symptoms -> setCurrentFragment3(covidSymptoms)
                R.id.nav_vaccines -> setCurrentFragment3(vaccineFacts)
                R.id.nav_ucbguidelines -> setCurrentFragment3(universityGuidelines)
                R.id.nav_manual -> setCurrentFragment3(ikioskManual)
            }
            true
        }
    }

    private fun setCurrentFragment3 (fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.viewPager3, fragment)
            commit()
        }
}