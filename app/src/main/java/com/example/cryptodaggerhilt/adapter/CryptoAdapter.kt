package com.example.cryptodaggerhilt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptodaggerhilt.R
import com.example.cryptodaggerhilt.model.CryptoModelItem

class CryptoAdapter: RecyclerView.Adapter<CryptoAdapter.MyHolderView>() {
    var liveData: List<CryptoModelItem>? = null

    fun setList(data: List<CryptoModelItem>) {
        this.liveData = data
    }

    class MyHolderView(view: View) : RecyclerView.ViewHolder(view) {
        val currencyText: TextView = view.findViewById(R.id.currency)
        val priceText: TextView = view.findViewById(R.id.price)
        fun bindItems(cryptoModelItem : CryptoModelItem) {

            currencyText.text = cryptoModelItem.currency
            priceText.text = cryptoModelItem.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoAdapter.MyHolderView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyHolderView(view)
    }

    override fun onBindViewHolder(holder: CryptoAdapter.MyHolderView, position: Int) {
        holder.bindItems(liveData!!.get(position))
    }

    override fun getItemCount(): Int {
        if (liveData == null)
            return 0
        else
            return liveData!!.size
    }
}