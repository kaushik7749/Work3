package com.example.work3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.work3.databinding.ItemListBinding


class MedicineAdapter (
    var c: Context, var medicineList:ArrayList<MedicineData>
    ): RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>()
    {
        inner class MedicineViewHolder(var v: ItemListBinding): RecyclerView.ViewHolder(v.root){}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
            val inflter = LayoutInflater.from(parent.context)
            val v = DataBindingUtil.inflate<ItemListBinding>(
                inflter, R.layout.item_list,parent,
                false)
            return MedicineViewHolder(v)

        }

        override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
            val newList = medicineList[position]
            holder.v.isMedicine = medicineList[position]
            holder.v.root.setOnClickListener {
                val img = newList.img
                val name = newList.name
                val info = newList.info

                //set Data
                val mIntent = Intent(c,NewActivity::class.java)
                mIntent.putExtra("img",img)
                mIntent.putExtra("name",name)
                mIntent.putExtra("info",info)
                c.startActivity(mIntent)
            }
        }

        override fun getItemCount(): Int {
            return  medicineList.size
        }



    }