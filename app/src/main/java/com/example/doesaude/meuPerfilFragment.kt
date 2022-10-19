package com.example.doesaude

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.doesaude.databinding.FragmentMeuPerfilBinding


class meuPerfilFragment : Fragment() {

    private lateinit var binding: FragmentMeuPerfilBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentMeuPerfilBinding.inflate(layoutInflater, container, false)

        binding.buttonVoltarPtoL.setOnClickListener {
            findNavController().navigate(R.id.action_meuPerfilFragment_to_listFragment)
        }

        return binding.root

    }




}