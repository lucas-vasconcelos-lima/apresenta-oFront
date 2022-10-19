package com.example.doesaude

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.doesaude.databinding.FragmentMeuPerfilBinding
import com.example.doesaude.databinding.FragmentSuporteBinding


class suporteFragment : Fragment() {

    private lateinit var binding: FragmentSuporteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         binding = FragmentSuporteBinding.inflate(layoutInflater, container, false)

        binding.buttonVoltarStoL.setOnClickListener {
            findNavController().navigate(R.id.action_suporteFragment_to_listFragment)
        }

        return binding.root
    }
}