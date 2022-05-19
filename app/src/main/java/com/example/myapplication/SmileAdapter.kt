package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SmileItemBinding

class SmileAdapter: RecyclerView.Adapter<SmileAdapter.SmileHolder>() {
    val smileList = ArrayList<Smile>()
    class SmileHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = SmileItemBinding.bind(item)
        fun bind(smile: Smile) = with(binding){
            imageSmale.setImageResource(smile.imageId)
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
        notifyDataSetChanged() //Refresh Adapter 
    }
}