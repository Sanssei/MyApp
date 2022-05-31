package com.example.myapplication

import javax.inject.Inject

data class Smile @Inject constructor(val id: Int, val title: String, val imageResId: Int)
