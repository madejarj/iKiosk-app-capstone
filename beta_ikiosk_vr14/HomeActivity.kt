package com.example.beta_ikiosk_vr14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.beta_ikiosk_vr14.frag_home_menu.FragmentContactTracing
import com.example.beta_ikiosk_vr14.frag_home_menu.FragmentNewsFeed
import com.example.beta_ikiosk_vr14.frag_home_menu.FragmentSettings
import com.example.beta_ikiosk_vr14.frag_home_menu.FragmentTempMonitoring
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val studentprofile = findViewById<ImageView>(R.id.btn_student_profile)
        studentprofile.setOnClickListener {
            val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        val fragNewsFeed = FragmentNewsFeed()
        val fragConTrace = FragmentContactTracing()
        val fragTempMoni = FragmentTempMonitoring()
        val fragSettings = FragmentSettings()

        setCurrentFragment(fragNewsFeed)

        bottom_nav_bar.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_news_feed -> setCurrentFragment(fragNewsFeed)
                R.id.nav_contact_trace -> setCurrentFragment(fragConTrace)
                R.id.nav_temp_monitor -> setCurrentFragment(fragTempMoni)
                R.id.nav_settings -> setCurrentFragment(fragSettings)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.viewPager, fragment)
            commit()
        }
}