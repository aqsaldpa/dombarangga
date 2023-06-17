package com.project.dombaapps.di.model


data class modelSapi(
    val result: ArrayList<dataSapi>
) {
    data class dataSapi(
        val brt: String,
        val hrg: String,
        val jns: String,
        val nam_sapi: String,
        val no_sapi: String,
        val pkn: String,
        val us: String,
        val vksn: String,
        val path_gbr: String
    )
}


