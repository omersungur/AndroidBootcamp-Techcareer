package com.omersungur.binancemainpage.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.omersungur.binancemainpage.R
import com.omersungur.binancemainpage.adapter.CoinAdapter
import com.omersungur.binancemainpage.data.entity.CryptoCoin
import com.omersungur.binancemainpage.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coinList = ArrayList<CryptoCoin>()
        val coin1 = CryptoCoin(1,"BTC",26554.10,5.43)
        val coin2 = CryptoCoin(2,"BNB",215.7,4.58)
        val coin3 = CryptoCoin(3,"ETH",1670.0,8.85)
        val coin4 = CryptoCoin(4,"XRP",0.5318,-18.64)
        val coin5 = CryptoCoin(5,"SXP",0.2875,-1.17)
        val coin6 = CryptoCoin(6,"DOGE",0.06198,0.0)
        val coin7 = CryptoCoin(6,"TRX",0.08873,3.64)
        val coin8 = CryptoCoin(6,"SOL",20.16,4.95)
        val coin9 = CryptoCoin(6,"ALGO",0.1000,3.73)
        val coin10 = CryptoCoin(6,"NEO",7.29,2.28)

        coinList.add(coin1)
        coinList.add(coin2)
        coinList.add(coin3)
        coinList.add(coin4)
        coinList.add(coin5)
        coinList.add(coin6)
        coinList.add(coin7)
        coinList.add(coin8)
        coinList.add(coin9)
        coinList.add(coin10)

        binding.rvCrypto.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCrypto.adapter = CoinAdapter(requireContext(),coinList)
    }
}