package com.project.dombaapps.di.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QRRequestKambing {
    @SerializedName("no_kam")
    @Expose
    var no_kam : String? = null
}