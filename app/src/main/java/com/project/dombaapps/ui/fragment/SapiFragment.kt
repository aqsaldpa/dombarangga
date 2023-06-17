package com.project.dombaapps.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.dombaapps.R
import com.project.dombaapps.ui.activity.DataSapiActivity
import com.project.dombaapps.ui.activity.ScanKambingActivity
import com.project.dombaapps.ui.activity.ScanSapiActivity
import kotlinx.android.synthetic.main.fragment_sapi.btnToAdmin
import kotlinx.android.synthetic.main.fragment_sapi.btnscan


class SapiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sapi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnToAdmin.setOnClickListener {
            val intent = Intent(activity, DataSapiActivity::class.java)
            intent.putExtra("type", "List Daftar Sapi")
            startActivity(intent)
        }
        btnscan.setOnClickListener {
            val intent = Intent(activity, ScanSapiActivity::class.java)
            intent.putExtra("type", "Scan Barcode Sapi")
            intent.putExtra("type", "Scan Barcode Sapi")
            intent.putExtra("nama", "Nama Sapi")
            intent.putExtra("jns", "Jenis Sapi")
            intent.putExtra("vks", "Vaksin Sapi")
            intent.putExtra("umr", "Umur Sapi")
            intent.putExtra("bb", "Berat Sapi")
            intent.putExtra("pkn", "Pakan Sapi")
            intent.putExtra("hrg", "Harga Sapi")
            startActivity(intent)
        }
    }

}