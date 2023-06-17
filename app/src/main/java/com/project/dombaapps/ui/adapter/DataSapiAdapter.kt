package com.project.dombaapps.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.dombaapps.R
import com.project.dombaapps.di.model.modelSapi
import kotlinx.android.synthetic.main.item_kambing.view.roundedImageView
import kotlinx.android.synthetic.main.item_kambing.view.tv1
import kotlinx.android.synthetic.main.item_kambing.view.tv2
import kotlinx.android.synthetic.main.item_kambing.view.tv3
import kotlinx.android.synthetic.main.item_kambing.view.tv4
import kotlinx.android.synthetic.main.item_kambing.view.tv5
import kotlinx.android.synthetic.main.item_kambing.view.tv6
import kotlinx.android.synthetic.main.item_kambing.view.tv7

class DataSapiAdapter(val dataSapi: ArrayList<modelSapi.dataSapi>) :
    RecyclerView.Adapter<DataSapiAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_sapi, parent, false)
    )

    override fun getItemCount() = dataSapi.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val result = dataSapi[position]
        holder.nama.text = result.nam_sapi
        holder.jenis.text = result.jns
        holder.vaksin.text = result.vksn
        holder.umur.text = result.us
        holder.bb.text = result.brt
        holder.pakan.text = result.pkn
        holder.harga.text = "Rp. ${result.hrg}"
        if (result.path_gbr.isNullOrEmpty()) {
            Glide.with(holder.itemView.context).load(R.drawable.ic_empty).into(holder.img)
        } else {
            Glide.with(holder.itemView.context).load(result.path_gbr).into(holder.img)
        }

    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.tv1
        val jenis = view.tv2
        val vaksin = view.tv3
        val umur = view.tv4
        val bb = view.tv5
        val pakan = view.tv6
        val harga = view.tv7
        val img = view.roundedImageView

    }

    fun setData(data: List<modelSapi.dataSapi>) {
        dataSapi.clear()
        dataSapi.addAll(data)
        notifyDataSetChanged()
    }
}