package com.example.android.restoran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.restoran.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    lateinit var productSatu: Product
    lateinit var productDua: Product
    lateinit var productTiga: Product
    private var total = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        binding.apply {
            val args = MenuFragmentArgs.fromBundle(requireArguments())
            nomorMeja = args.nomorMeja

            hitungButton.setOnClickListener { view : View ->
                ambilData(binding)
                view.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToBayarFragment(productSatu, productDua, productTiga, args.nomorMeja, total))
            }

            binding
            return binding.root
        }
    }

    private fun ambilData(binding: FragmentMenuBinding){
        total = 0
        productSatu = Product()
        productDua = Product()
        productTiga = Product()

        binding.apply {
            if (namaMakanan1.text.toString() != "" && jumlahMakanan1.text.toString() != "" && hargaMakanan1.text.toString() != ""){
                productSatu.namaMenu = namaMakanan1.text.toString()
                productSatu.hargaMenu = hargaMakanan1.text.toString().toInt()
                productSatu.jumlahMenu = jumlahMakanan1.text.toString().toInt()
                total += productSatu.subtotal
            }
            if (namaMakanan2.text.toString() != "" && jumlahMakanan2.text.toString() != "" && hargaMakanan2.text.toString() != ""){
                productDua.namaMenu = namaMakanan2.text.toString()
                productDua.hargaMenu = hargaMakanan2.text.toString().toInt()
                productDua.jumlahMenu = jumlahMakanan2.text.toString().toInt()
                total += productDua.subtotal
            }
            if (namaMakanan3.text.toString() != "" && jumlahMakanan3.text.toString() != "" && hargaMakanan3.text.toString() != "") {
                productTiga.namaMenu = namaMakanan3.text.toString()
                productTiga.hargaMenu = hargaMakanan3.text.toString().toInt()
                productTiga.jumlahMenu = jumlahMakanan3.text.toString().toInt()
                total += productTiga.subtotal
            }
        }
    }
}