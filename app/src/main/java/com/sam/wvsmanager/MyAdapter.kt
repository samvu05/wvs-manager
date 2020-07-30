package com.sam.wvsmanager

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_item.view.*
import kotlin.concurrent.fixedRateTimer

class MyAdapter(private val myDataset: List<Customer>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.tv_rccitem_name
        val addText = itemView.tv_rccitem_add
        val typeText =
            itemView.tv_rccitem_type // Neu gan gia tri truc tiep nhu *Point 1 thi khong can dong nay
        val status = itemView.tv_rccitem_status

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false) as View
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = myDataset.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = myDataset[position]
        holder.nameText.text = currentItem.name
        holder.addText.text = currentItem.adress
        holder.itemView.tv_rccitem_type.text = currentItem.type //Point 1
        holder.itemView.tv_rccitem_status.text = currentItem.status  //Point 2

        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, "Clicked : " + position, Toast.LENGTH_SHORT).show()
//            openDetailFragment(DetailCustomerFragment(),it)
            val tempIntent =
                Intent(it.context, DetailCustomerFragment().javaClass).putExtra("key", currentItem.name)
            it.context.startActivity(tempIntent)
        }
        holder.itemView.setOnLongClickListener { it ->
            Toast.makeText(it.context, "Long clicked", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(it.context)
            builder.apply {
                setPositiveButton("Xoa khach hang",
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(it.context, "Da xoa khach hang", Toast.LENGTH_SHORT).show()
                    })
                setNegativeButton("Thoat",
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(it.context, "Da thoat", Toast.LENGTH_SHORT).show()
                        // User cancelled the dialog
                    })
            }
            builder.create()


            true
        }
    }

    private fun openDetailFragment(someFragment: Fragment, view: View) {
        val activity = view.context as AppCompatActivity
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.layout_main_container, someFragment).addToBackStack(null)
            .commit()

    }
}