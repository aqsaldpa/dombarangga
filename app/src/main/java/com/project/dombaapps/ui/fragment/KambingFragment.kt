package com.project.dombaapps.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.dombaapps.R
import com.project.dombaapps.ui.activity.DataKambingActivity
import com.project.dombaapps.ui.activity.ScanKambingActivity
import kotlinx.android.synthetic.main.fragment_kambing.btnToAdmin
import kotlinx.android.synthetic.main.fragment_kambing.btnscan


class KambingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_kambing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnToAdmin.setOnClickListener {
            val intent = Intent(activity, DataKambingActivity::class.java)
            intent.putExtra("type", "List Daftar Kambing")
            startActivity(intent)
        }
        btnscan.setOnClickListener {
            val intent = Intent(activity, ScanKambingActivity::class.java)
            intent.putExtra("type", "Scan Barcode Kambing")
            intent.putExtra("nama", "Nama Kambing")
            intent.putExtra("jns", "Jenis Kambing")
            intent.putExtra("vks", "Vaksin Kambing")
            intent.putExtra("umr", "Umur Kambing")
            intent.putExtra("bb", "Berat Kambing")
            intent.putExtra("pkn", "Pakan Kambing")
            intent.putExtra("hrg", "Harga Kambing")
            startActivity(intent)
        }
    }

}