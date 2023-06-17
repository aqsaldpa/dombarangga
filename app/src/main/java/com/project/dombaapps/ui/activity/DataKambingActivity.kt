package com.project.dombaapps.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.dombaapps.svc.ApiUtills
import com.project.dombaapps.ui.adapter.DataKambingAdapter
import com.project.dombaapps.R
import com.project.dombaapps.di.model.modelKambing
import kotlinx.android.synthetic.main.activity_data_kambing.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DataKambingActivity : AppCompatActivity() {
    private lateinit var datakambingadapter: DataKambingAdapter
    private val TAG: String = "AdminPageActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_kambing)
        getDataFromAPIKambing()
        setupRecyclerView()
        val type: String = intent.getStringExtra("type").toString()
        titleList.text = type
    }


    private fun setupRecyclerView() {
        datakambingadapter = DataKambingAdapter(arrayListOf())
        rvKambing.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = datakambingadapter
        }
    }

    private fun getDataFromAPIKambing() {
        pb.visibility = View.VISIBLE
        ApiUtills().getUserService().getAllDataKambing()
            .enqueue(object : Callback<List<modelKambing.dataKambing>> {
                override fun onResponse(
                    call: Call<List<modelKambing.dataKambing>>,
                    response: Response<List<modelKambing.dataKambing>>
                ) {
                    pb.visibility = View.GONE
                    if (response.isSuccessful) {
                        val result = response.body()
                        printLog(result.toString())
                        showDataKambing(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<modelKambing.dataKambing>>, t: Throwable) {
                    pb.visibility = View.GONE
                    printLog(t.toString())
                }
            })
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showDataKambing(data: List<modelKambing.dataKambing>) {
        datakambingadapter.setData(data)
    }
}
