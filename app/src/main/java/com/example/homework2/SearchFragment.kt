package com.example.homework2

import android.os.Bundle
import android.content.Context
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework2.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() =_binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)
        val classInfo: String = "Called from ${javaClass.simpleName}"
        with (binding) {
            btnSearch.setOnClickListener {
                val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE)
                pref?.edit {
                    putString("PREF_TEXT", classInfo)
                    commit()
                }
                findNavController().navigate(
                    R.id.action_searchFragment_to_searchingFragment
                )
            }
        }
    }
}