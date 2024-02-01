package com.example.beta_ikiosk_vr14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.beta_ikiosk_vr14.frag_pro_menu.FragmentBasicInformation
import com.example.beta_ikiosk_vr14.frag_pro_menu.FragmentEmergencyContact
import com.example.beta_ikiosk_vr14.frag_pro_menu.FragmentMedicalRecord
import com.example.beta_ikiosk_vr14.frag_pro_menu.FragmentVaccineCard
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val back = findViewById<ImageView>(R.id.back_arrow)
        back.setOnClickListener {
            val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        val fragBasicInformation = FragmentBasicInformation()
        val fragMedicalRecord = FragmentMedicalRecord()
        val fragVaccineCard = FragmentVaccineCard()
        val fragEmergencyContact = FragmentEmergencyContact()

        setCurrentFragment2(fragBasicInformation)

        profile_nav_bar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_basic_info -> setCurrentFragment2(fragBasicInformation)
                R.id.nav_med_record -> setCurrentFragment2(fragMedicalRecord)
                R.id.nav_vaccine_card -> setCurrentFragment2(fragVaccineCard)
                R.id.nav_emergency_cont -> setCurrentFragment2(fragEmergencyContact)
            }
            true
        }
    }

    private fun setCurrentFragment2(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.viewPager2, fragment)
            commit()
        }
}