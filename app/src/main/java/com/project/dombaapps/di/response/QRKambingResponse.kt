package com.project.dombaapps.di.response

import com.google.gson.annotations.SerializedName

data class QRKambingResponse(

	@SerializedName("nam_kam")
	val namKam: String? = null,

	@SerializedName("pkn")
	val pkn: String? = null,

	@SerializedName("brt")
	val brt: String? = null,

	@SerializedName("no_kam")
	val noKam: String? = null,

	@SerializedName("vksn")
	val vksn: String? = null,

	@SerializedName("hrg")
	val hrg: String? = null,

	@SerializedName("jns")
	val jns: String? = null,

	@SerializedName("us")
	val us: String? = null
)
