package com.zfuncode.sharedprefexample.flow

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.zfuncode.sharedprefexample.R
import com.zfuncode.sharedprefexample.databinding.FragmentRegistBinding

class RegistFrag : Fragment() {

    lateinit var binding : FragmentRegistBinding
    lateinit var sharedPrefe : SharedPreferences
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefe = requireContext().getSharedPreferences("dataregist", Context.MODE_PRIVATE)

        binding.tvLogin.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_registFrag_to_loginFragment)
        }

        binding.btnRegister.setOnClickListener{
            doRegister()
        }
    }

    fun doRegister(){
        val name =binding.etNama.text.toString()
        val username = binding.etUsername.text.toString()
        val pass = binding.etPassword.text.toString()

        val registPref = sharedPrefe.edit()
        registPref.putString("name", name)
        registPref.putString("username", username)
        registPref.putString("password", pass)
        registPref.apply()
        Toast.makeText(context,"Register Success", Toast.LENGTH_SHORT).show()
//        Navigation.findNavController(requireView()).navigate(R.id.action_registFrag_to_loginFragment)
    }


}