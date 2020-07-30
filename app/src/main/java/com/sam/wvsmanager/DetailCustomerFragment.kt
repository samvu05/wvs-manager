package com.sam.wvsmanager

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.fragment_detail_customer.*
import kotlinx.android.synthetic.main.home_item.*

class DetailCustomerFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail_customer)

        edt_add_address.isEnabled = false
        edt_add_facebook.isEnabled = false
        edt_add_name.isEnabled = false
        edt_add_sdt.isEnabled = false
        radio_kieu_vi.isEnabled = false
        checkbox_da_gui_hang.isEnabled = false
        checkbox_da_may_xong.isEnabled = false
        checkbox_da_thanh_toan.isEnabled = false

        btn_add_a_customer.setOnClickListener {
            this.onStop()
        }
        edt_add_name.hint=intent.getStringExtra("key")

        btn_edit_customer.setOnClickListener {
            edt_add_address.isEnabled = true
            edt_add_facebook.isEnabled = true
            edt_add_name.isEnabled = true
            edt_add_sdt.isEnabled = true
            radio_kieu_vi.isEnabled = true
            checkbox_da_gui_hang.isEnabled = true
            checkbox_da_may_xong.isEnabled = true
            checkbox_da_thanh_toan.isEnabled = true
        }
    }


}