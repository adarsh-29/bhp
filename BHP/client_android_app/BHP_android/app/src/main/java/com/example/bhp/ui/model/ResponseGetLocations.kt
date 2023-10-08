package com.example.bhp.ui.model

import com.google.gson.annotations.SerializedName

data class ResponseGetLocations(

	@field:SerializedName("locations")
	val locations: List<String?>? = null
)
