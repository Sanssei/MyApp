package com.example.myapplication

import javax.inject.Inject

class SmileFactory @Inject constructor() {
    private val imageIdList = listOf(R.drawable.smile1, R.drawable.smile2, R.drawable.smile3,
        R.drawable.smile4, R.drawable.smile5, R.drawable.smile6, R.drawable.smile7,
        R.drawable.smile8, R.drawable.view1)
    fun create (id: Int)  = Smile(id, "Smile $id", imageIdList[id%8])
}