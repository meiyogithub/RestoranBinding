package com.example.android.restoran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.restoran.databinding.FragmentBayarBinding

class BayarFragment : Fragment() {
    private lateinit var binding: FragmentBayarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bayar, container, false)
        val args = BayarFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            product1 = args.productSatu
            product2 = args.productDua
            product3 = args.productTiga
            totalBayar = args.total
            nomorMeja = args.nomorMeja

            buttonKembali2.setOnClickListener {
                view : View ->
                view.findNavController().popBackStack()
            }

            buttonKembali1.setOnClickListener {
                view : View ->
                view.findNavController().navigate(BayarFragmentDirections.actionBayarFragmentToPilihMejaFragment())
            }
        }

        return binding.root
    }
}