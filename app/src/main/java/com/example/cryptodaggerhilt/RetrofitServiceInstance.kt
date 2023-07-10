package com.example.cryptodaggerhilt

import com.example.cryptodaggerhilt.model.CryptoModelItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInstance {
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getCrypto() : Call<List<CryptoModelItem>>
}