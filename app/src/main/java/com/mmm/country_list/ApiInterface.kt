package com.mmm.country_list

import com.mmm.country_list.Model.CountryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("all")
    fun getcountry():Call<List<CountryModel>>

}