package com.example.work3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var medicineList:ArrayList<MedicineData>
    private lateinit var mAdapter:MedicineAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initialized
        medicineList = ArrayList()
        mAdapter = MedicineAdapter(this,medicineList)
        recyclerMedicine.layoutManager = LinearLayoutManager(this)
        recyclerMedicine.setHasFixedSize(true)
        //getData firebase
        getMedicineData()

    }
    /**ok now create new activity*/


    private fun getMedicineData() {

        mDataBase = FirebaseDatabase.getInstance().getReference("Medicine")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (medicineSnapshot in snapshot.children){
                        val medicine = medicineSnapshot.getValue(MedicineData::class.java)
                        medicineList.add(medicine!!)
                    }
                    recyclerMedicine.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,
                    error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
    //create Adapter

}