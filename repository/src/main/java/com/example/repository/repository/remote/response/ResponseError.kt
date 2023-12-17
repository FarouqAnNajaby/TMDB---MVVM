package com.example.repository.repository.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseError(

	@field:SerializedName("status_message")
	val statusMessage: String? = null,

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)
