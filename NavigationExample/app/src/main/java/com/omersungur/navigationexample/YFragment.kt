package com.omersungur.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.omersungur.navigationexample.databinding.FragmentYBinding

class YFragment : Fragment() {

    private lateinit var binding: FragmentYBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayQuitQuestion()

    }

    private fun displayQuitQuestion() {

        val bundle: YFragmentArgs by navArgs()
        val key = bundle.key

        if (key != 10) { // 10'a eşitse B fragmentından gelinmiştir ve bu fonksiyon çalışmamalıdır.
            val pressBack = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Snackbar.make(
                        binding.textViewYFragment,
                        "Do you want to go main page?",
                        Snackbar.LENGTH_INDEFINITE
                    )
                        .setAction("YES") {
                            isEnabled = false
                            requireActivity().onBackPressedDispatcher.onBackPressed()
                        }.show()
                }
            }

            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, pressBack)
        }
    }
}