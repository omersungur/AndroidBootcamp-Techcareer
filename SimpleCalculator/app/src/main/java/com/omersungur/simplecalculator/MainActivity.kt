package com.omersungur.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.substring
import android.widget.Toast
import com.omersungur.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var resultText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.one.setOnClickListener {
            resultText += "1"
            binding.textViewResult.text = resultText
        }

        binding.two.setOnClickListener {
            resultText += "2"
            binding.textViewResult.text = resultText
        }

        binding.three.setOnClickListener {
            resultText += "3"
            binding.textViewResult.text = resultText
        }

        binding.four.setOnClickListener {
            resultText += "4"
            binding.textViewResult.text = resultText
        }

        binding.five.setOnClickListener {
            resultText += "5"
            binding.textViewResult.text = resultText
        }

        binding.six.setOnClickListener {
            resultText += "6"
            binding.textViewResult.text = resultText
        }

        binding.seven.setOnClickListener {
            resultText += "7"
            binding.textViewResult.text = resultText
        }

        binding.eight.setOnClickListener {
            resultText += "8"
            binding.textViewResult.text = resultText
        }

        binding.nine.setOnClickListener {
            resultText += "9"
            binding.textViewResult.text = resultText
        }

        binding.zero.setOnClickListener {
            resultText += "0"
            binding.textViewResult.text = resultText
        }

        binding.plus.setOnClickListener {
            if (resultText.isEmpty()) { // Eğer direkt olarak + tuşuna basarsak burası çalışacak.
                Toast.makeText(this, "Bir Sayı giriniz!", Toast.LENGTH_SHORT).show()
            } else if (resultText.last() != '+') { // ifade sonunda + işareti varsa tekrardan koymuyoruz.
                resultText += "+"
                binding.textViewResult.text = resultText
            }
        }

        binding.equal.setOnClickListener {
            if (binding.textViewResult.text.isNotEmpty()) {
                val res = sumNumber(binding.textViewResult.text.toString())
                binding.textViewResult.text = res.toString()
                resultText = binding.textViewResult.text.toString()
            }
        }

        binding.clear.setOnClickListener {
            resultText = ""
            binding.textViewResult.text = resultText
        }
    }

    private fun sumNumber(strResult: String): Int {
        var result = 0
        var cleanedResult = strResult // cleanedResult: mantıksız işlemler için logic kurabileceğimiz bir değişken

        if (strResult.endsWith("+")) { // Eğer işlem sonunda + ifadesi varsa o ifade yok sayılır.
            Toast.makeText(
                this,
                "İşlem Sonundaki '+' İfadesi Dikkate Alınmadı!",
                Toast.LENGTH_SHORT
            ).show()
            cleanedResult = strResult.removeSuffix("+")
            binding.textViewResult.text = cleanedResult
        }

        val numbers = cleanedResult.split("+")
        for (number in numbers) {
            result += number.toInt()
        }

        return result
    }
}

/*fun main() {
    sumNumber("3+5+8+9+220+50")
}

fun sumNumber(strResult: String): Int {
    var result = 0
    val numbers = strResult.split("+")
    for (number in numbers) {
        result += number.toInt()
    }
    return result
}*/