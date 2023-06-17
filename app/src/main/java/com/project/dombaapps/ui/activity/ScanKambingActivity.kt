package com.project.dombaapps.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ScanMode
import com.project.dombaapps.svc.ApiUtills
import com.project.dombaapps.di.request.QRRequestKambing
import com.project.dombaapps.di.response.QRKambingResponse
import com.project.dombaapps.databinding.ActivityScanKambingBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScanKambingActivity : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner
    private lateinit var binding: ActivityScanKambingBinding
    private lateinit var result: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanKambingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val scannerView = binding.scannerView
        val hasil = binding.tvhasil

        codeScanner = CodeScanner(this, scannerView)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false

        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                result = it.text
                hasil.text = result
                scanned()
            }
        }

        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

        val type: String = intent.getStringExtra("type").toString()
        val nama: String = intent.getStringExtra("nama").toString()
        val jns: String = intent.getStringExtra("jns").toString()
        val vks: String = intent.getStringExtra("vks").toString()
        val umr: String = intent.getStringExtra("umr").toString()
        val bb: String = intent.getStringExtra("bb").toString()
        val pkn: String = intent.getStringExtra("pkn").toString()
        val hrg: String = intent.getStringExtra("hrg").toString()

        binding.titleScan.text = type
        binding.namatype.text = nama
        binding.jns.text = jns
        binding.vaksintype.text = vks
        binding.umurtype.text = umr
        binding.bbtype.text = bb
        binding.pakantype.text = pkn
        binding.hargatype.text = hrg
    }


    private fun scanned() {
        val request = QRRequestKambing()
        request.no_kam = binding.tvhasil.text.trim().toString()
        val retro = ApiUtills().getUserService()
        retro.scan(result)?.enqueue(object : Callback<QRKambingResponse> {
            override fun onResponse(
                call: Call<QRKambingResponse>,
                response: Response<QRKambingResponse>
            ) {
                val qr = response.body()
                val namakambing = qr?.namKam
                val nokambing = qr?.noKam
                val jeniskambing = qr?.jns
                val pakankambing = qr?.pkn
                val vaksinkambing = qr?.vksn
                val beratkambing = qr?.brt
                val usiakambing = qr?.us
                val hargakambing = qr?.hrg


                binding.tvhasil.text = "$nokambing"
                binding.tv1.text = "$namakambing"
                binding.tv2.text = "$jeniskambing"
                binding.tv3.text = "$vaksinkambing"
                binding.tv4.text = "$usiakambing"
                binding.tv5.text = "$beratkambing"
                binding.tv6.text = "$pakankambing"
                binding.tv7.text = "$hargakambing"

                Toast.makeText(applicationContext, "Load Berhasil", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<QRKambingResponse>, t: Throwable) {
                Log.e("Error", t.message!!)
            }

        })

    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}