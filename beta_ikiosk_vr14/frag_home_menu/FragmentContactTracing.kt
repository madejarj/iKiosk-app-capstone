package com.example.beta_ikiosk_vr14.frag_home_menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import com.example.beta_ikiosk_vr14.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_home_settings.*

class FragmentContactTracing : Fragment(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home_contact_tracing, container, false)
        val btnContact: Button = view.findViewById(R.id.btn_contact)
        val btnReport: Button = view.findViewById(R.id.btn_report)
        btnContact.setOnClickListener(this)
        btnReport.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_contact -> {
                val intent = Intent(activity, ContactGroup::class.java)
                startActivity(intent)
            }

            R.id.btn_report -> {
                val intent = Intent(activity, IncidentReport::class.java)
                startActivity(intent)
            }

        }
    }
}