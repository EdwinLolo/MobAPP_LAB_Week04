package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CafeDetailFragment : Fragment() {
    private var contentResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            contentResId = it.getInt("description")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.content_description)?.text = contentResId?.let {
            getString(it)
        } ?: getString(R.string.default_description)
    }

    companion object {
        fun newInstance(contentResId: Int) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt("description", contentResId)
                }
            }
    }
}
