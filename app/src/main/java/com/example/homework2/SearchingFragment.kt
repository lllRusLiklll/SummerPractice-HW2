package com.example.homework2

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework2.databinding.FragmentSearchingBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class SearchingFragment : Fragment(R.layout.fragment_searching) {

    private var _binding: FragmentSearchingBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSearchingBinding.bind(view)
        initPref()
    }

    private fun initPref() {
        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE) ?: return
        val value = pref.getString("PREF_TEXT", "error").orEmpty()
        binding.root.showSnackbar(value)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun View.showSnackbar(
        message: String,
        @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG
    ) {
        Snackbar.make(
            this,
            message,
            duration
        ).show()
    }
}