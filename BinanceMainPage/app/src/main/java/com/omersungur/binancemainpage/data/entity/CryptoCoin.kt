package com.omersungur.binancemainpage.data.entity

data class CryptoCoin(
    val id: Int,
    val name: String,
    var price: Double,
    var changeValue: Double
)

{
    fun currencyConverter(valueOfMoney: Double): Double {
        var newValue = 0.0
        newValue = price * 27.15
        return newValue
    }
}