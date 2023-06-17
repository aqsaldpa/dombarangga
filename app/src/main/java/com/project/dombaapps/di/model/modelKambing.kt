package com.project.dombaapps.di.model


data class modelKambing(
    val result: ArrayList<dataKambing>
) {
    data class dataKambing(
        val brt: String,
        val hrg: String,
        val jns: String,
        val nam_kam: String,
        val no_kam: String,
        val pkn: String,
        val us: String,
        val vksn: String,
        val path_gbr: String
    )
}


