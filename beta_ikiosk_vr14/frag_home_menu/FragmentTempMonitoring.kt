package com.example.beta_ikiosk_vr14.frag_home_menu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.beta_ikiosk_vr14.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_home_settings.*

class FragmentTempMonitoring : Fragment(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home_temp_monitoring, container, false)
        val btnDHDForm: Button = view.findViewById(R.id.btn_dhdf)
        val btnTempReport: Button = view.findViewById(R.id.btn_temp)
        btnDHDForm.setOnClickListener(this)
        btnTempReport.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_dhdf -> {
                val intent = Intent(activity, HealthDeclaration::class.java)
                startActivity(intent)
            }

            R.id.btn_temp -> {
                val intent = Intent(activity, TempReport::class.java)
                startActivity(intent)
            }
        }
    }
}