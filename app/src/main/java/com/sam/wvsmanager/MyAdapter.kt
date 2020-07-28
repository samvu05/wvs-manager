package com.sam.wvsmanager

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_item.view.*

class MyAdapter(private  val myDataset: List<Customer>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameText = view.tv_rccitem_name
        val addText = view.tv_rccitem_add
        val typeText = view.tv_rccitem_type
        val status = view.tv_rccitem_status

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item,parent,false) as View
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = myDataset.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myDataset[position]
        holder.nameText.text = currentItem.name
        holder.addText.text = currentItem.adress
        holder.typeText.text = currentItem.type
        holder.status.text = currentItem.status
    }
}