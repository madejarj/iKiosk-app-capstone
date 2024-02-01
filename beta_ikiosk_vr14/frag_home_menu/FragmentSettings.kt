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

class FragmentSettings : Fragment(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home_settings, container, false)
        val btnLogout: Button = view.findViewById(R.id.btn_logout)
        val btnArticle: Button = view.findViewById(R.id.btn_art)
        val btnTechSupport: Button = view.findViewById(R.id.btn_tech_support)
        val btnUpdateStatus: Button = view.findViewById(R.id.btn_update_status)
        val btnSuggComp: Button = view.findViewById(R.id.btn_sugg_comp)

        btnLogout.setOnClickListener(this)
        btnArticle.setOnClickListener(this)
        btnUpdateStatus.setOnClickListener(this)
        btnTechSupport.setOnClickListener(this)
        btnSuggComp.setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_art -> {
                val intent = Intent(activity, ArticleActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_logout -> {
                btn_logout.setOnClickListener {
                    Toast.makeText(getContext(), "Signed Out.", Toast.LENGTH_SHORT).show()
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(activity, SignInActivity::class.java)
                    startActivity(intent)
                }
            }
            R.id.btn_update_status -> {
                val intent = Intent(activity, UpdateStatus::class.java)
                startActivity(intent)
            }
            R.id.btn_tech_support -> {
                val intent = Intent(activity, TechSupport::class.java)
                startActivity(intent)
            }
            R.id.btn_sugg_comp -> {
                val intent = Intent(activity, SuggComp::class.java)
                startActivity(intent)
            }
    }
    }
}