package com.example.beta_ikiosk_vr14.write_dhd

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beta_ikiosk_vr14.databinding.ItemDhdBinding

class DHDAdapter(val taskList: ArrayList<DHDModel>, val context: Context) :
    RecyclerView.Adapter<DHDAdapter.MyHoler>() {

    class MyHoler(val binding: ItemDhdBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHoler {

        val binding = ItemDhdBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyHoler(binding)
    }

    override fun onBindViewHolder(holder: MyHoler, position: Int) {
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}