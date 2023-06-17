package com.project.dombaapps.di.response

import com.google.gson.annotations.SerializedName

data class QRSapiResponse(

	@SerializedName("nam_sapi")
	val namSapi: String? = null,

	@SerializedName("pkn")
	val pkn: String? = null,

	@SerializedName("brt")
	val brt: String? = null,

	@SerializedName("no_sapi")
	val noSapi: String? = null,

	@SerializedName("vksn")
	val vksn: String? = null,

	@SerializedName("hrg")
	val hrg: String? = null,

	@SerializedName("jns")
	val jns: String? = null,

	@SerializedName("us")
	val us: String? = null
)
