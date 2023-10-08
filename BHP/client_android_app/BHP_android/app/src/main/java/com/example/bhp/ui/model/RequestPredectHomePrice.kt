package com.example.bhp.ui.model

import com.google.gson.annotations.SerializedName

data class RequestPredectHomePrice(

	@field:SerializedName("total_sqft")
	val totalSqft: String? = null,

	@field:SerializedName("bhk")
	val bhk: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("bath")
	val bath: String? = null
)
