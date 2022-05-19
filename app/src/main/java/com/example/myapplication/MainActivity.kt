package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = SmileAdapter()
    private val imageIdList = listOf(R.drawable.smile1, R.drawable.smile2, R.drawable.smile3,
        R.drawable.smile4, R.drawable.smile5, R.drawable.smile6, R.drawable.smile7,
        R.drawable.smile8)
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init () {
        binding.apply{
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            recyclerView.adapter = adapter
            buttonAdd.setOnClickListener {
                if (index > 7) index = 0
                val smile = Smile(imageIdList[index], "Smile $index")
                adapter.addSmile(smile)
                index++
            }
        }
    }
}