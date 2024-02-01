package com.example.beta_ikiosk_vr14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beta_ikiosk_vr14.databinding.OclContactGroupBinding
import com.example.beta_ikiosk_vr14.read_contact_group.ContactAdapter
import com.example.beta_ikiosk_vr14.read_contact_group.ContactModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ContactGroup : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var db: FirebaseFirestore

    lateinit var binding: OclContactGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OclContactGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()


        var currentUser = auth.currentUser
        loadAllData(currentUser!!.uid.toString())


        //swipe refresh
        binding.refreshContact.setOnRefreshListener {
            if (binding.refreshContact.isRefreshing) {
                binding.refreshContact.isRefreshing = false
            }
            loadAllData(currentUser!!.uid)
        }

        val back = findViewById<ImageView>(R.id.back_arrow)
        back.setOnClickListener {
            val intent = Intent(this@ContactGroup, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun goToLogin() {
        startActivity(Intent(this@ContactGroup, SignInActivity::class.java))
        finish()
    }

    //for laoding all task from server
    fun loadAllData(userID: String) {

        val taskList = ArrayList<ContactModel>()

        var ref = db.collection(
            "contact_group")
        ref.whereEqualTo(
            "uid", userID)
            .get()
            .addOnSuccessListener {
                if (it.isEmpty) {
                    Toast.makeText(this@ContactGroup, "No contact group found!", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener
                }
                for (doc in it) {
                    val ContactModel = doc.toObject(ContactModel::class.java)
                    taskList.add(ContactModel)
                }

                binding.rvToDoList.apply {
                    layoutManager =
                        LinearLayoutManager(this@ContactGroup, RecyclerView.VERTICAL, false)
                    adapter = ContactAdapter(taskList, this@ContactGroup)
                }
            }
    }
}