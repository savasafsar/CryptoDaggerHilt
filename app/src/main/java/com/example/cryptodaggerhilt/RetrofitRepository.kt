package com.example.cryptodaggerhilt

import androidx.lifecycle.MutableLiveData
import com.example.cryptodaggerhilt.model.CryptoModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val retrofitServiceInstance: RetrofitServiceInstance) {
    fun getPosts(liveData: MutableLiveData<List<CryptoModelItem>>)
    {
        val call : Call<List<CryptoModelItem>> = retrofitServiceInstance.getCrypto()
        call.enqueue(object : Callback<List<CryptoModelItem>>{
            override fun onResponse(call: Call<List<CryptoModelItem>>, response: Response<List<CryptoModelItem>>) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body())
                }
                else {
                    liveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<CryptoModelItem>>, t: Throwable) {
                liveData.postValue(null)

            }

        })

    }
}