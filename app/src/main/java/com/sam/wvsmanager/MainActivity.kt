package com.sam.wvsmanager

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var myDataset: List<Customer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myDataset = mutableListOf(Customer("", "", "", ""))
        myDataset = geneData(10)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(myDataset)
        recyclerView = findViewById<RecyclerView>(R.id.rc_all_item).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        btn_show_more.setOnClickListener {
            Toast.makeText(it.context, "Da xoa khach hang", Toast.LENGTH_SHORT).show()
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
        }
    }

    private fun geneData(size: Int): List<Customer> {
        val tempList = mutableListOf(Customer("", "", "", ""))
        for (i in 0..size) {
            val temp = Customer(
                "Khach hang thu " + i.toString(),
                "Dia chi so " + i.toString(),
                "Kieu vi " + i.toString(),
                i.toString()
            )
            tempList += temp
        }
        return tempList
    }

}