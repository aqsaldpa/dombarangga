package com.project.dombaapps.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.dombaapps.R
import com.project.dombaapps.di.model.modelSapi
import com.project.dombaapps.svc.ApiUtills
import com.project.dombaapps.ui.adapter.DataSapiAdapter
import kotlinx.android.synthetic.main.activity_data_kambing.pb
import kotlinx.android.synthetic.main.activity_data_sapi.rvSapi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DataSapiActivity : AppCompatActivity() {
    private lateinit var datasapiadapter: DataSapiAdapter
    private val TAG: String = "AdminPageActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_sapi)
        getDataFromAPISapi()
        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        datasapiadapter = DataSapiAdapter(arrayListOf())
        rvSapi.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = datasapiadapter
        }
    }

    private fun getDataFromAPISapi() {
        pb.visibility = View.VISIBLE
        ApiUtills().getUserService().getAllDataSapi()
            .enqueue(object : Callback<List<modelSapi.dataSapi>> {
                override fun onResponse(
                    call: Call<List<modelSapi.dataSapi>>,
                    response: Response<List<modelSapi.dataSapi>>
                ) {
                    pb.visibility = View.GONE
                    if (response.isSuccessful) {
                        val result = response.body()
                        printLog(result.toString())
                        showDataSapi(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<modelSapi.dataSapi>>, t: Throwable) {
                    pb.visibility = View.GONE
                    printLog(t.toString())
                }
            })
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showDataSapi(data: List<modelSapi.dataSapi>) {
        datasapiadapter.setData(data)
    }
}