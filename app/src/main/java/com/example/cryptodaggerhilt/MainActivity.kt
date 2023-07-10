package com.example.cryptodaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptodaggerhilt.ViewModel.MainViewModel
import com.example.cryptodaggerhilt.adapter.CryptoAdapter
import com.example.cryptodaggerhilt.databinding.ActivityMainBinding
import com.example.cryptodaggerhilt.model.CryptoModelItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cryptoAdapter: CryptoAdapter

    val viewModel by lazy {
        ViewModelProvider(this,defaultViewModelProviderFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        prepareRecyclerView()

        viewModel.getLiveDataObserver()?.observe(this,object :Observer<List<CryptoModelItem>>{
            override fun onChanged(t: List<CryptoModelItem>?) {
                if (t !=null){
                    cryptoAdapter.setList(t)
                    cryptoAdapter.notifyDataSetChanged()
                }
            }

        })

        viewModel.loadData()

    }

    private fun prepareRecyclerView() {
        val recyclerView = binding.recyclerView
        cryptoAdapter = CryptoAdapter()
        recyclerView.adapter = cryptoAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }
}