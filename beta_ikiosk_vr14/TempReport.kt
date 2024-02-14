package com.example.beta_ikiosk_vr14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beta_ikiosk_vr14.databinding.OclTempReportBinding
import com.example.beta_ikiosk_vr14.read_temp_report.TempAdapter
import com.example.beta_ikiosk_vr14.read_temp_report.TempModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TempReport : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var db: FirebaseFirestore

    lateinit var binding: OclTempReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OclTempReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        var currentUser = auth.currentUser

        loadAllData(currentUser!!.uid.toString())


        //swipe refresh
        binding.refreshTemp.setOnRefreshListener {
            if (binding.refreshTemp.isRefreshing) {
                binding.refreshTemp.isRefreshing = false
            }
            loadAllData(currentUser!!.uid)
        }


        val back = findViewById<ImageView>(R.id.back_arrow)
        back.setOnClickListener {
            val intent = Intent(this@TempReport, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun goToLogin() {
        startActivity(Intent(this@TempReport, SignInActivity::class.java))
        finish()
    }

    //for loading all task from server
    fun loadAllData(userID: String) {

        val taksList = ArrayList<TempModel>()

        var ref = db.collection(
            "temp_report")
        ref.whereEqualTo(
            "userID", userID)
            .get()
            .addOnSuccessListener {
                if (it.isEmpty) {
                    Toast.makeText(this@TempReport, "No temperature report found!", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener
                }
                for (doc in it) {
                    val TempModel = doc.toObject(TempModel::class.java)
                    taksList.add(TempModel)
                }

                binding.rvToDoList.apply {
                    layoutManager =
                        LinearLayoutManager(this@TempReport, RecyclerView.VERTICAL, false)
                    adapter = TempAdapter(taksList, this@TempReport)
                }
            }
    }
}
