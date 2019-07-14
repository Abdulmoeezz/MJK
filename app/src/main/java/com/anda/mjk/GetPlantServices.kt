package com.anda.mjk


import com.anda.mjk.dto.PlantList
import retrofit2.Call
import retrofit2.http.GET

interface GetPlantServices {

    @GET("/perl/mobile/viewplantsjson.pl?Combined_Name=e")
    fun getallplants(): Call<PlantList>
}