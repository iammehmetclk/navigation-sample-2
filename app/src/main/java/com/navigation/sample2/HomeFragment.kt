package com.navigation.sample2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var callback: OnBackPressedCallback? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(requireContext(), "Press back to exit.", Toast.LENGTH_LONG).show()
            remove()
        }
    }

    override fun onDestroyView() {
        callback?.remove()
        super.onDestroyView()
    }
}