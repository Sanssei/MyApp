package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val adapter = SmileAdapter()
//    private val invoker = Invoker()
//    private val smileFactory = SmileFactory()
//    private val receiver = Receiver(invoker, adapter, smileFactory)
    @Inject  lateinit var receiver: Receiver
//    @Inject  lateinit var receiver2: Receiver
    @Inject  lateinit var adapter: SmileAdapter
//    @Inject  lateinit var adapter2: SmileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSmileComponent.create().inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init () {

//        println("MyLog Adapter = $adapter")
//        println("MyLog Adapter2 = $adapter2")
//        println("MyLog Receiver = ${receiver}")
//        println("MyLog Receiver2 = ${receiver2}")
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
