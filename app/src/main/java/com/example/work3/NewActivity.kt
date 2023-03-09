package com.example.work3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.work3.uitel.getProgessDrawable
import com.example.work3.uitel.loadImage
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        //get Data
        val medicineIntent = intent
        val medicineName = medicineIntent.getStringExtra("name")
        val medicineInfo = medicineIntent.getStringExtra("info")
        val medicineImg = medicineIntent.getStringExtra("img")

        //call text and images
        name.text = medicineName
        info.text = medicineInfo
        img.loadImage(medicineImg, getProgessDrawable(this))
    }
}
