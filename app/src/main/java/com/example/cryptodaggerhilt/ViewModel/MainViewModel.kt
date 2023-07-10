package com.example.cryptodaggerhilt.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptodaggerhilt.RetrofitRepository
import com.example.cryptodaggerhilt.model.CryptoModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RetrofitRepository) : ViewModel() {

    var liveData : MutableLiveData<List<CryptoModelItem>>? = null

    init {
        liveData = MutableLiveData()
    }

    fun getLiveDataObserver () :MutableLiveData<List<CryptoModelItem>>?{
        return liveData
    }

    fun loadData()  {
        return repository.getPosts(liveData!!)
    }

}