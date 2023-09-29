package com.omersungur.binancemainpage.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.omersungur.binancemainpage.R
import com.omersungur.binancemainpage.data.entity.CryptoCoin
import com.omersungur.binancemainpage.databinding.CoinRowBinding

class CoinAdapter(
    private val mContext: Context,
    private val coinList: List<CryptoCoin>
) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    class CoinViewHolder(val binding: CoinRowBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = CoinRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinList[position]
        val t = holder.binding

        t.tvCoinName.text = coin.name
        /*val pricee = item.price.toString().map {
            NumberFormat.getCurrencyInstance().format(it)
        }.toString()
        println(pricee)*/


        t.tvTextPrice.text = "$${coin.price}"

        if (coin.changeValue > 0) {
            val greenColor = ContextCompat.getColor(mContext, R.color.green)
            t.ButtonCoinPriceChange.backgroundTintList = ColorStateList.valueOf(greenColor)
            t.ButtonCoinPriceChange.text = "+${coin.changeValue}%"
        }
        else if (coin.changeValue < 0) {
            val redColor = ContextCompat.getColor(mContext, R.color.red)
            t.ButtonCoinPriceChange.backgroundTintList = ColorStateList.valueOf(redColor)
            t.ButtonCoinPriceChange.text = "${coin.changeValue}%"
        }
        else {
            val grayColor = ContextCompat.getColor(mContext, R.color.gray)
            t.ButtonCoinPriceChange.backgroundTintList = ColorStateList.valueOf(grayColor)
            t.ButtonCoinPriceChange.text = "${coin.changeValue}%"
        }

        val currency = coin.currencyConverter(coin.price)
        val formattedCurrency = String.format("%.2f", currency)
        t.tvTextPriceCurrency.text = "₺${formattedCurrency}"
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
}