package com.project.dombaapps.di.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QRRequestSapi {
    @SerializedName("no_sapi")
    @Expose
    var no_sapi : String? = null
}