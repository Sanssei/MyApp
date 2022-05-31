package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SmileItemBinding
import javax.inject.Singleton

class SmileAdapter constructor(): RecyclerView.Adapter<SmileAdapter.SmileHolder>() {
    var smileList = mutableListOf<Smile>()
    class SmileHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = SmileItemBinding.bind(item)
        fun bind(smile: Smile) = with(binding){
            imageSmale.setImageResource(smile.imageResId)
            textSmile.text = smile.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmileHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.smile_item, parent, false)
        return SmileHolder(view)
    }

    override fun onBindViewHolder(holder: SmileHolder, position: Int) {
        holder.bind(smileList[position])
    }

    override fun getItemCount() = smileList.size

    fun addSmile(smile: Smile) {
        smileList.add(smile)
        println("Adapter Test: add smile ${smileList}")
        notifyDataSetChanged() //Refresh Adapter 
    }

    fun removeSmile(smile: Smile) {
        if (smileList.isNotEmpty()) {
            smileList.remove(smile)
            println("Adapter Test: remove smile ${smileList}")
            notifyDataSetChanged()
        }
    }

}