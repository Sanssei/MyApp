package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = SmileAdapter()
    private val invoker = Invoker()
    private val smileFactory = SmailFactory()
    private val receiver = Receiver(invoker, adapter, smileFactory)
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
                receiver.add(SmileIdentificator.getAndIncrement())
                println("Adapter Test: Last id  ${adapter.smileList.last().id}")
            }
            buttonRemoved.setOnClickListener{
                if (adapter.smileList.isNotEmpty())
                    receiver.remove(adapter.smileList.last().id)
                else Toast.makeText(this@MainActivity,
                    "Смайлики закончились", Toast.LENGTH_SHORT).show()
            }
            buttonCancel.setOnClickListener {
                receiver.unDo()
            }
        }
    }
}
