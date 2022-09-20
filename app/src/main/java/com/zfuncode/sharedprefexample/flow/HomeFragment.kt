package com.zfuncode.sharedprefexample.flow

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.zfuncode.sharedprefexample.R
import com.zfuncode.sharedprefexample.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    lateinit var getSF : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSF = requireContext().getSharedPreferences("dataregist", Context.MODE_PRIVATE)
        binding.tvHello.text = "Hello,  " + getSF.getString("name","null")

        binding.btnLogout.setOnClickListener{
            doLogout()
        }



    }

    fun doLogout(){
        val dataSF = getSF.edit()
        dataSF.clear()
        dataSF.apply()
        Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_loginFragment)
    }


}