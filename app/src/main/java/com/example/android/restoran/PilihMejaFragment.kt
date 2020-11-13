package com.example.android.restoran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.restoran.databinding.FragmentPilihMejaBinding
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_pilih_meja.view.*


class PilihMejaFragment : Fragment() {

   private lateinit var binding: FragmentPilihMejaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pilih_meja, container, false)

       binding.mejasatu.setOnClickListener {
           view : View ->
            view.findNavController().navigate(PilihMejaFragmentDirections
                .actionPilihMejaFragmentToMenuFragment("Meja 1"))
       }
       binding.mejadua.setOnClickListener { view: View ->
            view.findNavController().navigate(PilihMejaFragmentDirections
                .actionPilihMejaFragmentToMenuFragment("Meja 2"))
        }
        binding.mejatiga.setOnClickListener {
               view : View ->
            view.findNavController().navigate(PilihMejaFragmentDirections
                .actionPilihMejaFragmentToMenuFragment("Meja 3"))
       }
        binding.mejaempat.setOnClickListener {
               view : View ->
          view.findNavController().navigate(PilihMejaFragmentDirections
              .actionPilihMejaFragmentToMenuFragment("Meja 4"))
       }

       return binding.root
    }
}